package com.xdf.llh.designdemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * author: 李刘欢
 * date：2018/12/17 19:56
 * version:1.0.0
 * description: TestData
 */
public class TestData implements Parcelable {
    private String title;
    private String id;

    public TestData( ) {
    }
    public TestData(String title, String id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "testdata---title="+title+"--id=="+id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.id);
    }

    protected TestData(Parcel in) {
        this.title = in.readString();
        this.id = in.readString();
    }

    public static final Parcelable.Creator<TestData> CREATOR = new Parcelable.Creator<TestData>() {
        @Override
        public TestData createFromParcel(Parcel source) {
            return new TestData(source);
        }

        @Override
        public TestData[] newArray(int size) {
            return new TestData[size];
        }
    };
}
