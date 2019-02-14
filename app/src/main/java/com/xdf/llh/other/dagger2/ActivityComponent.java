package com.xdf.llh.other.dagger2;

import dagger.Component;

/**
 * author: 李刘欢
 * date：2019/2/13 11:07
 * version:1.0.0
 * description: ActivityComponent
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(TestDaggerActivity activity);
}
