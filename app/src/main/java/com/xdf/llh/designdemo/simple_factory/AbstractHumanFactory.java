package com.xdf.llh.designdemo.simple_factory;

public abstract class AbstractHumanFactory {
    /** 一般工厂
     * @param C
     * @param <T>
     * @return
     */
    public abstract <T extends Human> T createHuman(Class<T> C);

    /** 多工厂
     * @return
     */
    public Human createHuman(){return null;}
}
