package com.xdf.llh.designdemo.proxy.dynamic;

import com.xdf.llh.designdemo.proxy.IGamePlayer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * author: 李刘欢
 * date：2018/12/17 14:41
 * version:1.0.0
 * description: DynamicProxy  动态代理
 */
public class DynamicProxy {
    /** 动态创建
     * @param gamePlayer
     * @param <T>
     * @return
     */
    public static <T> T newProxyInstance(IGamePlayer gamePlayer){
        ClassLoader classLoader = gamePlayer.getClass().getClassLoader();
        Class<?>[] interfaces = gamePlayer.getClass().getInterfaces();
        InvocationHandler h = new DynamicGamePlayer<>(gamePlayer);
        return (T) Proxy.newProxyInstance(classLoader,interfaces,h);
    }
}
