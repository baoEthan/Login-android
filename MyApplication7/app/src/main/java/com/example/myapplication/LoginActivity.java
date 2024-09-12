package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private int CODE = 0x717;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button login = (Button) findViewById(R.id.login);
        Button register = (Button) findViewById(R.id.register);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String username = ((EditText) findViewById(R.id.username)).getText().toString();
                String password = ((EditText) findViewById(R.id.password)).getText().toString();
                String confirm = ((EditText) findViewById(R.id.confirm)).getText().toString();
                if (confirm.equals(password) && !username.isEmpty() && !password.isEmpty()) {
                    if (!username.isEmpty()) {
                        //todo: 跳转后的index界面
                        intent.putExtra("username", username);
                        intent.putExtra("password", password);
                        intent.setClass(LoginActivity.this, IndexActivity.class);
                        startActivity(intent);
                    }
                }else if (!confirm.equals(password) && !username.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "两次密码不一样！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
                }
            }
        });





        /*
        注册按钮--跳转到注册界面并返回数据
         */
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent,CODE);
            }
        });
    }


    /*
    对跳转回来的数据进行获取并输出在登录界面
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CODE && resultCode==CODE){
            String user = data.getStringExtra("user");
            String pwd = data.getStringExtra("pwd");
            String cfm = data.getStringExtra("cfm");
            ((EditText) findViewById(R.id.username)).setText(user);
            ((EditText) findViewById(R.id.password)).setText(pwd);
            ((EditText) findViewById(R.id.confirm)).setText(cfm);
        }
    }
}
