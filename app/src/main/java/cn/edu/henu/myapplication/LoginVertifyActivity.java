package cn.edu.henu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginVertifyActivity extends AppCompatActivity {

    private ImageView mImgBack1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_vertify);
        mImgBack1=(ImageView) findViewById(R.id.imgback1);

        mImgBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginVertifyActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}

