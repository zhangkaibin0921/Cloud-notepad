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
import java.util.Random;

import cn.edu.henu.myapplication.db.NoteBook;
import cn.edu.henu.myapplication.ui.diary.DiaryFragment;

public class AddDiary extends AppCompatActivity {
    private ImageView left,right;
    private TextView tv_title;
    private AppCompatEditText content_title,content;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddiary);
        left=findViewById(R.id.left);
        right=findViewById(R.id.right);
        tv_title=findViewById(R.id.tv_title);
        content=findViewById(R.id.et_content);
        content_title=findViewById(R.id.et_title);
        tv_title.setText("写笔记");





        SQLiteDatabase db = Connector.getDatabase();


        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //NoteSave();
                AddDiary.this.finish();
            }
        });



        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoteSave();
                Toast.makeText(AddDiary.this,"笔记保存成功",Toast.LENGTH_LONG).show();
                finish();
            }
        });



    }


    public void NoteSave(){
        NoteBook note = new NoteBook();
        String inputContent = content.getText().toString();// 笔记的内容
        String inputTitle=content_title.getText().toString();


        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");

        String inputTime = dateFormat.format(calendar.getTime());//getTime();// 笔记的创建时间
        Random r=new Random();
        int inputTag =r.nextInt() ;//getRandom();// 笔记的标识

        note.setTitle(inputTitle);
        note.setContent(inputContent);
        note.setTime(inputTime);
        note.setTag(inputTag);
        note.save();
    }
}