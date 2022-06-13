package com.zyk.experiment1;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.zyk.experiment1.base.ActivityWeatherAdapter;
import com.zyk.experiment1.base.BaseActivity;
import com.zyk.experiment1.domain.Weather;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ActivityWeather extends BaseActivity {
    private static final int COMPLETED = 0;
    public List<Weather> list = new ArrayList<>();
    private ListView weatherList = null;
    private final MyHandler handler = new MyHandler();

    class MyHandler extends Handler {
        private Context context;

        public void setContext(Context context) {
            this.context = context;
        }

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == COMPLETED) {
                weatherList.setAdapter(new ActivityWeatherAdapter(context, R.layout.activity_weather_item, list));
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);

        weatherList = (ListView) findViewById(R.id.weather_list);
        handler.setContext(this);
        sendRequest();
    }


    private void sendRequest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("http://t.weather.itboy.net/api/weather/city/101280101");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuffer response = new StringBuffer();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    Log.d("activity_weather_list", response.toString());
                    String strBody = response.toString();
                    parseWeatherJson(strBody);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (null != reader) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (null != connection) {
                        //关闭HTTP连接
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    public void parseWeatherJson(String json) {
        try {
            TextView region = (TextView) findViewById(R.id.weather_region);
            TextView temperature_humidity = (TextView) findViewById(R.id.weather_temperature_humidity);
            TextView pm25Quality = (TextView) findViewById(R.id.weather_pm25_quality);
            TextView info = (TextView) findViewById(R.id.weather_info);

            JSONObject jsonObjectALL = new JSONObject(json);
            JSONObject cityInfo = jsonObjectALL.getJSONObject("cityInfo");
            JSONObject data = jsonObjectALL.getJSONObject("data");
            JSONArray forecast = data.getJSONArray("forecast");

            String province = cityInfo.optString("parent", "台湾省");
            String city = cityInfo.optString("city", "台北市");
            String shidu = data.optString("shidu", null);
            String wendu = data.optString("wendu", null);
            String pm25 = data.optString("pm25", null);
            String quality = data.optString("quality", null);
            String ganmao = data.optString("ganmao", null);

            String text1 = province + "\n" + city;
            region.setText(text1);
            String text2 = "温度:" + wendu + "\t" + "湿度:" + shidu;
            temperature_humidity.setText(text2);
            String text3 = "pm2.5:" + pm25 + "\t" + "  空气质量:" + quality;
            pm25Quality.setText(text3);
            info.setText(ganmao);

            for (int i = 0; i < forecast.length(); i++) {
                JSONObject data_ = forecast.getJSONObject(i);
                String time = data_.optString("ymd", null);
                String week = data_.optString("week", null);
                String high = data_.optString("high", null);
                String low = data_.optString("low", null);
                String fx = data_.optString("fx", null);
                String fl = data_.optString("fl", null);
                String type = data_.optString("type", null);
                String notice = data_.optString("notice", null);
                Weather weather = new Weather();
                weather.setTime(time);
                weather.setWeek(week);
                weather.setTemperature(high + "\t" + low);
                weather.setWind("风向:" + fx + "\t" + "风级:" + fl);
                weather.setWeatherType(type);
                weather.setNotice(notice);
                list.add(weather);
            }
            Message msg = new Message();
            msg.what = COMPLETED;
            handler.sendMessage(msg);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
