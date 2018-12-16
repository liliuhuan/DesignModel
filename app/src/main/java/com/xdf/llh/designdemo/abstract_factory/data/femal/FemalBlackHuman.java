package com.xdf.llh.designdemo.abstract_factory.data.femal;

import com.xdf.llh.designdemo.Logger;
import com.xdf.llh.designdemo.abstract_factory.data.BlackHuman;

public class FemalBlackHuman extends BlackHuman {

    @Override
    public void getSex() {
        Logger.loge("黑人女性！");
    }
}
