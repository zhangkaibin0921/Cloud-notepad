package cn.edu.henu.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginSuccessActivity extends AppCompatActivity {

    TextView mTextView,mTextView2,mTextView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.login_success);
        mTextView=findViewById(R.id.main_btn_login);
        mTextView2=findViewById(R.id.textView);
        mTextView3=findViewById(R.id.tuichu);
        mTextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginSuccessActivity.this,LoginActivity.class);

                startActivity(intent);
                finish();
            }
        });
        String s = getIntent().getStringExtra("key");
        mTextView2.setText("欢迎你  "+s);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginSuccessActivity.this,PasswordChangActivity.class);
                intent.putExtra("key",s);

                startActivity(intent);
            }
        });
    }
}

