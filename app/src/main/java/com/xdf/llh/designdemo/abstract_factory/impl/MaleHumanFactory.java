package com.xdf.llh.designdemo.abstract_factory.impl;

import com.xdf.llh.designdemo.abstract_factory.IHuman;
import com.xdf.llh.designdemo.abstract_factory.IHumanFactory;
import com.xdf.llh.designdemo.abstract_factory.data.male.MaleBlackHuman;
import com.xdf.llh.designdemo.abstract_factory.data.male.MaleWitheHuman;
import com.xdf.llh.designdemo.abstract_factory.data.male.MaleYellowHuman;

public class MaleHumanFactory implements IHumanFactory {
    @Override
    public IHuman createBlackHuman() {

        return new MaleBlackHuman();
    }

    @Override
    public IHuman createYellowHuman() {

        return new MaleYellowHuman();
    }

    @Override
    public IHuman createWitheHuman() {

        return new MaleWitheHuman();
    }
}
