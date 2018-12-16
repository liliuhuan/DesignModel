package com.xdf.llh.designdemo.abstract_factory.data.femal;

import com.xdf.llh.designdemo.Logger;
import com.xdf.llh.designdemo.abstract_factory.data.YellowHuman;

public class FemalYellowHuman extends YellowHuman {

    @Override
    public void getSex() {
        Logger.loge("黄人女性！");
    }
}
