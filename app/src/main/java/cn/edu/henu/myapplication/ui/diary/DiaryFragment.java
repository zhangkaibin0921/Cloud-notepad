package cn.edu.henu.myapplication.ui.diary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

import cn.edu.henu.myapplication.AddDiary;
import cn.edu.henu.myapplication.MainActivity;
import cn.edu.henu.myapplication.R;
import cn.edu.henu.myapplication.Setting;


public class DiaryFragment extends Fragment {

    private Button btn_add;
    private DrawerLayout mDrawerLayout;
    private Button setting;
    Context context;
    private ImageButton add;

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
        ImageButton add=root.findViewById(R.id.add);





        context=getContext();


        //左上角菜单图标设置点击事件
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        //新建笔记按钮
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(context, AddDiary.class);
                startActivity(intent);
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