package com.xdf.llh.designdemo.abstract_factory.data;

import com.xdf.llh.designdemo.Logger;
import com.xdf.llh.designdemo.abstract_factory.IHuman;

public abstract class YellowHuman implements IHuman {
    @Override
    public void getColor() {
        Logger.loge("黄种人的颜色是黄色的！");
    }

    @Override
    public void talk() {
        Logger.loge("黄种人说话一般是双字节！");
    }

}
