package com.xdf.llh.other.dagger2;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * author: 李刘欢
 * date：2019/2/13 12:07
 * version:1.0.0
 * description: ActivityModule
 */
@Module
public class ActivityModule {
    @Provides
    @ActivityScope
    UserBean provideUserBean(Context context) {
        return new UserBean(context);
    }
}
