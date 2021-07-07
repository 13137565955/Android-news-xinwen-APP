package com.example.ex5_1_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private Button login;
    private Button register;
    private ImageView qq;
    private ImageView weixin;
    private ImageView weibo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.bt_login);
        register = (Button) findViewById(R.id.bt_register);
        qq = (ImageView) findViewById(R.id.iv_qq);
        weixin = (ImageView) findViewById(R.id.iv_weixin);
        weibo = (ImageView) findViewById(R.id.iv_weibo);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,MaindengluActivity.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(login.this, "该功能还未实现！！！", Toast.LENGTH_SHORT).show();
            }
        });
        weixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(login.this, "该功能还未实现！！！", Toast.LENGTH_SHORT).show();
            }
        });
        weibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(login.this, "该功能还未实现！！！", Toast.LENGTH_SHORT).show();
            }
        });
    }
}