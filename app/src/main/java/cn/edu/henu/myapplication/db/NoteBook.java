package cn.edu.henu.myapplication.db;

import org.litepal.crud.DataSupport;

import cn.bmob.v3.BmobObject;
import cn.edu.henu.myapplication.LogIn.UserInfoDB;

public class NoteBook extends BmobObject {
    private int id;
    private String title;
    private String content;
    private int tag;
    private UserInfoDB author;
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
    public UserInfoDB getAuthor() {
        return author;
    }
    public void setAuthor(UserInfoDB author) {
        this.author = author;
    }
}