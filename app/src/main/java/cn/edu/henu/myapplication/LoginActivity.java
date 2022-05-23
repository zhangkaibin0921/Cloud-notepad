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

import com.google.android.material.snackbar.Snackbar;

import cn.edu.henu.myapplication.LogIn.UserInfoDB;

public class LoginActivity extends AppCompatActivity{

    private TextView mBtnLogin,mBtnRegister;
    private EditText phoneNumber,password;
    private TextView mForgetPwd;
    public  Context context=this;

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



        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(v);
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

    private void login(final View view) {
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
        final UserInfoDB user = new UserInfoDB();
        //此处替换为你的用户名
        user.setUsername(accountName);
        //此处替换为你的密码
        user.setPassword(accountPassword);
        user.login(new SaveListener<UserInfoDB>() {
            @Override
            public void done(UserInfoDB bmobUser, BmobException e) {
                if (e == null) {
                    UserInfoDB user = BmobUser.getCurrentUser(UserInfoDB.class);
                    Snackbar.make(view, "登录成功：" + user.getUsername(), Snackbar.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Snackbar.make(view, "登录失败：" + e.getMessage(), Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

}

