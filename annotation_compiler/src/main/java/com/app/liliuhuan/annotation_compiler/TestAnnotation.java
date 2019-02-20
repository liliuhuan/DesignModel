package com.app.liliuhuan.annotation_compiler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author: 李刘欢
 * date：2019/2/18 10:25
 * version:1.0.0
 * description: TestAnnotation
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
public @interface TestAnnotation {
    String value() default "Hello Annotation";
}
