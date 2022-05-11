package cn.edu.henu.myapplication;


import android.view.Display;
import android.view.ViewGroup;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.DisplayViewHolder>{
    private List<Display> mDisplayList;

    static class DisplayViewHolder extends RecyclerView.ViewHolder{
        TextView textview;
        View eventView;

        public DisplayViewHolder(View view) {
            super(view);
            eventView = view ;//整个recycleview单元
            textview = view.findViewById(R.id.di_tv);//内部textview部件
        }
    }

    public DisplayAdapter(List<Display> displayList){
        mDisplayList = displayList;
    }

    @Override
    public DisplayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_item, parent, false);
        DisplayViewHolder holder = new DisplayViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(DisplayViewHolder holder, int position) {
        Display display= mDisplayList.get(position);//position为list编号。从0开始

        //下面一句报错了先注释掉
        //holder.textview.setText(display.getContent());
    }

    @Override
    public int getItemCount() {
        return mDisplayList.size();
    }


}
