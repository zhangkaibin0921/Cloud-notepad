package cn.edu.henu.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cn.edu.henu.myapplication.ui.diary.DiaryFragment;

public class Setting extends AppCompatActivity {
    private ImageView left,right;
    private TextView tv_title;
    private int background;
    private LinearLayout layout;
    private SharedPreferences sp;
    private Button changeTheme;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        layout=findViewById(R.id.setting);
        background=R.drawable.background6;
        getBackground();
        left = findViewById(R.id.left);
        tv_title = findViewById(R.id.tv_title);
        right = findViewById(R.id.right);
        right.setImageDrawable(Drawable.createFromPath(""));
        right.setClickable(false);
        tv_title.setText("设置");
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Setting.this.finish();
            }
        });

        changeTheme=findViewById(R.id.changeTheme);
        changeTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Setting.this,SkinActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void getBackground(){
        sp=getSharedPreferences("backgrounds", 0);
        background=sp.getInt("background",background);
        layout.setBackgroundResource(background);
    }
}
