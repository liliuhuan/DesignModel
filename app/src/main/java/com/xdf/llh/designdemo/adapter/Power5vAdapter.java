package com.xdf.llh.designdemo.adapter;

/**
 * author: 李刘欢
 * date：2018/12/20 14:25
 * version:1.0.0
 * description: Power5vAdapter
 */
public class Power5vAdapter implements IDc5v {
    private Ac220 ac220;

    public Power5vAdapter(Ac220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int output5v() {
        return ac220.outPut220V() / 44;
    }
}
