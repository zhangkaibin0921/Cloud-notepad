package cn.edu.henu.myapplication;

import static cn.bmob.v3.Bmob.getApplicationContext;
import static cn.edu.henu.myapplication.ui.diary.DiaryFragment.adapter;
import static cn.edu.henu.myapplication.ui.diary.DiaryFragment.noteList;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

import org.litepal.crud.DataSupport;
import org.w3c.dom.Text;

import java.util.List;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import cn.edu.henu.myapplication.db.NoteBook;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder>{


    private List<NoteBook> mNoteList;

    static class ViewHolder extends RecyclerView.ViewHolder{

        // 内部类ViewHolder
        View noteView;
        TextView noteTitle;
        TextView noteContent;
        TextView noteTime;

        public ViewHolder(View view){

            // 传入子项的最外层布局
            super(view);
            noteView = view;
            noteTitle=(TextView) view.findViewById(R.id.noteTitle);
            noteContent = (TextView) view.findViewById(R.id.noteContent);// 获取实例
            noteTime = (TextView) view.findViewById(R.id.noteTime);// 获取实例
        }
    }

    public NoteAdapter(List<NoteBook> noteList){

        // 传入需要展示的数据
        mNoteList = noteList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        // 创建ViewHolder实例
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);// 加载布局
        final ViewHolder holder = new ViewHolder(view);

        holder.noteView.setOnClickListener(new View.OnClickListener(){

            // 子项点击事件
            @Override
            public void onClick(View v){


                int position = holder.getAdapterPosition();
                NoteBook note = mNoteList.get(position);

                Intent intent = new Intent(v.getContext(), UpdateDiary.class);
                String contentData = note.getContent();
                String contentTitle=note.getTitle();
                // intent.putExtra("键",数据)
                intent.putExtra("title_data",contentTitle);
                intent.putExtra("content_data", contentData);
                intent.putExtra("objectid",note.getObjectId());
                v.getContext().startActivity(intent);
            }
        });
        holder.noteTime.setOnClickListener(new View.OnClickListener(){

            // 子项点击事件
            @Override
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                NoteBook note = mNoteList.get(position);

                String time = note.getUpdatedAt();
                Toast.makeText(v.getContext(), "笔记创建于" + time, Toast.LENGTH_LONG).show();
            }
        });

        holder.noteView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = holder.getAdapterPosition();
                NoteBook note = mNoteList.get(position);
                // View当前PopupMenu显示的相对View的位置
                PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
                // menu布局
                popupMenu.getMenuInflater().inflate(R.menu.cycler_menu, popupMenu.getMenu());
                // menu的item点击事件
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        NoteBook note= new NoteBook();
                        note.setObjectId(mNoteList.get(position).getObjectId());
                        note.delete(new UpdateListener() {
                            @Override
                            public void done(BmobException e) {
                                if (e == null) {
                                    noteList.remove(position);
                                    adapter= new NoteAdapter(noteList);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        });

                        //在这里面写菜单项目的点击事件
                       Toast.makeText(getApplicationContext(), "删除成功", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                // PopupMenu关闭事件
                popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                    @Override
                    public void onDismiss(PopupMenu menu) {
                        // Toast.makeText(getApplicationContext(), "关闭PopupMenu", Toast.LENGTH_SHORT).show();
                    }
                });

                popupMenu.show();
                //Toast.makeText(v.getContext(), "我是长按事件", Toast.LENGTH_LONG).show();
                return false;
            }
        });
        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        // 为子项赋值，子项被滚动到屏幕就执行
        NoteBook note = mNoteList.get(position);
        holder.noteTitle.setText(note.getTitle());
        holder.noteContent.setText(note.getContent());
        holder.noteTime.setText(note.getUpdatedAt());
    }

    @Override
    public int getItemCount(){

        // 告诉RecyclerView一共有多少子项
        return mNoteList.size();
    }
}


