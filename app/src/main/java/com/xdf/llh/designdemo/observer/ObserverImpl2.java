package com.xdf.llh.designdemo.observer;

import com.xdf.llh.designdemo.Logger;

/**
 * author: 李刘欢
 * date：2018/12/19 12:10
 * version:1.0.0
 * description: ObserverImpl 观察者实现类
 */
public class ObserverImpl2 implements CustomObserver {

    @Override
    public void update(CustomObservable o, Object arg) {
        Logger.loge((String) arg);
    }
}
