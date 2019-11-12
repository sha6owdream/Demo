package com.example.shixun;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private TextView register;
    private ShuJuKu shuJuKu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.num);
        password=(EditText)findViewById(R.id.pwd);
        login=(Button)findViewById(R.id.btn);
        register=(TextView)findViewById(R.id.register);
        register.setClickable(true);

        shuJuKu=new ShuJuKu(this,"USER.db",null,1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernum=username.getText().toString();
                String pwd=password.getText().toString();

                SQLiteDatabase db=shuJuKu.getWritableDatabase();
                //从数据库中查询账号和密码
                Cursor cursor = db.query("User", new String[]{"Username", "Password"}, null, null, null, null, null);
                boolean login = false;//账号密码是否匹配
                //从数据库中匹配账号密码
                while (cursor.moveToNext()) {
                    if (usernum.equals(cursor.getString(cursor.getColumnIndex("Username")))
                            && pwd.equals(cursor.getString(cursor.getColumnIndex("Password")))) {
                        login = true;
                        break;
                    }
                }
                //如果账号和密码不为空则判断login的true或false
                if (!usernum.equals("")||!pwd.equals("")){
                    if (login) {
                        Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        //如果正确则跳转到TabHost的模块一
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                    } else {
                        //账号密码在数据库中匹配不成功。即login==false
                        Toast.makeText(MainActivity.this, "账号与密码不匹配", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this,"账号或密码不能为空",Toast.LENGTH_SHORT).show();
                }

            }
        });
        //注册文本的监听事件
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });
    }
}
