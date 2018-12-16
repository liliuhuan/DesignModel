package com.xdf.llh.designdemo.abstract_factory.impl;

import com.xdf.llh.designdemo.abstract_factory.IFactoryCreator;
import com.xdf.llh.designdemo.abstract_factory.IHuman;

/**
 * 工厂创建实现类
 */
public class FactoryCreator implements IFactoryCreator {
    @Override
    public void createHuman() {
        FemalHumanFactory femalHumanFactory = new FemalHumanFactory();
        IHuman blackHuman = femalHumanFactory.createBlackHuman();
        printHuman(blackHuman);

        IHuman yellowHuman = femalHumanFactory.createYellowHuman();
        printHuman(yellowHuman);

        MaleHumanFactory maleHumanFactory = new MaleHumanFactory();
        IHuman maleHumanFactoryBlackHuman = maleHumanFactory.createBlackHuman();
        printHuman(maleHumanFactoryBlackHuman);

        IHuman maleHumanFactoryYellowHuman = maleHumanFactory.createYellowHuman();
        printHuman(maleHumanFactoryYellowHuman);
    }

    private void printHuman(IHuman human){
        human.getColor();
        human.talk();
        human.getSex();
    }
}
