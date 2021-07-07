package com.example.ex5_1_1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private  EditText et_account,et_password;
    private Button bt_submit;
    DBOPenHelper dbOpener = new DBOPenHelper(RegisterActivity.this,"Booking.db",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_account = (EditText) findViewById(R.id.et_account);
        et_password = (EditText) findViewById(R.id.et_password);
        bt_submit = (Button) findViewById(R.id.bt_submit);

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account =et_account.getText().toString();
                String password=et_password.getText().toString();
                if(TextUtils.isEmpty(account)||TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterActivity.this, "账号或密码为空！", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    //db代表了与数据库的连接，并且可以执行sql语句
                    SQLiteDatabase db = dbOpener.getReadableDatabase();
                    String sql="select * from user where account = ?";
                    Cursor cursor = db.rawQuery(sql,new String[]{account});
                    //游标：开始时指向第一条数据的上方。
                    if (cursor.moveToFirst()){
                        Toast.makeText(RegisterActivity.this, "该账号已经存在！", Toast.LENGTH_SHORT).show();
                    }else{
                        String sql2 = "insert into user (account,password) values (?,?)";
                        db.execSQL(sql2,new String []{account,password});
                        Toast.makeText(RegisterActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                    }
                    db.close();
                }
                dbOpener.close();
                finish();//把当期的注册活动结束掉 就返回到登录了
            }//onClick
        });
    }
}
