package cn.edu.henu.myapplication.LogIn;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;
import io.reactivex.disposables.Disposable;

public class UserInfoDB extends BmobUser {
    private String user_name; //用户名--昵称
    private String phone; //电话号码
    private String key_info; //登录密码;
    private String ID; //“我的"界面的ID号
    private String sex; //性别
    private String live_place; // 常住地
    private String birthday; // 生日
    public void setUser_name(String user_name){
        this.user_name = user_name;
    }
    public String getUser_name(){
        return user_name;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return phone;
    }
    public void setKey_info(String key_info){
        this.key_info = key_info;
    }
    public String getKey_info(){
        return key_info;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getSex(){
        return sex;
    }

    public void setLive_place(String live_place) {
        this.live_place = live_place;
    }

    public String getLive_place() {
        return live_place;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

//    @Override
//    public Disposable save(SaveListener<String> listener) {
//        return super.save(listener);
//    }
}
