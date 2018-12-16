package com.xdf.llh.designdemo.abstract_factory;

/**
 * 抽象工厂组
 */
public interface IHumanFactory {
    IHuman createBlackHuman();
    IHuman createYellowHuman();
    IHuman createWitheHuman();
}
