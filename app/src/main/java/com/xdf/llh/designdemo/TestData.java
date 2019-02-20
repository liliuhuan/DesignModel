package com.xdf.llh.designdemo;

/**
 * author: 李刘欢
 * date：2018/12/17 19:56
 * version:1.0.0
 * description: TestData
 */
public class TestData {
    private String title;
    private String id;

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
}
