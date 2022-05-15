package cn.edu.henu.myapplication;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.litepal.tablemanager.Connector;

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

    }
}