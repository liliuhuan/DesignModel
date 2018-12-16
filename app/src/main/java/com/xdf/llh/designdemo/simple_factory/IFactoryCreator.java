package com.xdf.llh.designdemo.simple_factory;

public interface IFactoryCreator {
    /**
     * 一般工厂，扩展性好
     */
    void create();

    /**
     * 简单工厂模式
     */
    void createStatic();

    /**
     * 多工厂模式
     */
    void createManyFactory();
}
