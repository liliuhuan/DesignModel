package com.xdf.llh.designdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xdf.llh.designdemo.builder.Product;
import com.xdf.llh.designdemo.proxy.ProxyRun;

/**
 * @author dell
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 一般工厂模式
         */
//        new com.xdf.llh.designdemo.simple_factory.impl.FactoryCreator().createManyFactory();
        /**
         * 抽象工厂模式
         */
//        new com.xdf.llh.designdemo.abstract_factory.impl.FactoryCreator().createHuman();

        /**
         * 简单的builder模式
         */
        new Product.Builder().setTitle("止咳糖浆").setDes("专治小儿咳嗽，哮喘等引起的一系列问题！").build().printProduct();
        /**
         * 简单的动态代理
         */
        new ProxyRun().proxyRun4();
    }
}
