package com.xdf.llh.designdemo.simple_factory.impl.human;

import com.xdf.llh.designdemo.simple_factory.AbstractHumanFactory;
import com.xdf.llh.designdemo.simple_factory.Human;

public class BlackHumanFactory extends AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> C) {
        return null;
    }

    @Override
    public Human createHuman() {
        return null;
    }
}
