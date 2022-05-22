package cn.edu.henu.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.edu.henu.myapplication.LogIn.UserInfoDB;

public class RegisteredActivity extends AppCompatActivity {

    private ImageView mImgBack;
    Button mTextView;
    EditText user_name,phone_number,key_number,re_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "4c33e339432a88901c207e9a7a7114ee");
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.register);
        mImgBack=(ImageView) findViewById(R.id.imgback);

        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisteredActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        user_name = findViewById(R.id.user); //用户名
        phone_number = findViewById(R.id.number); //电话号码
        key_number = findViewById(R.id.key); //密码
        re_key = findViewById(R.id.rekey); //确认密码
        mTextView = findViewById(R.id.main_btn_login_register); // 确认按钮
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserInfoDB user = new UserInfoDB();
                user.setUser_name(user_name.getText().toString());
                user.setPhone(phone_number.getText().toString());
                if(key_number.getText().toString().equals(re_key.getText().toString())){
                    user.setKey_info(key_number.getText().toString());
                }else{
                    Toast.makeText(RegisteredActivity.this,"您两次输入的密码不一致，请重新输入!",Toast.LENGTH_SHORT).show();
                }


                user.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        setResult(RESULT_OK);
                        Toast.makeText(RegisteredActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }
        });
    }
}
