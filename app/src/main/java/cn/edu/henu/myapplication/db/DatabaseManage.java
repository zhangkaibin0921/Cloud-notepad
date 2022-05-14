package cn.edu.henu.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

public class DatabaseManage {
    private Context mContext = null;

    private SQLiteDatabase mSQLiteDatabase = null;// 用于操作数据库的对象
    private DatabaseHelper dh = null;// 用于创建数据库的对象

    private String dbName = "notes.db";
    private int dbVersion = 1;

    public DatabaseManage(Context context) {
        mContext = context;
    }

    public DatabaseManage() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 打开数据库
     */
    public void open() {

        try {
            dh = new DatabaseHelper(mContext, dbName, null, dbVersion);
            if (dh == null) {
                // Log.v("msg", "is null");
                return;
            }
            mSQLiteDatabase = dh.getWritableDatabase();
            // dh.onOpen(mSQLiteDatabase);

        } catch (SQLiteException se) {
            se.printStackTrace();
        }
    }

    /**
     * 关闭数据库
     */
    public void close() {

        mSQLiteDatabase.close();
        dh.close();

    }

    // 获取列表
    public Cursor selectAll(boolean sort_desc) {
        Cursor cursor = null;
        String sql = null;
        try {
            sql = "select * from notes order by n_time "
                    + (sort_desc != true ? "" : "desc");// 倒序
            cursor = mSQLiteDatabase.rawQuery(sql, null);
        } catch (Exception ex) {
            ex.printStackTrace();
            cursor = null;
        }
        return cursor;
    }

    public Cursor selectById(int id) {

        // String result[] = {};
        Cursor cursor = null;
        try {
            String sql = "select * from notes where id='" + id + "'";
            cursor = mSQLiteDatabase.rawQuery(sql, null);
        } catch (Exception ex) {
            ex.printStackTrace();
            cursor = null;
        }

        return cursor;
    }

    // 根据内容查找
    public Cursor selectWord(String word) {
        Cursor cursor = null;
        System.out.println("---data----word" + word);
        try {
            String sql = " select * from notes where n_title like '" + "%"
                    + word + "%' or n_content like '" + "%" + word
                    + "%' order by n_time desc";
            cursor = mSQLiteDatabase.rawQuery(sql, null);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            cursor = null;
        }
        return cursor;
    }

    // 插入数据
    public long insert(String title, String content, String time) {

        long flag = -1;
        try {
            ContentValues cv = new ContentValues();
            cv.put("n_title", title);
            cv.put("n_content", content);
            cv.put("n_time", time);
            System.out.println("----insert"+time);
            flag = mSQLiteDatabase.insert("notes", null, cv);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;

    }

    // 删除数据
    public int delete(long id) {
        int affect = 0;
        try {
            affect = mSQLiteDatabase.delete("notes", "id=?", new String[] { id
                    + "" });
        } catch (Exception ex) {
            ex.printStackTrace();
            affect = -1;
        }

        return affect;
    }

    // 修改数据
    public int update(int id, String title, String content, String time) {
        int affect = 0;
        try {
            ContentValues cv = new ContentValues();

            cv.put("n_title", title);
            cv.put("n_content", content);
            cv.put("n_time", time);
            String w[] = { id + "" };
            affect = mSQLiteDatabase.update("notes", cv, "id=?", w);
        } catch (Exception ex) {
            ex.printStackTrace();
            affect = -1;
        }
        return affect;
    }

}
