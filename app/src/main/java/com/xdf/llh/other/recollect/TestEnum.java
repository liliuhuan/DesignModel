package com.xdf.llh.other.recollect;

import com.xdf.llh.designdemo.Logger;

/**
 * author: 李刘欢
 * date：2019/2/15 15:40
 * version:1.0.0
 * description: TestEnum 枚举
 */
public class TestEnum {

    public TestEnum() {

        Student female = Student.FEMALE;
        switch (female) {
            case MALE:
                break;
            case FEMALE:
                break;
            default:
                break;
        }
        Student male = Student.valueOf("MALE");
        Logger.loge(male+"--");

        Student2 student2 = Student2.FEMALE;
        Logger.loge(student2.getIndex()+"--");

        String name = Student2.FEMALE.name();
        Logger.loge(name+"--");
    }

    enum Student {
        MALE, FEMALE
    }

    enum Student2 {
        MALE(1), FEMALE(2);

        private int index;

        Student2(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }
}