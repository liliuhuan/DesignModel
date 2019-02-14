package com.xdf.llh.other.rxjava;

import java.util.List;

/**
 * author: 李刘欢
 * date：2019/2/14 10:37
 * version:1.0.0
 * description: TestFlatMapBean
 */
public class TestFlatMapBean {
    private String stuName;
    private String stuId;
    private List<Course> courses;
    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public static class Course{
        private String name;
        private String score;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }
    }
}
