package com.xdf.llh.designdemo.simple_factory.impl;

import com.xdf.llh.designdemo.simple_factory.AbstractHumanFactory;
import com.xdf.llh.designdemo.simple_factory.Human;
import com.xdf.llh.designdemo.simple_factory.IFactoryCreator;
import com.xdf.llh.designdemo.simple_factory.data.BlackHuman;
import com.xdf.llh.designdemo.simple_factory.data.WitheHuman;
import com.xdf.llh.designdemo.simple_factory.data.YellowHuman;
import com.xdf.llh.designdemo.simple_factory.impl.human.BlackHumanFactory;
import com.xdf.llh.designdemo.simple_factory.impl.human.WitheHumanFactory;
import com.xdf.llh.designdemo.simple_factory.impl.human.YellowHumanFactory;

public class FactoryCreator implements IFactoryCreator {
    @Override
    public void create() {
        AbstractHumanFactory humanFactory = new HumanFactory();

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

    private void printHuman(Human human) {
        human.getColor();
        human.talk();
    }
}
