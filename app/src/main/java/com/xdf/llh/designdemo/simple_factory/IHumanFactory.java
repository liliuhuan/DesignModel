package com.xdf.llh.designdemo.simple_factory;

/**
 * @author
 */
public  interface IHumanFactory {
    /**
     * 一般工厂
     *
     * @param C
     * @param <T>
     * @return
     */
     <T extends Human> T createHuman(Class<T> C);

    /**
     * 多工厂
     *
     * @return
     */
     Human createHuman();
}
