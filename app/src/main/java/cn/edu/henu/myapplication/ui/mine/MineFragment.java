package cn.edu.henu.myapplication.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import cn.edu.henu.myapplication.R;
import cn.edu.henu.myapplication.ui.diary.DiaryFragment;


public class MineFragment extends Fragment {
    private ImageView left,right;
    private TextView tv_title;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.activity_person_info,container,false);
        left=root.findViewById(R.id.left);
        tv_title=root.findViewById(R.id.tv_title);
        right=root.findViewById(R.id.right);
        left.setImageDrawable(Drawable.createFromPath(""));
        right.setImageDrawable(Drawable.createFromPath(""));
        left.setClickable(false);
        right.setClickable(false);

        tv_title.setText("我的");

        return root;
    }
}