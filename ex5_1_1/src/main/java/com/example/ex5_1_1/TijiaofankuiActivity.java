package com.example.ex5_1_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ex5_1_1.database.DBController;

/**
 * 主页面
 *
 * 1.定义属性
 * 2.初始化视图组建
 * 3.下拉框组建设置
 * 4.设置录入按钮的监听
 *      1.获取输入框数据
 *      2.由DBController插入数据
 *
 */
public class TijiaofankuiActivity extends AppCompatActivity {
    private TextView tv_back;
    private Button but_help_feedback;
    //1.定义属性
    Intent intent;

    EditText editText,editText1;
    Button button;

    String cn;
    String en;
    String score;

    DBController dbcontroller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tijiaofankui);

        tv_back = (TextView) findViewById(R.id.tv_back);
        but_help_feedback = (Button) findViewById(R.id.bt_insert);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TijiaofankuiActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        but_help_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TijiaofankuiActivity.this, "感谢你的提交~", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TijiaofankuiActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        //2.初始化视图组建
        editText = (EditText) findViewById(R.id.et_cn);
        editText1 = (EditText) findViewById(R.id.et_sc);

        //3.下拉框组建设置
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                String[] languages = getResources().getStringArray(R.array.languages);
                cn = languages[pos];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        //4.设置录入按钮的监听
        button = (Button) findViewById(R.id.bt_insert);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbcontroller = new DBController(getApplicationContext());

                //1.获取输入框数据
                en = editText.getText().toString();
                score = editText1.getText().toString();

                //2.由DBController插入数据插入数据到数据库
                if(en.isEmpty() || score.isEmpty()) {
                    Toast.makeText(TijiaofankuiActivity.this, "请输入数据", Toast.LENGTH_SHORT).show();
//                    ToastUtil.showMsg(getApplication(),"请输入数据！");
                }else{
                    intoScores(view);
                    dbcontroller.testInsertDate(cn, en, score);
                    editText1.setText("");
                    editText.setText("");
                    editText.requestFocus();
                }
            }
        });
    }
    public void intoScores(View view){
        //通过bundle传输数课程名称给Scores
        intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("cn",cn);
        intent.putExtras(bundle);
        intent.setClass(getApplicationContext(),Scores.class);
        startActivity(intent);
    }
}
