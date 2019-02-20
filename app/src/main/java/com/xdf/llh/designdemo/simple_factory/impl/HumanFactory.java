package com.xdf.llh.designdemo.simple_factory.impl;

import com.xdf.llh.designdemo.Logger;
import com.xdf.llh.designdemo.simple_factory.IHumanFactory;
import com.xdf.llh.designdemo.simple_factory.Human;

/**
 * 工厂类
 */
public class HumanFactory implements IHumanFactory {
    /**
     * 一般工厂模式    通过反射，传入不同的人中创建不同的实例
     *
     * @param c
     * @param <T>
     * @return
     */

    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            human = (Human) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            Logger.loge("人中生成错误--" + e.getMessage());
        }
        return (T) human;
    }

    /**
     * 简单工厂模式  通过反射，传入不同的人中创建不同的实例
     *
     * @param c
     * @param <T>
     * @return
     */
    public static <T extends Human> T createHumanStatic(Class<T> c){
        Human human = null;
        try {
            human = (Human) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            Logger.loge("人中生成错误--" + e.getMessage());
        }
        return (T) human;
    }
  @Override
    public Human createHuman() {
        return null;
    }
}
