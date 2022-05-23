package cn.edu.henu.myapplication;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Setting extends AppCompatActivity {
    private ImageView left,right;
    private TextView tv_title;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        left = findViewById(R.id.left);
        tv_title = findViewById(R.id.tv_title);
        right = findViewById(R.id.right);
        right.setImageDrawable(Drawable.createFromPath(""));
        right.setClickable(false);
        tv_title.setText("设置");
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    public void changeTheme(View view) {
    }
}
