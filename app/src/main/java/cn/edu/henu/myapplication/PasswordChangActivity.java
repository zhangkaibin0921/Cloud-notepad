package cn.edu.henu.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import cn.edu.henu.myapplication.LogIn.UserInfoDB;

public class PasswordChangActivity extends AppCompatActivity {
    EditText key1,re_key1,pwd_user;
    Button btn;
    private ImageView mImgBack2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "4c33e339432a88901c207e9a7a7114ee");
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.password_change);
        pwd_user = findViewById(R.id.pwd_user);
        key1 = findViewById(R.id.key1);
        re_key1 = findViewById(R.id.rekey1);
        btn = findViewById(R.id.btn_pwd_change);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatePassword(view);
            }
        });

        //点击返回到我的页面
        mImgBack2=(ImageView) findViewById(R.id.imgback2);

        mImgBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordChangActivity.this, cn.edu.henu.myapplication.ui.mine.MineFragment.class);
                startActivity(intent);
            }
        });
    }
    /**
     * 提供旧密码修改密码
     */
    private void updatePassword(final View view){
        String oldPwd=key1.getText().toString();
        String newPwd=re_key1.getText().toString();
        //TODO 此处替换为你的旧密码和新密码
        BmobUser.updateCurrentUserPassword(oldPwd, newPwd, new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Snackbar.make(view, "更改密码成功", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(view, "更改密码失败：" + e.getMessage(), Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}

