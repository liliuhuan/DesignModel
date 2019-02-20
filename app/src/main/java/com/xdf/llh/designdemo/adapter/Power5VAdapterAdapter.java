package com.xdf.llh.designdemo.adapter;

/**
 * author: 李刘欢
 * date：2018/12/20 14:25
 * version:1.0.0
 * description: Power5VAdapterAdapter
 */
public class Power5VAdapterAdapter implements IDc5vAdapter {
    private Ac220 ac220;

    public Power5VAdapterAdapter(Ac220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int output5v() {
        return ac220.outPut220V() / 44;
    }
}
