package cn.edu.henu.myapplication.LogIn;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;
import io.reactivex.disposables.Disposable;

public class UserInfoDB extends BmobUser {
    private String phone; //电话号码
    private String ID; //“我的"界面的ID号
    private String sex; //性别
    private String live_place; // 常住地
    private String birthday; // 生日
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return phone;
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

}
