package com.xdf.llh.designdemo.abstract_factory.impl;

import com.xdf.llh.designdemo.abstract_factory.IHuman;
import com.xdf.llh.designdemo.abstract_factory.IHumanFactory;
import com.xdf.llh.designdemo.abstract_factory.data.femal.FemalBlackHuman;
import com.xdf.llh.designdemo.abstract_factory.data.femal.FemalWitheHuman;
import com.xdf.llh.designdemo.abstract_factory.data.femal.FemalYellowHuman;

public class FemalHumanFactory implements IHumanFactory {
    @Override
    public IHuman createBlackHuman() {

        return new FemalBlackHuman();
    }

    @Override
    public IHuman createYellowHuman() {

        return new FemalYellowHuman();
    }

    @Override
    public IHuman createWitheHuman() {

        return new FemalWitheHuman();
    }
}
