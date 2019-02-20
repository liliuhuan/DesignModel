package com.xdf.llh.designdemo.simple_factory.impl;

import com.xdf.llh.designdemo.simple_factory.IHumanFactory;
import com.xdf.llh.designdemo.simple_factory.Human;
import com.xdf.llh.designdemo.simple_factory.IFactoryCreator;
import com.xdf.llh.designdemo.simple_factory.data.BlackHuman;
import com.xdf.llh.designdemo.simple_factory.data.WitheHuman;
import com.xdf.llh.designdemo.simple_factory.data.YellowHuman;
import com.xdf.llh.designdemo.simple_factory.impl.human.BlackHumanFactory;
import com.xdf.llh.designdemo.simple_factory.impl.human.WitheHumanFactory;
import com.xdf.llh.designdemo.simple_factory.impl.human.YellowHumanFactory;
/**
* 简单工厂测试类
*/
public class FactoryCreator implements IFactoryCreator {
    /**
    * 通过反射，传入不同的人中创建不同的实例
    */
    @Override
    public void create() {
        IHumanFactory humanFactory = new HumanFactory();

        Human balckHuman = humanFactory.createHuman(BlackHuman.class);
        printHuman(balckHuman);

        Human yellowHuman = humanFactory.createHuman(YellowHuman.class);
        printHuman(yellowHuman);

        Human witheHuman = humanFactory.createHuman(WitheHuman.class);
        printHuman(witheHuman);
    }

    @Override
    public void createStatic() {
        Human blackHuman = HumanFactory.createHumanStatic(BlackHuman.class);
        printHuman(blackHuman);

        Human yellowHuman = HumanFactory.createHumanStatic(YellowHuman.class);
        printHuman(yellowHuman);

        Human witheHuman = HumanFactory.createHumanStatic(WitheHuman.class);
        printHuman(witheHuman);
    }

    @Override
    public void createManyFactory() {
        Human blackHuman = new BlackHumanFactory().createHuman();
        printHuman(blackHuman);

        Human yellowHuman = new YellowHumanFactory().createHuman();
        printHuman(yellowHuman);

        Human witheHuman = new WitheHumanFactory().createHuman();
        printHuman(witheHuman);
    }
    /**
    * 打印基本信息
    */
    private void printHuman(Human human) {
        human.getColor();
        human.talk();
    }
}
