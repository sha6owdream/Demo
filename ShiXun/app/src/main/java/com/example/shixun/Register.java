package com.example.shixun;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private EditText rusername;
    private EditText rpassword;
    private EditText rrpassword;
    private Button register;

    private ShuJuKu shuJuKu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        rusername=(EditText)findViewById(R.id.rnum);
        rpassword=(EditText)findViewById(R.id.rpwd);
        rrpassword=(EditText)findViewById(R.id.rrpwd);
        register=(Button)findViewById(R.id.register);

        shuJuKu=new ShuJuKu(this,"USER.db",null,1);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ruser=rusername.getText().toString();
                String rPwd=rpassword.getText().toString();
                String rrPwd=rrpassword.getText().toString();

                SQLiteDatabase db=shuJuKu.getWritableDatabase();
                ContentValues values=new ContentValues();
                if(rPwd.equals(rrPwd)){
                    if(ruser.equals("")||rPwd.equals("")){
                        Toast.makeText(Register.this,"账号和密码不能为空！",Toast.LENGTH_SHORT).show();
                    }else {
                        Cursor cursor = db.query("User", new String[]{"Username"}, null, null, null, null, null);
                        boolean login = false;//账号密码是否匹配
                        //从数据库中匹配账号密码
                        while (cursor.moveToNext()) {
                            if (ruser.equals(cursor.getString(cursor.getColumnIndex("Username")))) {
                                login = true;
                                break;
                            }
                        }
                        //判断数据库中有没有将要注册的账号，有为true，没有为false
                        if (login) {
                            //数据库中已有该账号，弹出土司提示
                            Toast.makeText(Register.this,"该账号已被注册",Toast.LENGTH_SHORT).show();
                        } else {
                            //数据库中没有该账号，把输入的账号和密码存入数据库
                            values.put("Username",ruser);
                            values.put("Password",rPwd);
                            db.insert("User",null,values);

                            Toast.makeText(Register.this,"注册成功！",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(Register.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }
                }else {
                    Toast.makeText(Register.this,"两次输入密码不一致，请重新输入",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
