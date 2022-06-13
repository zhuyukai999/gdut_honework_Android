package com.zyk.experiment1.base;

import android.content.SharedPreferences;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    protected void buttonClick(int id, View.OnClickListener listener) {
        findViewById(id).setOnClickListener(listener);
    }

}
