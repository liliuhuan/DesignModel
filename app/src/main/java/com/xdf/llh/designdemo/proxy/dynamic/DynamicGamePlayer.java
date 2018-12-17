package com.xdf.llh.designdemo.proxy.dynamic;

import com.xdf.llh.designdemo.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * author: 李刘欢
 * date：2018/12/17 12:12
 * version:1.0.0
 * description: DynamicGamePlayer 动态代理
 */
public class DynamicGamePlayer<T> implements InvocationHandler {
    /**
     * b被代理对象
     */
    private T obi = null;

    public DynamicGamePlayer(T obi) {
        this.obi = obi;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO: 2018/12/17 扩展功能，aop思想就是这样
        if (method.getName().equals("login")){
            Logger.loge("有人在登录账号");
        }
        return method.invoke(this.obi,args);
    }
}
