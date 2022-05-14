package cn.edu.henu.myapplication.db;

import java.sql.SQLData;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    private String tableName="notes";//表名
    private Context mContext=null;
    private String sql="create table if not exists "+tableName+
            "( id Integer primary key autoincrement , "+
            "n_title varchar(30) NOT NULL,"+//标题
            "n_content text NOT NULL ,"+//内容
            "n_time varchar(30))";//时间
    public DatabaseHelper(Context context, String name, CursorFactory factory,int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //创建表
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

}