package cn.edu.henu.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import org.litepal.tablemanager.Connector;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import cn.edu.henu.myapplication.db.NoteBook;
import cn.edu.henu.myapplication.ui.diary.DiaryFragment;

public class UpdateDiary extends AppCompatActivity{
    private ImageView left,right;
    private TextView tv_title;
    private AppCompatEditText content_biaoti,content;
    public String tag_data,lastcontent;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddiary);

        left=findViewById(R.id.left);
        right=findViewById(R.id.right);
        tv_title=findViewById(R.id.tv_title);
        content=findViewById(R.id.et_content);
        content_biaoti=findViewById(R.id.et_title);
        tv_title.setText("写笔记");
        SQLiteDatabase db = Connector.getDatabase();

        Intent intent = UpdateDiary.this.getIntent();
        String content_data = intent.getStringExtra("content_data");
        tag_data = intent.getStringExtra("tag_data");
        String content_title=intent.getStringExtra("title_data");
        content.setText(content_data);
        content_biaoti.setText(content_title);

        lastcontent=content_data;

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //NoteSave();
                UpdateDiary.this.finish();
            }
        });



        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoteUpdate();
                Toast.makeText(UpdateDiary.this,"笔记保存成功",Toast.LENGTH_LONG).show();
            }
        });
    }


    public void NoteUpdate(){
        NoteBook note = new NoteBook();
        String inputTitle=content_biaoti.getText().toString();
        String inputContent = content.getText().toString();// 从文本框获取更改后的笔记内容

        note.setContent(inputContent);
        note.setTitle(inputTitle);
        note.updateAll("content=?",""+lastcontent);
    }

}
