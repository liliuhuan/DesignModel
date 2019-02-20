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
        try {
            Class<?> aClass = Class.forName("com.xdf.llh.designdemo.adapter.Ac220");
            Ac220 newInstance = (Ac220)aClass.newInstance();
            IDc5vAdapter adapter = new Power5VAdapterAdapter(newInstance);
            Logger.loge("220v转换后的电压是："+adapter.output5v());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
