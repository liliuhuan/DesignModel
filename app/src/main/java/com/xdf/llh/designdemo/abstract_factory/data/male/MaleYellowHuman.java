package com.xdf.llh.designdemo.abstract_factory.data.male;

import com.xdf.llh.designdemo.Logger;
import com.xdf.llh.designdemo.abstract_factory.data.YellowHuman;

public class MaleYellowHuman extends YellowHuman {

    @Override
    public void getSex() {
        Logger.loge("黄种人男性！");
    }
}
