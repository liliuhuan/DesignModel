package com.xdf.llh.other.dagger2;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * author: 李刘欢
 * date：2019/2/13 11:23
 * version:1.0.0
 * description: ApplicationComponent
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseApplication application);

    Context getApplicationContext();

//    @Component.Builder
//    interface Builder{
//        @BindsInstance
//        Builder application(Application application);
//
//        ApplicationComponent build();
//    }
}
