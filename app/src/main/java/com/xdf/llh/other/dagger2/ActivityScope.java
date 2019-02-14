package com.xdf.llh.other.dagger2;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * author: 李刘欢
 * date：2019/2/13 11:22
 * version:1.0.0
 * description: ActivityScope
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface ActivityScope {
}
