package cn.edu.henu.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkinActivity extends AppCompatActivity {

    private GridView grid;//网格布局
    private ImageButton skin_back;//返回
    private LinearLayout layout;
    private int background;
    private SharedPreferences sp;//存储数据
    private SharedPreferences.Editor editor;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin);
        layout = findViewById(R.id.linearLayout3);
        background=R.drawable.background6;
        getBackground();

        grid= findViewById(R.id.skinGrid);
        skin_back= findViewById(R.id.back);
        skin_back.setOnClickListener(click);
        grid.setNumColumns(2);//网格布局2列
        grid.setAdapter(getAdapter());
        grid.setOnItemClickListener(gridClick);
    }



    private AdapterView.OnItemClickListener gridClick=new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // TODO Auto-generated method stub
            switch (position) {
                case 0:
                    background=R.drawable.background1;
                    setBackground(background);
                    getBackground();
                    back();
                    break;
                case 1:
                    background=R.drawable.background2;
                    setBackground(background);
                    getBackground();
                    back();
                    break;
                case 2:
                    background=R.drawable.background3;
                    setBackground(background);
                    getBackground();
                    back();
                    break;
                case 3:
                    background=R.drawable.background4;
                    setBackground(background);
                    getBackground();
                    back();
                    break;
                case 4:
                    background=R.drawable.background5;
                    setBackground(background);
                    getBackground();
                    back();
                    break;
                case 5:
                    background=R.drawable.background6;
                    setBackground(background);
                    getBackground();
                    back();
                    break;
                default:
                    break;
            }
        }
    };

    private void back(){
        Intent intent=new Intent(SkinActivity.this,Setting.class);
        startActivity(intent);
        finish();
    }
    //设置背景
    private void getBackground(){
        sp=getSharedPreferences("backgrounds", Context.MODE_PRIVATE);
        background=sp.getInt("background",background);
        layout.setBackgroundResource(background);
    }
    //写入背景
    private void setBackground(int background){
        sp=getSharedPreferences("backgrounds", Context.MODE_PRIVATE);
        editor=sp.edit();
        editor.putInt("background", background);
        editor.commit();
    }
    private View.OnClickListener click= arg0 -> {
        // TODO Auto-generated method stub
        Intent intent=new Intent(SkinActivity.this,Setting.class);
        startActivity(intent);
        finish();

    };
    //背景列表
    private SimpleAdapter getAdapter() {
        // TODO Auto-generated method stub
        SimpleAdapter adapter=new SimpleAdapter(this, getSkin(), R.layout.skinitem,
                new String[]{"skin_img","skin_txt"},
                new int[]{R.id.skin_img,R.id.skin_txt
                });
        return adapter;
    }
    //获得背景列表数据
    private List<Map<String, Object>> getSkin() {
        // TODO Auto-generated method stub
        List<Map<String,Object>>list=new ArrayList<Map<String,Object>>();
        int []skin_imgs={ R.drawable.background1, R.drawable.background2, R.drawable.background3,
                R.drawable.background4,R.drawable.background5,R.drawable.background6 };
        int []skin_txts={ R.string.skin_1, R.string.skin_2,
                R.string.skin_3,R.string.skin_4,R.string.skin_5, R.string.skin_6 };
        for(int i=0;i<skin_imgs.length;i++){
            HashMap<String,Object> map=new HashMap<String,Object>();
            map.put("skin_img", skin_imgs[i]);
            map.put("skin_txt", getResources().getString(skin_txts[i]));
            list.add(map);
        }
        return list;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
