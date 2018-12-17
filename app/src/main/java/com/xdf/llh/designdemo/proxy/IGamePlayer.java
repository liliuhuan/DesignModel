package com.xdf.llh.designdemo.proxy;

/**
 * author: 李刘欢
 * date：2018/12/17 11:15
 * version:1.0.0
 * description: IGamePlayer
 */
public interface IGamePlayer {
    void login(String userName,String password);
    void killBoss();
    void upgrade();

    /** 强代理
     * @return
     */
    IGamePlayer getPoxy();
}
