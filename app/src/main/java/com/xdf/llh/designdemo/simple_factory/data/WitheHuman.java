package com.xdf.llh.designdemo.simple_factory.data;

import com.xdf.llh.designdemo.Logger;
import com.xdf.llh.designdemo.simple_factory.Human;

public class WitheHuman implements Human {
    @Override
    public void getColor() {
        Logger.loge("白人的颜色事白色的！");
    }

    @Override
    public void talk() {
        Logger.loge("白人说的话一般是单字节！");
    }
}
