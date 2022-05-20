package cn.edu.henu.myapplication.register;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.edu.henu.myapplication.R;

//实现注册页面
public class register extends AppCompatActivity {
    EditText mEditText,mEditText2;
    TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.register);
        mEditText=findViewById(R.id.user);
        mEditText2=findViewById(R.id.key);
        mTextView=findViewById(R.id.main_btn_login);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BmobQuery<BmobUser> categoryBmobQuery = new BmobQuery<>();
                categoryBmobQuery.addWhereEqualTo("username", mEditText.getText().toString());
                categoryBmobQuery.findObjects(new FindListener<BmobUser>() {

                    @Override
                    public void done(List<BmobUser> object, BmobException e) {
                        if (e == null) {

                            if (object.size() != 0) {
                                // 点击按钮 代表登录成功
                                Toast.makeText(register.this, "注册失败，账号已存在" + object.size(), Toast.LENGTH_SHORT).show();
                            } else {
                                BmobUser user = new BmobUser();
                                user.setUsername(mEditText.getText().toString());
                                user.setPassword(mEditText2.getText().toString());
                                user.signUp(new SaveListener<BmobUser>() {
                                    @Override
                                    public void done(BmobUser user, BmobException e) {
                                        if (e == null) {
                                            Toast.makeText(register.this, "注册成功！", Toast.LENGTH_SHORT).show();

                                            finish();
                                        } else {
                                            Log.e("注册失败", "原因: ", e);
                                        }

                                    }
                                });

                            }
                        }
                    }
                });
            }
        });

    }
}
