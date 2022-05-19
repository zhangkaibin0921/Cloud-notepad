package cn.edu.henu.myapplication.LogIn;

import cn.bmob.v3.BmobUser;

public class MyUser extends BmobUser {
    private String tokenNickName;

    public String getTokenNickName() {
        return tokenNickName;
    }
    public void setTokenNickName(String tokenNickName) {
        this.tokenNickName = tokenNickName;
    }
}
