package com.xdf.llh.designdemo.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * author: 李刘欢
 * date：2019/2/12 15:00
 * version:1.0.0
 * description: StudentTable
 */
public class StudentTable implements BaseTable<StudentBean> {
    private final static String TABLE_NAME = "StudentTable";
    private final static String TEMP_TABLE_NAME = "TempStudentTable";
    private final static String ID = "id";
    private final static String STUDENT_ID = "stuId";
    private final static String STUDENT_NAME = "stuName";
    private final static String STUDENT_INFO = "stuInfo";
    private final static String STUDENT_ADDRESS = "stuAddress";
    private SQLiteDatabase db;
    public static String CREATE_STUDENT = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NAME + " ("
            + ID + " Integer primary key autoincrement, "
            + STUDENT_ID + " Integer, "
            + STUDENT_NAME + " TEXT, "
            + STUDENT_INFO + " TEXT ) ";

    public static String CREATE_TEMP_STUDENT = "alter table " + TABLE_NAME + " rename to " + TEMP_TABLE_NAME;
    public static String INSERT_DATA = "insert into " + TABLE_NAME + " select * from " + TEMP_TABLE_NAME;
    public static String DROP_TEMP_STUDENT = "drop table " + TEMP_TABLE_NAME;

    public StudentTable(SQLiteDatabase db) {
        this.db = db;
    }

    @Override
    public long insertData(StudentBean item) {
        ContentValues c = new ContentValues();
        c.put(STUDENT_ID, item.getStuId());
        c.put(STUDENT_NAME, item.getStuName());
        c.put(STUDENT_INFO, item.getStuInfo());
        return this.db.insertOrThrow(TABLE_NAME, null, c);
    }

    @Override
    public int deleteData(StudentBean item) {
        String[] whereArgs = {String.valueOf(item.getStuId())};
        return this.db.delete(TABLE_NAME, STUDENT_ID + "=?", whereArgs);
    }

    @Override
    public long updateData(StudentBean item) {
        ContentValues c = new ContentValues();
        c.put(STUDENT_ID, item.getStuId());
        c.put(STUDENT_NAME, item.getStuName());
        c.put(STUDENT_INFO, item.getStuInfo());
        String[] whereArgs = {String.valueOf(item.getStuId())};
        return this.db.update(TABLE_NAME, c, STUDENT_ID + "=?", whereArgs);
    }


    @Override
    public List<StudentBean> queryAllData() {
        List<StudentBean> beans = new ArrayList<>();
        //Cursor cursor = this.db.rawQuery("select * from " + TABLE_NAME, null);
        Cursor cursor = this.db.query(TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int stuId = cursor.getInt(cursor.getColumnIndex(STUDENT_ID));
            String stuName = cursor.getString(cursor.getColumnIndex(STUDENT_NAME));
            String stuInfo = cursor.getString(cursor.getColumnIndex(STUDENT_INFO));

            StudentBean stuBean = new StudentBean();
            stuBean.setStuId(stuId);
            stuBean.setStuName(stuName);
            stuBean.setStuInfo(stuInfo);
            beans.add(stuBean);
        }
        cursor.close();
        return beans;
    }

    @Override
    public StudentBean queryByFilter(String sId) {
//        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME + " where " + FRIEND_USER_ID + "= '" + userId + "'", null);
        StudentBean stuBean = null;
        Cursor cursor = this.db.query(TABLE_NAME, null, STUDENT_ID + "=?", new String[]{sId}, null, null, null);
        while (cursor.moveToNext()) {
            int stuId = cursor.getInt(cursor.getColumnIndex(STUDENT_ID));
            String stuName = cursor.getString(cursor.getColumnIndex(STUDENT_NAME));
            String stuInfo = cursor.getString(cursor.getColumnIndex(STUDENT_INFO));

            stuBean = new StudentBean();
            stuBean.setStuId(stuId);
            stuBean.setStuName(stuName);
            stuBean.setStuInfo(stuInfo);
        }
        return stuBean;
    }
}
