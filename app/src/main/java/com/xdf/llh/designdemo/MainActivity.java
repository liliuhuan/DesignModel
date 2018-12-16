package com.xdf.llh.designdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 一般工厂模式
         */
        new com.xdf.llh.designdemo.simple_factory.impl.FactoryCreator().createManyFactory();
        /**
         * 抽象工厂模式
         */
        new com.xdf.llh.designdemo.abstract_factory.impl.FactoryCreator().createHuman();

    }
}
