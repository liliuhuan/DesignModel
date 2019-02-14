package com.xdf.llh.other.dagger2;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * author: 李刘欢
 * date：2019/2/13 11:19
 * version:1.0.0
 * description: ApplicationModule
 */
@Module
public class ApplicationModule {
    private final BaseApplication application;

    public ApplicationModule(BaseApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext(){
        return application;
    }

}
