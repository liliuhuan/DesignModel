package com.xdf.llh.designdemo.builder;

import android.text.TextUtils;

import com.xdf.llh.designdemo.Logger;

/**
 * author: 李刘欢
 * date：2018/12/17 10:36
 * version:1.0.0
 * description: Product 简单的builder模式
 * @author dell
 */
public class Product {

    private String title ;
    private String des;
    private Product(Builder builder) {
        this.title = builder.title;
        this.des = builder.des;
    }
    public void printProduct(){
        Logger.loge("当前产品是：名称："+title+",使用说明："+ des);
    }
    public static class Builder {
        private String title;
        private String des;

        public Builder() {
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDes(String des) {
            this.des = des;
            return this;
        }

        public Product build(){
             if (TextUtils.isEmpty(title)){
                 throw new NullPointerException("产品的标题不能为空");
             }
             if (TextUtils.isEmpty(des)){
                 throw new NullPointerException("产品必须要加使用说明，才能出售");
             }
            return  new Product(this);
        }
    }
}
