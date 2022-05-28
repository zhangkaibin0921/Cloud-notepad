package cn.edu.henu.myapplication.ui.diary;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.edu.henu.myapplication.AddDiary;
import cn.edu.henu.myapplication.LogIn.UserInfoDB;
import cn.edu.henu.myapplication.NoteAdapter;
import cn.edu.henu.myapplication.R;
import cn.edu.henu.myapplication.Setting;
import cn.edu.henu.myapplication.db.NoteBook;


public class DiaryFragment extends Fragment {
    public static int DiaryCount;

    public static int background1;
    public static LinearLayout layout1;
    public static SharedPreferences sp1;

    private FloatingActionButton btn_add;
    public static DrawerLayout mDrawerLayout;
    private Button setting;
    Context context;

    public static List<NoteBook> noteList = new ArrayList<>();
    public static NoteAdapter adapter;
    public static RecyclerView recyclerView;

    private Toolbar toolbar;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_diary,container,false);
        toolbar=root.findViewById(R.id.mytoolbar);

        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        root= inflater.inflate(R.layout.fragment_diary,container,false);
        mDrawerLayout=(DrawerLayout)root.findViewById(R.id.drawerLayout);
        NavigationView navView=(NavigationView)root.findViewById(R.id.nav_view);
        Button setting=root.findViewById(R.id.setting);
        btn_add=root.findViewById(R.id.add);

        background1=R.drawable.background6;

        context=getContext();



        recyclerView =root.findViewById(R.id.recycler_view);// 获取RecyclerView实例
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);// 设置垂直式排列

        View finalRoot = root;
        if (UserInfoDB.isLogin()) {
            BmobQuery<NoteBook> query = new BmobQuery<>();
            query.addWhereEqualTo("author", UserInfoDB.getCurrentUser(UserInfoDB.class));
            query.order("-updatedAt");
            //包含作者信息
            query.include("author");

            query.findObjects(new FindListener<NoteBook>() {

                @Override
                public void done(List<NoteBook> notes, BmobException e) {
                    if (e == null) {
                        noteList=notes;
                        adapter= new NoteAdapter(noteList);// 创建NoteAdapter实例;
                        recyclerView.setAdapter(adapter);// 完成适配器设置
                        DiaryCount=adapter.getItemCount();
                    } else {
                        Snackbar.make(finalRoot, e.getMessage(), Snackbar.LENGTH_LONG).show();
                    }
                }

            });
        } else {
            Snackbar.make(finalRoot, "请先登录", Snackbar.LENGTH_LONG).show();
        }

        //左上角菜单图标设置点击事件
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        //新建笔记按钮
        btn_add.setOnClickListener(new View.OnClickListener() {
            PopupWindow myPopupWindow;

            @Override
            public void onClick(View view) {

                showPopupwindow();


            }
            private void showPopupwindow(){
                View contentView = LayoutInflater.from(context).inflate(R.layout.popupwindow,null);
                myPopupWindow = new PopupWindow(contentView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT,true);

                View rootview = LayoutInflater.from(context).inflate(R.layout.popupwindow,null);
                myPopupWindow.showAtLocation(rootview, Gravity.BOTTOM,0,0);

                Button btn = contentView.findViewById(R.id.mw);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(context, AddDiary.class);
                        startActivity(intent);
                    }
                });
            }
        });

        //抽屉菜单中设置选项的点击事件
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_setting:
                        startActivity(new Intent(context,Setting.class));
                        break;
                }
                mDrawerLayout.closeDrawers();
                return false;
            }
        });

        return root;
    }
}