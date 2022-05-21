package cn.edu.henu.myapplication.LogIn;

import android.content.Context;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

public class BmobManager {
    private static final String BMOB_SDK_ID = "4c33e339432a88901c207e9a7a7114ee";//自己的bmob账号
    private volatile static BmobManager mInstance = null;
    private BmobManager() {

    }
    public static BmobManager getInstance() {
        if (mInstance == null) {
            synchronized (BmobManager.class) {
                if (mInstance == null) {
                    mInstance = new BmobManager();
                }
            }
        }
        return mInstance;
    }
    //初始化Bmob
    public void initBmob(Context mContext) {

        Bmob.initialize(mContext, BMOB_SDK_ID);
    }

}
