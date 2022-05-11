package com.example.basic_setting_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Setting_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    protected void onDestroy(){
        super.onDestroy();
    }

    public void change_style(View view){
        startActivity(new Intent(this, Setting_SkinActivity.class));
    }
}