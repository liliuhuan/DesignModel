package com.xdf.llh.other.recollect.annotation;

/**
 * author: 李刘欢
 * date：2019/2/15 16:21
 * version:1.0.0
 * description: ViewInject
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewInject {
    int value();
}
