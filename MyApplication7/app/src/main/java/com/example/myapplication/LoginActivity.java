package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private int CODE1 = 0x717;
    private int CODE2 = 0x718;
    private int[] imageId = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,
            R.drawable.img5, R.drawable.img6,R.drawable.img7, R.drawable.img8, R.drawable.img9};
    int id=-1;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button login = (Button) findViewById(R.id.login);
        Button register = (Button) findViewById(R.id.register);
        Button select = (Button) findViewById(R.id.select);
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
                        //todo:用户和密码的一致性
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
                startActivityForResult(intent,CODE1);
            }
        });
        /*
    头像跳转按钮---选择用户头像
     */
        select.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(LoginActivity.this, HeadImageActivity.class);
                startActivityForResult(intent,CODE2);
            }
        });
    }


    /*
    对跳转回来的数据进行获取并输出在登录界面
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CODE1 && resultCode==CODE1){
            String user = data.getStringExtra("user");
            String pwd = data.getStringExtra("pwd");
            String cfm = data.getStringExtra("cfm");
            ((EditText) findViewById(R.id.username)).setText(user);
            ((EditText) findViewById(R.id.password)).setText(pwd);
            ((EditText) findViewById(R.id.confirm)).setText(cfm);
        }
        if (requestCode == CODE2 && resultCode == CODE2){
            int index = data.getIntExtra("imageId",0);
            ((ImageView) findViewById(R.id.image)).setImageResource(imageId[index]);
            id = index;
        }
    }
}
