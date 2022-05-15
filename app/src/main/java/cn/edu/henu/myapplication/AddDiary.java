package cn.edu.henu.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.litepal.tablemanager.Connector;

import cn.edu.henu.myapplication.ui.diary.DiaryFragment;

public class AddDiary extends AppCompatActivity {
    private ImageView left;
    private TextView tv_title,tv_forward;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddiary);
        left=findViewById(R.id.iv_backward);
        tv_forward=findViewById(R.id.tv_forward);
        tv_title=findViewById(R.id.tv_title);
        tv_title.setText("写笔记");


        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddDiary.this.finish();
            }
        });


    }
}