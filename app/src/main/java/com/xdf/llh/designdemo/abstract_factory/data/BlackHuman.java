package com.xdf.llh.designdemo.abstract_factory.data;

import com.xdf.llh.designdemo.Logger;
import com.xdf.llh.designdemo.abstract_factory.IHuman;

public abstract class BlackHuman implements IHuman {
    @Override
    public void getColor() {
        Logger.loge("黑人的颜色是黑色的！");
    }

    @Override
    public void talk() {
        Logger.loge("黑人说的话一般都听不懂！");
    }

}
