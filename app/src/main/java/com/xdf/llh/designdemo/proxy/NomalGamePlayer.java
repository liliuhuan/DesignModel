package com.xdf.llh.designdemo.proxy;

import android.text.TextUtils;

import com.xdf.llh.designdemo.Logger;
import com.xdf.llh.designdemo.proxy.staticproxy.ProxyGamePlayer;

/**
 * author: 李刘欢
 * date：2018/12/17 11:17
 * version:1.0.0
 * description: NomalGamePlayer
 */
public class NomalGamePlayer implements IGamePlayer {
    private String userName;
    /**
     * 强代理  ，调用代理必须使用自己所引用的代理
     */
    private IGamePlayer proxy = null;
    public NomalGamePlayer() {
    }

    @Override
    public void login(String userName, String password) {
        this.userName = userName;
        Logger.loge("用户名："+userName +" 登录成功");
    }

    @Override
    public void killBoss() {
        if (TextUtils.isEmpty(userName)){
            throw new NullPointerException("请先登录用户");
        }
        Logger.loge("用户："+this.userName + " 正在打boss");
    }

    @Override
    public void upgrade() {
        if (TextUtils.isEmpty(userName)){
            throw new NullPointerException("请先登录用户");
        }
        // TODO: 2018/12/17  是自己的代理正常，不是自己的代理不能使用
        if (isMyProxy()){
            Logger.loge("用户：" + this.userName + " 升了一级");
        }else {
            Logger.loge("请使用指定的代理访问");
        }

    }

    @Override
    public IGamePlayer getPoxy() {
        proxy = new ProxyGamePlayer(this);
        return proxy;
    }

    private boolean isMyProxy(){
        if (proxy == null) {
            return false;
        }else {
            return true;
        }
    }
}
