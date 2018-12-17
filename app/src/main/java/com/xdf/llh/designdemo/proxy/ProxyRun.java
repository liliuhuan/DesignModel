package com.xdf.llh.designdemo.proxy;

import com.xdf.llh.designdemo.proxy.dynamic.DynamicProxy;
import com.xdf.llh.designdemo.proxy.staticproxy.ProxyGamePlayer;

/**
 * author: 李刘欢
 * date：2018/12/17 11:24
 * version:1.0.0
 * description: ProxyRun
 */
public class ProxyRun {
    /**
     * 静态代理的运行类
     */
    public void proxyRun() {
        IGamePlayer nomalGamePlayer = new NomalGamePlayer();
        IGamePlayer proxyGamePlayer = new ProxyGamePlayer(nomalGamePlayer);
        proxyGamePlayer.login("张三", "password");
        proxyGamePlayer.killBoss();
        proxyGamePlayer.upgrade();
    }

    public void proxyRun2() {
        IGamePlayer proxyGamePlayer = new ProxyGamePlayer();
        proxyGamePlayer.login("张三", "password");
        proxyGamePlayer.killBoss();
        proxyGamePlayer.upgrade();
    }

    /**
     * 强代理测试
     */
    public void proxyRun3() {
        IGamePlayer nomalGamePlayer = new NomalGamePlayer();
        IGamePlayer poxy = nomalGamePlayer.getPoxy();
        // IGamePlayer poxy = new ProxyGamePlayer(nomalGamePlayer);
        poxy.login("张三", "password");
        poxy.killBoss();
        poxy.upgrade();
    }

    /**
     * 动态代理
     */
    public void proxyRun4() {
        IGamePlayer nomalGamePlayer = new NomalGamePlayer();
//        InvocationHandler handler = new DynamicGamePlayer<>(nomalGamePlayer);
//        ClassLoader classLoader = nomalGamePlayer.getClass().getClassLoader();
//        IGamePlayer poxy = (IGamePlayer) Proxy.newProxyInstance(classLoader, new Class[]{IGamePlayer.class}, handler);

        // TODO: 2018/12/17  加载的过程封装到newProxyInstance中
        IGamePlayer poxy = DynamicProxy.newProxyInstance(nomalGamePlayer);
        poxy.login("张三", "password");
        poxy.killBoss();
        poxy.upgrade();
    }
}