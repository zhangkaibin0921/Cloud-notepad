package cn.edu.henu.myapplication.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.edu.henu.myapplication.R;


public class TitleLayout extends LinearLayout {
    private ImageView left,right;
    private TextView tv_title;

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LinearLayout bar_title = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.bar_title, this);
        left = (ImageView) bar_title.findViewById(R.id.left);
        tv_title = (TextView) bar_title.findViewById(R.id.tv_title);
        right =  bar_title.findViewById(R.id.right);
        /*if(ActivityCollector.getCurrentActivity().getClass().equals(PersonInfo.class)){
            tv_forward.setText("保存");
            tv_title.setText("编辑资料");
        }
        if(ActivityCollector.getCurrentActivity().getClass().equals(EditName.class)){
            tv_forward.setText("完成");
            tv_title.setText("编辑昵称");
        }*/

        //设置监听器
        //如果点击back则结束活动
        left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
    }
    public ImageView getTextView_forward(){
        return right;
    }
}