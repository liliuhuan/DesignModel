package com.xdf.llh.designdemo.proxy;

/**
 * author: 李刘欢
 * date：2018/12/17 12:00
 * version:1.0.0
 * description: IProxy  扩展类，为了处理一些过程中的操作
 * @author dell
 */
public interface IProxy {
    void before();
    void after();
    /**
     * 奖励
     */
    void award();
}
