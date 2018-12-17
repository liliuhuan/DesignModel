package com.xdf.llh.designdemo.proxy.staticproxy;

import com.xdf.llh.designdemo.Logger;
import com.xdf.llh.designdemo.proxy.IGamePlayer;
import com.xdf.llh.designdemo.proxy.IProxy;
import com.xdf.llh.designdemo.proxy.NomalGamePlayer;

/**
 * author: 李刘欢
 * date：2018/12/17 11:22
 * version:1.0.0
 * description: ProxyGamePlayer ,多接口实现，扩展过程中的其他操作
 */
public class ProxyGamePlayer implements IGamePlayer,IProxy {
    private IGamePlayer gamePlayer;

    public ProxyGamePlayer() {
        gamePlayer = new NomalGamePlayer();
    }

    public ProxyGamePlayer(IGamePlayer gamePlayer) {
//
        this.gamePlayer = gamePlayer;
    }

    @Override
    public void login(String userName, String password) {
        before();
        gamePlayer.login(userName, password);
        after();
    }

    @Override
    public void killBoss() {
        gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        gamePlayer.upgrade();
        // TODO: 2018/12/17  扩展部分 ，升级后获得奖励
        award();
    }

    @Override
    public IGamePlayer getPoxy() {
        return this;
    }
    @Override
    public void before() {
        // TODO: 2018/12/17 可以处理之前的操作
    }
    @Override
    public void after() {
        // TODO: 2018/12/17 可以处理一下之后的操作
    }

    @Override
    public void award() {
        Logger.loge("奖励手里剑一枚，20个金币");
    }
}
