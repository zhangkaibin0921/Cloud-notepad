package cn.edu.henu.myapplication.ui.mine;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.bmob.v3.BmobUser;
import cn.edu.henu.myapplication.CallUs;
import cn.edu.henu.myapplication.LogIn.UserInfoDB;
import cn.edu.henu.myapplication.LoginActivity;
import cn.edu.henu.myapplication.PasswordChangActivity;
import cn.edu.henu.myapplication.PersonInfo;
import cn.edu.henu.myapplication.R;

import static cn.edu.henu.myapplication.ui.diary.DiaryFragment.DiaryCount;


public class MineFragment extends Fragment {

    private ImageView left,right;
    private TextView tv_title;
    private TextView mInfor,noteNumber,userday,mCallUs;


    private LinearLayout mPwdChange;
    private LinearLayout logout;

    private  int background1;
    public static  LinearLayout layout1;
    private  SharedPreferences sp1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.mine_layout,container,false);

        mInfor=root.findViewById(R.id.myinformation);
        layout1=root.findViewById(R.id.mine_layout);
        background1=R.drawable.background6;
        getBackground();

        mInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PersonInfo.class);
                startActivity(intent);
            }
        });

        mCallUs = root.findViewById(R.id.callus);
        mCallUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CallUs.class);
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
                startActivity(new Intent(root.getContext(), LoginActivity.class));
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

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date create = null;
        try {
             create= sdf.parse(BmobUser.getCurrentUser(UserInfoDB.class).getCreatedAt());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int days = (int) ((now.getTime() - create.getTime()) / (1000*3600*24));

        userday=root.findViewById(R.id.userday);
        userday.setText((days+1)+"天");


        return root;
    }

    private void getBackground(){
        sp1=getActivity().getSharedPreferences("backgrounds", 0);
        background1=sp1.getInt("background",background1);
        layout1.setBackgroundResource(background1);

    }



}