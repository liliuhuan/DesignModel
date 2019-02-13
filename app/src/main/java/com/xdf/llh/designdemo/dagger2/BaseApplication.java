package com.xdf.llh.designdemo.dagger2;

import android.app.Application;

/**
 * author: 李刘欢
 * date：2019/2/13 11:20
 * version:1.0.0
 * description: BaseApplication
 */
public class BaseApplication extends Application {
    private static ApplicationComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.inject(this);
    }

    public static ApplicationComponent getAppComponent() {
        return component;
    }
}
