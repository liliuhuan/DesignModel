package com.xdf.llh.designdemo.adapter;

import com.xdf.llh.designdemo.Logger;

/**
 * author: 李刘欢
 * date：2018/12/20 14:27
 * version:1.0.0
 * description: AdapterCreator
 */
public class AdapterCreator {
    public void create(){
        Power5vAdapter adapter = new Power5vAdapter(new Ac220());
        Logger.loge("220v转换后的电压是："+adapter.output5v());
    }
}
