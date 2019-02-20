package com.xdf.llh.designdemo.simple_factory.impl.human;

import com.xdf.llh.designdemo.simple_factory.IHumanFactory;
import com.xdf.llh.designdemo.simple_factory.Human;
/**
* 一般工厂
*/
public class BlackHumanFactory implements IHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> C) {
        return null;
    }

    @Override
    public Human createHuman() {
        return new com.xdf.llh.designdemo.simple_factory.data.BlackHuman();
    }
}
