package cn.edu.henu.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cn.bmob.v3.BmobUser;
import cn.edu.henu.myapplication.LogIn.UserInfoDB;

public class PersonInfo extends AppCompatActivity {
    private TextView username;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);

    }
}
