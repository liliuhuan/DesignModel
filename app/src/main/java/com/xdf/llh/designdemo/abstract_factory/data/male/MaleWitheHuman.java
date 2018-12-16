package com.xdf.llh.designdemo.abstract_factory.data.male;

import com.xdf.llh.designdemo.Logger;
import com.xdf.llh.designdemo.abstract_factory.data.WitheHuman;

public class MaleWitheHuman extends WitheHuman {

    @Override
    public void getSex() {
        Logger.loge("白人男性！");
    }
}
