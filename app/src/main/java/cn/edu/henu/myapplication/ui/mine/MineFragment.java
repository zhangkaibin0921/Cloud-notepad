package cn.edu.henu.myapplication.ui.mine;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import java.security.Timestamp;
import java.util.Calendar;
import java.util.Date;

import cn.bmob.v3.BmobUser;
import cn.edu.henu.myapplication.LogIn.UserInfoDB;
import cn.edu.henu.myapplication.PasswordChangActivity;
import cn.edu.henu.myapplication.PersonInfo;
import cn.edu.henu.myapplication.R;

import static cn.edu.henu.myapplication.ui.diary.DiaryFragment.DiaryCount;


public class MineFragment extends Fragment {
    private ImageView left,right;
    private TextView tv_title;
    private TextView mInfor,noteNumber;

    private LinearLayout mPwdChange,logout;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.mine_layout,container,false);

        mInfor=root.findViewById(R.id.myinformation);

        mInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PersonInfo.class);
                startActivity(intent);
            }
        });

        mPwdChange=root.findViewById(R.id.layout_pwdchange);
        mPwdChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PasswordChangActivity.class);
                startActivity(intent);
            }
        });

        logout=root.findViewById(R.id.layout_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BmobUser.getCurrentUser(UserInfoDB.class).logOut();
                Snackbar.make(view, "退出登录成功", Snackbar.LENGTH_LONG).show();
            }
        });

        left=root.findViewById(R.id.left);
        tv_title=root.findViewById(R.id.tv_title);
        right=root.findViewById(R.id.right);
        left.setImageDrawable(Drawable.createFromPath(""));
        right.setImageDrawable(Drawable.createFromPath(""));
        left.setClickable(false);
        right.setClickable(false);
        noteNumber=root.findViewById(R.id.noteNumber);
        noteNumber.setText(DiaryCount+"篇");

        tv_title.setText("我的");

        Date now = new Date();


        String create=BmobUser.getCurrentUser(UserInfoDB.class).getCreatedAt();

        return root;
    }



}