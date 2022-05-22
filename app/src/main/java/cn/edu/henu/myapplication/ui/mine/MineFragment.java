package cn.edu.henu.myapplication.ui.mine;

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

import cn.edu.henu.myapplication.PersonInfo;
import cn.edu.henu.myapplication.R;


public class MineFragment extends Fragment {
    private ImageView left,right;
    private TextView tv_title;
    private TextView mInfor;

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