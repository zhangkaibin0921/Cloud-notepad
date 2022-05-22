package cn.edu.henu.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

import androidx.appcompat.app.AppCompatActivity;

import cn.edu.henu.myapplication.LogIn.UserInfoDB;

public class LoginActivity extends AppCompatActivity{

    private TextView mBtnLogin,mBtnRegister;
    private EditText phoneNumber,password;
    private TextView mForgetPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        mBtnLogin= (TextView) findViewById(R.id.btn_login);
        mBtnRegister=(TextView) findViewById(R.id.btn_register);
        mForgetPwd=(TextView) findViewById(R.id.forget);

        phoneNumber=findViewById(R.id.number);
        password=findViewById(R.id.key);
        Bmob.initialize(this, "4c33e339432a88901c207e9a7a7114ee");
        Context context=this;


        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String accountName = phoneNumber.getText().toString().trim();//账号
                final String accountPassword = password.getText().toString().trim();//密码

                if (TextUtils.isEmpty(accountName)) {
                    Toast.makeText(context,"账号不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(accountPassword)) {
                    Toast.makeText(context,"密码不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                //BmobUser类为Bmob后端云提供类
//                BombUser bmobUser = new UserInfoDB();
//                bmobUser.setUsername(accountName);
//                bmobUser.setPassword(accountPassword);
//                bmobUser.login(new SaveListener<BombUser>() {
//                    @Override
//                    public void done(String s, BmobException e) {
//                        if (e == null) {
//
//                            //登录成功后进入主界面
//                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                            startActivity(intent);
//                            finish();
//                        } else {
//                            Toast.makeText(context,""+e.getMessage(), Toast.LENGTH_LONG).show();
//                            //hiddenProgressBar();//隐藏
//                        }
//                    }
//                });

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisteredActivity.class);
                startActivity(intent);
            }
        });

        mForgetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, LoginVertifyActivity.class);
                startActivity(intent);
            }
        });
    }


}

