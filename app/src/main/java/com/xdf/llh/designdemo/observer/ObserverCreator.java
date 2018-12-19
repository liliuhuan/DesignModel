package com.xdf.llh.designdemo.observer;

/**
 * author: 李刘欢
 * date：2018/12/19 12:12
 * version:1.0.0
 * description: ObserverCreator
 */
public class ObserverCreator {
    public void crate(){
        CustomObservable customObservable = new CustomObservable();
        customObservable.addObserver(new ObserverImpl());
        customObservable.addObserver(new ObserverImpl2());
        customObservable.setChanged();
        customObservable.notifyObservers("CustomObserver  刷新一下");
    }
}
