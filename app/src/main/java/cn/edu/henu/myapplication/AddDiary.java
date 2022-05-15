package cn.edu.henu.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import org.litepal.tablemanager.Connector;

import cn.edu.henu.myapplication.db.NoteBook;
import cn.edu.henu.myapplication.ui.diary.DiaryFragment;

public class AddDiary extends AppCompatActivity {
    private ImageView left;
    private TextView tv_title,tv_forward;
    private AppCompatEditText content_title,content;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddiary);
        left=findViewById(R.id.iv_backward);
        tv_forward=findViewById(R.id.tv_forward);
        tv_title=findViewById(R.id.tv_title);
        content=findViewById(R.id.et_content);
        content_title=findViewById(R.id.et_title);
        tv_title.setText("写笔记");

        SQLiteDatabase db = Connector.getDatabase();


        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddDiary.this.finish();
            }
        });

        tv_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        NoteBook note = new NoteBook();
        String inputContent = content.getText().toString();// 笔记的内容
        String inputTime = "2022";//getTime();// 笔记的创建时间
        int inputTag = 1;//getRandom();// 笔记的标识

        note.setContent(inputContent);
        note.setTime(inputTime);
        note.setTag(inputTag);
        note.save();
    }
}