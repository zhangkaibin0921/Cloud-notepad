package cn.edu.henu.myapplication.LogIn;

import android.view.View;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.listener.SaveListener;
import io.reactivex.disposables.Disposable;

public class UserInfoDB extends BmobObject {
    private String user_name; //用户名
    private String phone; //电话号码
    private String key_info; //登录密码;
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

    @Override
    public Disposable save(SaveListener<String> listener) {
        return super.save(listener);
    }
}
