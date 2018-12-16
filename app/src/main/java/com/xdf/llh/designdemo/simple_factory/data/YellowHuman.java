package com.xdf.llh.designdemo.simple_factory.data;

import com.xdf.llh.designdemo.Logger;
import com.xdf.llh.designdemo.simple_factory.Human;

public class YellowHuman implements Human {
    @Override
    public void getColor() {
        Logger.loge("黄种人的颜色是黄色的！");
    }

    @Override
    public void talk() {
        Logger.loge("黄种人说的话一般是双字节！");
    }
}
