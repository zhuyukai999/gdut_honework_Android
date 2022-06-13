package com.zyk.experiment1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.zyk.experiment1.base.BaseActivity;

public class ActivityHomepage extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        TextView textView1 = (TextView) findViewById(R.id.textView1_2);
        TextView textView2 = (TextView) findViewById(R.id.textView2_2);
        TextView textView3 = (TextView) findViewById(R.id.textView3_2);
        TextView textView4 = (TextView) findViewById(R.id.textView4_2);
        TextView textView5 = (TextView) findViewById(R.id.textView5_2);
        TextView textView6 = (TextView) findViewById(R.id.textView6_2);
        TextView textView7 = (TextView) findViewById(R.id.textView7_2);

        String userName = getIntent().getStringExtra("username");
        SharedPreferences userInfo = getSharedPreferences(userName, MODE_PRIVATE);
        SharedPreferences.Editor editor = userInfo.edit();//获取Editor
        String password = userInfo.getString("password", null);//获取密码
        String confirmPassword = userInfo.getString("confirmPassword", null);//获取确定密码
        String sex = userInfo.getString("sex", null);//获取性别
        String birthday = userInfo.getString("birthday", null);//获取生日
        String Email = userInfo.getString("Email", null);//获取邮箱
        String phone = userInfo.getString("phone", null);//获取电话

        textView1.setText(userName);
        textView2.setText(password);
        textView3.setText(confirmPassword);
        textView4.setText(sex);
        textView5.setText(birthday);
        textView6.setText(Email);
        textView7.setText(phone);

        buttonClick(R.id.button_home_1, view -> {
            startActivity(new Intent(this, ActivityFruit.class));
        });

        buttonClick(R.id.button_home_2, view -> {
            startActivity(new Intent(this, ActivityWeather.class));
        });
    }
}
