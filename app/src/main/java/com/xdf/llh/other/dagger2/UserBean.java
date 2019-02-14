package com.xdf.llh.other.dagger2;

import android.content.Context;

/**
 * author: 李刘欢
 * date：2019/2/13 10:58
 * version:1.0.0
 * description: UserBean
 */
public class UserBean {
    private int id;
    private String name;
    private Context mContext;

    public UserBean(Context context) {
        this.mContext = context;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id=" + id + "\n" + "name=" + name;
    }
}
