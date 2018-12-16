package com.xdf.llh.designdemo.abstract_factory.data.male;

import com.xdf.llh.designdemo.Logger;

public class MaleBlackHuman extends com.xdf.llh.designdemo.abstract_factory.data.BlackHuman {

    @Override
    public void getSex() {
        Logger.loge("黑人男性！");
    }
}
