package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Button register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //todo 数据返回有问题
                String username = ((EditText) findViewById(R.id.username1)).getText().toString();
                String password = ((EditText) findViewById(R.id.password1)).getText().toString();
                String confirm = ((EditText) findViewById(R.id.confirm1)).getText().toString();
                System.out.println("========================="+username+password+confirm);
                intent.putExtra("user",username);
                intent.putExtra("pwd",password);
                intent.putExtra("cfm", confirm);
                setResult(0x717,intent);
                finish();
            }
        });
    }
}
