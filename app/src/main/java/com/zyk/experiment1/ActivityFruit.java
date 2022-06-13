package com.zyk.experiment1;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.zyk.experiment1.base.ActivityFruitAdapter;
import com.zyk.experiment1.base.ActivityWeatherAdapter;
import com.zyk.experiment1.base.BaseActivity;
import com.zyk.experiment1.domain.Fruit;

import java.util.ArrayList;
import java.util.List;

public class ActivityFruit extends BaseActivity {
    private static final int COMPLETED = 0;
    private ListView fruitList = null;

    private List<Fruit> list = new ArrayList<>();

    //http://47.105.60.171:8086/listfruits

    class MyHandler extends Handler {
        private Context context;

        public void setContext(Context context) {
            this.context = context;
        }

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == COMPLETED) {
                fruitList.setAdapter(new ActivityFruitAdapter(context, R.layout.activity_fruit_item, list));
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_list);

        fruitList = (ListView) findViewById(R.id.fruitList);

        fruitList.setAdapter(new ActivityFruitAdapter(this, R.layout.activity_fruit_item, list));
    }

}
