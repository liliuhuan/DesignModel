package com.xdf.llh.other.recollect;

import android.support.annotation.IntDef;

import com.xdf.llh.designdemo.Logger;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * author: 李刘欢
 * date：2019/2/15 15:54
 * version:1.0.0
 * description: TestAnnotation  注解
 *
 * {@link https://github.com/leavesC/Java_Kotlin_Android_Learn/blob/master/recollect/%E9%87%8D%E6%8B%BEJava%EF%BC%886%EF%BC%89-%E6%B3%A8%E8%A7%A3.md}
 */
public class TestAnnotation {
    @Vocation(name = "monkey", age = 24)
    @Fruit(name = "banana")
    @Date(time = "today")
    String annotation;

    public TestAnnotation() {
        Class<?> aClass = TestAnnotation.this.getClass();

        // TODO: 2019/2/15 通过反射取到  获取方法注解
        methodTest1(aClass);
        // TODO: 2019/2/15 取屬性所有注解 ,判断某条目是否有声明指定注解
        methodTest2(aClass);

    }
    private void methodTest3(@NetWorkStatus int res){

    }
    private void methodTest2(Class<?> aClass) {
        try {
            aClass.getDeclaredMethods();
            Field field = aClass.getField("annotation");
            Annotation[] annotations = field.getAnnotations();
            for (Annotation a : annotations) {
                Logger.loge(a.annotationType() + "--->" + a);
            }

            // TODO: 2019/2/15  判断某条目是否有声明指定注解
            boolean fieldAnnotationPresent = field.isAnnotationPresent(Vocation.class);
            Logger.loge(fieldAnnotationPresent + "--->" );
            
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private void methodTest1(Class<?> aClass) {
        try {
            Method method = aClass.getMethod("annotationTest1", String.class);
            Vocation annotation = method.getAnnotation(Vocation.class);
            Logger.loge("name1= " + annotation.name() + "\n age1 = " + annotation.age());
            method.isAnnotationPresent(Vocation.class);
            
            Method method2 = aClass.getMethod("annotationTest2");
            Vocation annotation2 = method2.getAnnotation(Vocation.class);
            Logger.loge("name2= " + annotation2.name() + "\n age2 = " + annotation2.age());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Vocation(name = "monkey1", age = 24)
    public static void annotationTest1(String content) {
        System.out.println(content);
    }

    @Vocation(name = "monkey2", age = 25)
    public static void annotationTest2() {

    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Vocation {
        String name() default "monkey";

        int age() ;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Fruit {
        String name();
    }


    @Retention(RetentionPolicy.CLASS)
    @interface Date {
        String time();
    }

    public static final int STRING_4G = 0;
    public static final int STRING_3G = 1;
    public static final int STRING_2G = 2;
    public static final int STRING_WIFI = 3;
    public static final int STRING_UNKNOWN = 4;

    @IntDef({STRING_4G,STRING_3G,STRING_2G,STRING_WIFI,STRING_UNKNOWN})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NetWorkStatus{}
}
