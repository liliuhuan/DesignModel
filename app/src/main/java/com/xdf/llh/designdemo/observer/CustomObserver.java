package com.xdf.llh.designdemo.observer;

/**
 * author: 李刘欢
 * date：2018/12/19 12:04
 * version:1.0.0
 * description: CustomObserver 观察者
 */
public interface CustomObserver {
    void update(CustomObservable o, Object arg);
}
