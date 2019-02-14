package com.xdf.llh.other.db;

/**
 * author: 李刘欢
 * date：2019/2/12 14:58
 * version:1.0.0
 * description: StudentBean
 */
public class StudentBean extends BaseBean {
    private int stuId;
    private String stuName;
    private String stuInfo;

    public StudentBean() {
    }

    public StudentBean(int stuId, String stuName, String stuInfo) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuInfo = stuInfo;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuInfo() {
        return stuInfo;
    }

    public void setStuInfo(String stuInfo) {
        this.stuInfo = stuInfo;
    }

    @Override
    public String toString() {
        return "stuId="+stuId+"\n"+"stuName="+stuName+"\n"+"stuInfo="+stuInfo;
    }
}
