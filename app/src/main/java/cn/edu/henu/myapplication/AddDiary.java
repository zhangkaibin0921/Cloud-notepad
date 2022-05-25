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

import com.google.android.material.snackbar.Snackbar;

import org.litepal.tablemanager.Connector;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.edu.henu.myapplication.LogIn.UserInfoDB;
import cn.edu.henu.myapplication.db.NoteBook;
import cn.edu.henu.myapplication.ui.diary.DiaryFragment;
import cn.edu.henu.myapplication.NoteAdapter;

import static cn.edu.henu.myapplication.ui.diary.DiaryFragment.adapter;
import static cn.edu.henu.myapplication.ui.diary.DiaryFragment.noteList;

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

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddDiary.this.finish();
            }
        });



        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UserInfoDB.isLogin()){
                    NoteBook note = new NoteBook();
                    String inputContent = content.getText().toString();// 笔记的内容
                    String inputTitle=content_title.getText().toString();
                    note.setTitle(inputTitle);
                    note.setContent(inputContent);


                    note.setAuthor(BmobUser.getCurrentUser(UserInfoDB.class));
                    note.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if (e == null) {
                                Toast.makeText(AddDiary.this,"笔记保存成功",Toast.LENGTH_LONG).show();
                                //成功后提示主界面刷新数据
                                Intent intent = new Intent();
                                setResult(RESULT_OK, intent);
                                //成功后将页面销毁
                                adapter.notifyDataSetChanged();
                                finish();
                            } else {
                                Snackbar.make(view, e.getMessage(), Snackbar.LENGTH_LONG).show();
                            }
                        }
                    });
                }else {
                    Snackbar.make(view, "请先登录", Snackbar.LENGTH_LONG).show();
                }

            }
        });



    }

}