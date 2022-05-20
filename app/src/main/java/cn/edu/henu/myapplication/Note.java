package cn.edu.henu.myapplication;

public class Note {


    private String noteContent;// 笔记内容
    private String noteTime;// 笔记创建时间
    private int noteTag;// 笔记标识
    private String noteTitle;

    public Note(String noteContent, String noteTime, int noteTag,String noteTitle){


        this.noteContent = noteContent;
        this.noteTime = noteTime;
        this.noteTag = noteTag;
        this.noteTitle=noteTitle;
    }

    public String getNoteContent(){

        return noteContent; }
    public String getNoteTime(){

        return noteTime; }
    public int getNoteTag(){

        return noteTag; }

    public String getNoteTitle() {
        return noteTitle;
    }


}