package com.xdf.llh.designdemo.abstract_factory.data.femal;

import com.xdf.llh.designdemo.Logger;
import com.xdf.llh.designdemo.abstract_factory.data.WitheHuman;

public class FemalWitheHuman extends WitheHuman {
    @Override
    public void getSex() {
        Logger.loge("白人女性！");
    }
}
