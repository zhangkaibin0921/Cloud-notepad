package cn.edu.henu.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;
import cn.edu.henu.myapplication.LogIn.UserInfoDB;
import cn.edu.henu.myapplication.widget.TitleLayout;

public class PersonInfo extends AppCompatActivity {
    EditText ID,username,sex,live_place,birthday;
    TitleLayout titleLayout;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "4c33e339432a88901c207e9a7a7114ee");
        setContentView(R.layout.activity_person_info);
        ID = findViewById(R.id.content_ig_id);
        username = findViewById(R.id.content_ig_name);
        sex = findViewById(R.id.content_ig_gender);
        live_place = findViewById(R.id.content_ig_region);
        birthday = findViewById(R.id.content_ig_brithday);
        titleLayout = findViewById(R.id.tl_title);
        query(titleLayout);
        titleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUser(view);

            }
        });
    }
    private void updateUser(final View view){
        final UserInfoDB user = BmobUser.getCurrentUser(UserInfoDB.class);
        user.setID(ID.getText().toString());
        user.setUsername(username.getText().toString());
        user.setSex(sex.getText().toString());
        user.setLive_place(live_place.getText().toString());
        user.setBirthday(birthday.getText().toString());
        user.update(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Snackbar.make(view, "更新用户信息成功：" , Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(view, "更新用户信息失败：" + e.getMessage(), Snackbar.LENGTH_LONG).show();
                    Log.e("error", e.getMessage());
                }

            }
        });

    }
    private void query(final View view){
        BmobQuery<UserInfoDB> info = new BmobQuery<>();
        UserInfoDB user = BmobUser.getCurrentUser(UserInfoDB.class);
        info.addWhereEqualTo("username",user.getUsername());
        info.findObjects(new FindListener<UserInfoDB>() {
            @Override
            public void done(List<UserInfoDB> list, BmobException e) {
                if(e == null){
                    ID.setText(user.getID());
                    username.setText(user.getUsername());
                    sex.setText(user.getSex());
                    live_place.setText(user.getLive_place());
                    birthday.setText(user.getBirthday());
                }
            }
        });
    }



}
