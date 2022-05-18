package cn.edu.henu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity{

    private TextView mBtnLogin,mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        mBtnLogin= (TextView) findViewById(R.id.btn_login);
        mBtnRegister=(TextView) findViewById(R.id.btn_register);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
    }


}

