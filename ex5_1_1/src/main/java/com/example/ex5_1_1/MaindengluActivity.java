package com.example.ex5_1_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MaindengluActivity extends AppCompatActivity {
    EditText et_account,et_password;
    CheckBox cb_remember;
    TextView tv_register;
    Button bt_login,bt_back;

    SharedPreferences spf;
    SharedPreferences.Editor editor;
    DBOPenHelper dbOpener = new DBOPenHelper(this,"Booking.db",null,1);
    private  static  final  String TAG ="MaindengluActivity";//logt
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maindenglu);

        et_account = (EditText) findViewById(R.id.et_account);
        et_password = (EditText) findViewById(R.id.et_password);
        cb_remember = (CheckBox) findViewById(R.id.cb_remember);
        tv_register = (TextView) findViewById(R.id.tv_register);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_back = (Button) findViewById(R.id.bt_back);
//        点击返回首页
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MaindengluActivity.this,login.class);
                startActivity(intent);
            }
        });
        //必须要有得到对象
        spf = PreferenceManager.getDefaultSharedPreferences(MaindengluActivity.this);
        boolean is_remember = spf.getBoolean("is_remember",false);
        if (is_remember){
            String account = spf.getString("account","");
            String password = spf.getString("password","");
            et_account.setText(account);
            et_password.setText(password);
            cb_remember.setChecked(true);
        }
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = et_account.getText().toString();
                String password = et_password.getText().toString();
                Boolean is_remember = cb_remember.isChecked();
                if (!(TextUtils.isEmpty(account)||TextUtils.isEmpty(password))){
                    SQLiteDatabase db = dbOpener.getReadableDatabase();//打开数据库
                    String sql = "select * from user where account =? and password=?";
                    Cursor cursor = db.rawQuery(sql,new String[]{account,password});
                    if (cursor.moveToFirst()){
                        do {
                            String ac = cursor.getString(cursor.getColumnIndex("account"));
                            String pw = cursor.getString(cursor.getColumnIndex("password"));
                            Log.i(TAG,ac);//logi
                            Log.i(TAG,pw);
                        }while(cursor.moveToNext());
                    }
                    if (cursor.moveToFirst()){
                        editor = spf.edit();//保存数据用editor
                        if (is_remember){
                            editor.putString("account",account);
                            editor.putString("password",password);
                            editor.putBoolean("is_remember",is_remember);
                        }else{
                            editor.clear();
                        }
                        editor.apply();//editor.commit();
                        Toast.makeText(MaindengluActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                        //Intent intent = new Intent(MaindengluActivity.this,CallActivity.class);
                        Intent intent = new Intent(MaindengluActivity.this,MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MaindengluActivity.this, "账号或者密码错误", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MaindengluActivity.this, "账号或者密码为空", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MaindengluActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}

