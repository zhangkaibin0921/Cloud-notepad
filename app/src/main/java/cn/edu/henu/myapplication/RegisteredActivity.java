package cn.edu.henu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisteredActivity extends AppCompatActivity {

    private ImageView mImgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        mImgBack=(ImageView) findViewById(R.id.imgback);

        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisteredActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
