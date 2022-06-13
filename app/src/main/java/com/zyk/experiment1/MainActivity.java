package com.zyk.experiment1;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import com.zyk.experiment1.base.BaseActivity;


public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //登录
        buttonClick(R.id.button_login_1, view -> {
            EditText username_l = (EditText) findViewById(R.id.editTextTextPersonName_login_1);
            String username = String.valueOf(username_l.getText());
            EditText password_l = (EditText) findViewById(R.id.editTextTextPersonName_login_2);
            String password = String.valueOf(password_l.getText());

            SharedPreferences userInfo = getSharedPreferences(username, MODE_PRIVATE);
            String password_real = null;
            if(userInfo.contains("password")){
                password_real = userInfo.getString("password", null);//获取密码
            }
            if(!username.equals("")&&!password.equals("")&&password.equals(password_real)){
                Intent intent = new Intent(this, ActivityHomepage.class);
                intent.putExtra("username", username);
                intent.putExtra("password", password);
                startActivity(intent);
            }else{
                new AlertDialog.Builder(this).setTitle("有问题").setMessage("有问题！")
                        .setPositiveButton("确定", null).show();
            }
        });
        //注册
        buttonClick(R.id.button_login_2, view -> {
            startActivity(new Intent(this, ActivityRegister.class));
        });
    }
}