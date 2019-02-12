package com.xdf.llh.designdemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * author: 李刘欢
 * date：2019/2/12 14:49
 * version:1.0.0
 * description: SQLiteDBHelper
 */
public class SQLiteDBHelper extends SQLiteOpenHelper {
    private final static String DB_NAME = "student.db";
    private final static int VERSION = 1;
    private SQLiteDatabase db = null;
    private static SQLiteDBHelper instance;

    private SQLiteDBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
        this.db = this.getWritableDatabase();
    }

    public static synchronized SQLiteDBHelper newInstance(Context ctx) {
        if (instance == null) {
            return instance = new SQLiteDBHelper(ctx);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StudentTable.CREATE_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (newVersion) {
            case 2:
                upgradeStudentTable(db);
                break;
        }
    }

    /**
     * @return
     */
    public StudentTable getStudentTable() {
        return new StudentTable(db);
    }

    /**
     * 更新表结构
     *
     * @param db
     */
    private void upgradeStudentTable(SQLiteDatabase db) {
        //把现有表改名为临时表，创建一个新表，把临时表数据插入新表，删除临时表
        db.execSQL(StudentTable.CREATE_TEMP_STUDENT);
        db.execSQL(StudentTable.CREATE_STUDENT);
        db.execSQL(StudentTable.INSERT_DATA);
        db.execSQL(StudentTable.DROP_TEMP_STUDENT);
    }
}
