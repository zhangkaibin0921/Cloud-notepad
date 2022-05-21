package cn.edu.henu.myapplication.db;

import org.litepal.crud.DataSupport;

public class NoteBook extends DataSupport{
    private int id;
    private String title;
    private String content;
    private String time;
    private int tag;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time = time;
    }
    public int getTag(){
        return tag;
    }
    public void setTag(int tag){
        this.tag = tag;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}