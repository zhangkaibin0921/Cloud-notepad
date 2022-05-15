package cn.edu.henu.myapplication.ui.mine;

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


public class MineFragment extends Fragment {
    private ImageView left;
    private TextView tv_title,tv_forward;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.activity_person_info,container,false);
        left=root.findViewById(R.id.iv_backward);
        tv_title=root.findViewById(R.id.tv_title);
        tv_forward=root.findViewById(R.id.tv_forward);
        left.setImageDrawable(Drawable.createFromPath(""));
        tv_forward.setText("");
        tv_title.setText("我的");
        return root;


    }

}