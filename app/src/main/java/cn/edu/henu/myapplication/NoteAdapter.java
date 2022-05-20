package cn.edu.henu.myapplication;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder>{


    private List<Note> mNoteList;

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

    public NoteAdapter(List<Note> noteList){

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
                Note note = mNoteList.get(position);

                Intent intent = new Intent(v.getContext(), UpdateDiary.class);
                String contentData = note.getNoteContent();
                String contentTitle=note.getNoteTitle();
                int tagData = note.getNoteTag();
                // intent.putExtra("键",数据)
                intent.putExtra("title_data",contentTitle);
                intent.putExtra("content_data", contentData);
                intent.putExtra("tag_data", String.valueOf(tagData));
                v.getContext().startActivity(intent);
            }
        });
        holder.noteTime.setOnClickListener(new View.OnClickListener(){

            // 子项点击事件
            @Override
            public void onClick(View v){


                int position = holder.getAdapterPosition();
                Note note = mNoteList.get(position);

                String time = note.getNoteTime();
                Toast.makeText(v.getContext(), "笔记创建于" + time, Toast.LENGTH_LONG).show();
            }
        });

        holder.noteTime.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = holder.getAdapterPosition();
                Note note = mNoteList.get(position);
                Toast.makeText(v.getContext(), "我是长按事件", Toast.LENGTH_LONG).show();
                return false;
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        // 为子项赋值，子项被滚动到屏幕就执行
        Note note = mNoteList.get(position);
        holder.noteTitle.setText(note.getNoteTitle());
        holder.noteContent.setText(note.getNoteContent());
        holder.noteTime.setText(note.getNoteTime());
    }

    @Override
    public int getItemCount(){

        // 告诉RecyclerView一共有多少子项
        return mNoteList.size();
    }
}