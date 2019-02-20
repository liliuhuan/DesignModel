package com.xdf.llh.designdemo.simple_factory.data;

import com.xdf.llh.designdemo.Logger;
import com.xdf.llh.designdemo.simple_factory.Human;

public  class BlackHuman implements Human {
    @Override
    public void getColor() {
        Logger.loge("黑人的颜色事黑色的！");
    }

    @Override
    public void talk() {
        Logger.loge("黑人说的话一般都听不懂！");
    }
}
