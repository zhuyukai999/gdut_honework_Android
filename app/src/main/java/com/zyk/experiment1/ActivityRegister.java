package com.zyk.experiment1;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.zyk.experiment1.base.BaseActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivityRegister extends BaseActivity {

    public static Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText editText1 = (EditText) findViewById(R.id.editTextTextPersonName1);
        EditText editText2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        EditText editText3 = (EditText) findViewById(R.id.editTextTextPersonName3);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        Button bButton = (Button) findViewById(R.id.register_birthday_button);
        EditText editText6 = (EditText) findViewById(R.id.editTextTextPersonName6);
        EditText editText7 = (EditText) findViewById(R.id.editTextTextPersonName7);

        Calendar calendar = Calendar.getInstance();

        DatePickerDialog dialog = new DatePickerDialog(this, (view, year, month, day) -> {
            Calendar birth = Calendar.getInstance();
            Date  date = birth.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(date);
            bButton.setText(format);
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        buttonClick(R.id.register_birthday_button, view -> {
            dialog.show();
        });

        buttonClick(R.id.button1, view -> {
            String userName = String.valueOf(editText1.getText());//获取用户名
            String password = String.valueOf(editText2.getText());//获取密码
            String confirmPassword = String.valueOf(editText3.getText());//获取确定密码
            RadioButton radiobutton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
            String sex = String.valueOf(radiobutton.getText());//获取性别
            String birthday = String.valueOf(bButton.getText());//生日
            String Email = String.valueOf(editText6.getText());//获取邮箱
            String phone = String.valueOf(editText7.getText());//获取电话
            SharedPreferences userInfo = getSharedPreferences(userName, MODE_PRIVATE);
            SharedPreferences.Editor editor = userInfo.edit();//获取Editor
            /*if (isEmail(Email.trim()) && Email.trim().length()<=31){
                if (!userInfo.contains(userName) && password.equals(confirmPassword)
                        && !userName.equals(userInfo.getString("username", null))
                        && !userName.equals("") && !password.equals("") && radioGroup.getCheckedRadioButtonId() != -1
                        && !birthday.equals("") && !Email.equals("") && !phone.equals("") &&!sex.equals("")) {

                    editor.putString("username", userName);
                    editor.putString("password", password);
                    editor.putString("confirmPassword", confirmPassword);
                    editor.putString("sex", sex);
                    editor.putString("birthday", birthday);
                    editor.putString("Email", Email);
                    editor.putString("phone", phone);
                    editor.commit();
                    new AlertDialog.Builder(this).setTitle("真的").setMessage("注册成功").show();
                } else {
                    new AlertDialog.Builder(this).setTitle("有问题").setMessage("有问题！")
                            .setPositiveButton("确定", null).show();
                }
            }else {
                Toast.makeText(this,"邮箱格式错误", Toast.LENGTH_SHORT).show();
            }*/


        });

        buttonClick(R.id.button2, view -> {
            editText1.setText("");
            editText2.setText("");
            editText3.setText("");
            bButton.setText("选择");
            editText6.setText("");
            editText7.setText("");
        });
    }

    public static boolean isEmail(String email){
        if (null==email || "".equals(email)) return false;
        Matcher m = p.matcher(email);
        return m.matches();
    }


}
