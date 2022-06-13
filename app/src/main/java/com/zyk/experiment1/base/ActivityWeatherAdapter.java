package com.zyk.experiment1.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zyk.experiment1.R;
import com.zyk.experiment1.domain.Fruit;
import com.zyk.experiment1.domain.Weather;

import java.util.List;

public class ActivityWeatherAdapter extends ArrayAdapter<Weather> {
    private int newResourceId;

    public ActivityWeatherAdapter(Context context, int resourceId, List<Weather> weatherList) {
        super(context, resourceId, weatherList);
        newResourceId = resourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Weather weather = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(newResourceId, parent, false);
        TextView weather_date = (TextView) view.findViewById(R.id.weather_date);
        TextView weather_type = (TextView) view.findViewById(R.id.weather_type);
        TextView weather_wind = (TextView) view.findViewById(R.id.weather_wind);
        TextView weather_temperature = (TextView) view.findViewById(R.id.weather_temperature);
        TextView weather_notice = (TextView) view.findViewById(R.id.weather_notice);

        String text1 = weather.getTime() + "\n" + weather.getWeek();
        weather_date.setText(text1);
        weather_type.setText(weather.getWeatherType());
        weather_wind.setText(weather.getWind());
        weather_temperature.setText(weather.getTemperature());
        weather_notice.setText(weather.getNotice());
        return view;
    }

}
