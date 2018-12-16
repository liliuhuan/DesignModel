package com.xdf.llh.designdemo.abstract_factory.data;

import com.xdf.llh.designdemo.Logger;
import com.xdf.llh.designdemo.abstract_factory.IHuman;

public abstract class WitheHuman implements IHuman {
    @Override
    public void getColor() {
        Logger.loge("白种人的颜色是白色的！");
    }

    @Override
    public void talk() {
        Logger.loge("白种人说话一般是单字节！");
    }

}
