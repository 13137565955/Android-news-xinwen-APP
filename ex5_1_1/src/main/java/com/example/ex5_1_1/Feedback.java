package com.example.ex5_1_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ex5_1_1.fragment.FirstFragment;

public class Feedback extends AppCompatActivity {
    private TextView  tv_one,tv_two,tv_three,tv_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        tv_one = (TextView) findViewById(R.id.tv_one);
        tv_two = (TextView) findViewById(R.id.tv_two);
        tv_three = (TextView) findViewById(R.id.tv_three);
        tv_back = (TextView) findViewById(R.id.tv_back);
        tv_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Feedback.this,Main2Activity.class);
                intent.putExtra("id",0);//其中0表示Fragment的编号，从0开始编，secondFra的编号为1
                startActivity(intent);
            }
        });
        tv_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Feedback.this,Main2Activity.class);
                intent.putExtra("id",1);//其中1表示Fragment的编号，从0开始编，secondFra的编号为1
                startActivity(intent);
            }
        });
        tv_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Feedback.this,Main2Activity.class);
                intent.putExtra("id",2);//其中2表示Fragment的编号，从0开始编，secondFra的编号为1
                startActivity(intent);
            }
        });
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Feedback.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
