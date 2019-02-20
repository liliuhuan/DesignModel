package com.xdf.llh.designdemo.proxy;

import com.xdf.llh.designdemo.Logger;
import com.xdf.llh.designdemo.proxy.dynamic.DynamicProxy;
import com.xdf.llh.designdemo.proxy.staticproxy.ProxyGamePlayer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
        final IGamePlayer nomalGamePlayer = new NomalGamePlayer();
//        InvocationHandler handler = new DynamicGamePlayer<>(nomalGamePlayer);
//        ClassLoader classLoader = nomalGamePlayer.getClass().getClassLoader();
//        IGamePlayer poxy = (IGamePlayer) Proxy.newProxyInstance(classLoader, new Class[]{IGamePlayer.class}, handler);

        // TODO: 2018/12/17  加载的过程封装到newProxyInstance中
        IGamePlayer poxy = DynamicProxy.newProxyInstance(nomalGamePlayer);
        poxy.login("张三", "password");
        poxy.killBoss();
        poxy.upgrade();

        IGamePlayer proxyInstance = (IGamePlayer) Proxy.newProxyInstance(nomalGamePlayer.getClass().getClassLoader(), nomalGamePlayer.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("login")) {
                    Logger.loge("有人在登录账号");
                }
                return method.invoke(nomalGamePlayer, args);
            }
        });
    }
}