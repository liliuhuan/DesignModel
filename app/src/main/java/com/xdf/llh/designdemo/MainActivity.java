package com.xdf.llh.designdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.xdf.llh.designdemo.builder.Product;
import com.xdf.llh.designdemo.observer.ObserverCreator;
import com.xdf.llh.designdemo.proxy.ProxyRun;

import org.json.JSONObject;

import java.util.Observable;
import java.util.Observer;

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

        /**
         * 观察者模式
         */
        new ObserverCreator().crate();

        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("title", "zhangshan");
            jsonObject.put("id", 2);
            Logger.loge(jsonObject.toString());
            TestData testData = new Gson().fromJson(jsonObject.toString(), TestData.class);
            Logger.loge(testData.toString());
        } catch (Exception e) {
            Logger.loge(e.getMessage());
        }

    }
}
