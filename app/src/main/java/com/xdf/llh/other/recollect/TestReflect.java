package com.xdf.llh.other.recollect;

import android.annotation.SuppressLint;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * author: 李刘欢
 * date：2019/2/15 17:39
 * version:1.0.0
 * description: TestReflect 类的反射
 */
public class TestReflect {

    public TestReflect() {
        // FIXME: 2019/2/15  类的基本信息
        test1();
        // FIXME: 2019/2/15 使用Class.forName()
        test2();
        // FIXME: 2019/2/18 从Class获得信息
        test3();
        // FIXME: 2019/2/18 利用Class建立对象
        test4();
        // FIXME: 2019/2/18 操作成员方法
        test5();
    }

    private void test5() {
        try {
            Class cl = Class.forName("com.xdf.llh.designdemo.TestData");
            /**
             *  指定构造函数
             */
            Constructor constructor = cl.getConstructor(String.class, String.class);
            /**
             * 根据指定的构造函数来获取对象
             */
            Object o = constructor.newInstance("1", "2");
            /**
             * 指定方法名称来获取对应的公开的Method实例（公有）
              */
            Method clMethod = cl.getMethod("toString");
            /**
             * 调用对象object的方法
             */
            clMethod.invoke(o);

            /**
             * 指定方法名称来获取对应的私有的Method实例（私有）
              */
            Method setName = cl.getDeclaredMethod("setTitle", String.class);
            setName.setAccessible(true);
            setName.invoke(o, "新的标题");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void test4() {
        try {
            Class cl = Class.forName("com.xdf.llh.other.recollect.TestReflect");
            Object o =cl.newInstance();
            ((TestReflect)o).test1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("NewApi")
    private void test3() {
        try {
            Class cl = Class.forName("com.xdf.llh.other.recollect.TestReflect");
            /**
             * 包名
             */
            Package aPackage = cl.getPackage();
            System.out.println("类名称:" + aPackage.getName());
            /**
             * 修饰符
             */
            int modifier = cl.getModifiers();
            System.out.println("类访问修饰符：" + Modifier.toString(modifier));
            System.out.println();

            /**
             * 取得构造函数信息
             */
            Constructor[] constructors = cl.getConstructors();
            for (Constructor constructor : constructors) {
                Parameter[] parameters = constructor.getParameters();
                System.out.print("访问修饰符：" + Modifier.toString(constructor.getModifiers()));
                System.out.print("   构造函数名：" + constructor.getName());
                System.out.println();
            }
            System.out.println();

            /**
             * 取得声明的数据成员
             */
            Field[] declaredFields = cl.getDeclaredFields();
            for (Field field : declaredFields) {
                System.out.print("访问修饰符：" + Modifier.toString(field.getModifiers()));
                System.out.print("   类型：" + field.getType().getName());
                System.out.print("   成员名：" + field.getName());
                System.out.println();
            }

            System.out.println();
            /**
             * 取得成员方法息
             */
            Method[] methods = cl.getDeclaredMethods();
            for (Method method : methods) {
                System.out.print("访问修饰符：" + Modifier.toString(method.getModifiers()));
                System.out.print("   返回值类型：" + method.getReturnType().getName());
                System.out.print("   方法名：" + method.getName());
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void test2() {
        try {
            Class cl = Class.forName("com.xdf.llh.other.recollect.TestReflect");
            System.out.println("类名称:" + cl.getName());
            System.out.println("简单类名称:" + cl.getSimpleName());
            System.out.println("包名:" + cl.getPackage());
            System.out.println("是否为接口:" + cl.isInterface());
            System.out.println("是否为基本类型:" + cl.isPrimitive());
            System.out.println("是否为数组对象:" + cl.isArray());
            System.out.println("父类名称:" + cl.getSuperclass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 类名称:com.xdf.llh.other.recollect.TestReflect
     * 简单类名称:TestReflect
     * 包名:package com.xdf.llh.other.recollect
     * 是否为接口:false
     * 是否为基本类型:false
     * 是否为数组对象:false
     * 父类名称:java.lang.Object
     */
    private void test1() {
        Class cl = TestReflect.class;
        System.out.println("类名称:" + cl.getName());
        System.out.println("简单类名称:" + cl.getSimpleName());
        System.out.println("包名:" + cl.getPackage());
        System.out.println("是否为接口:" + cl.isInterface());
        System.out.println("是否为基本类型:" + cl.isPrimitive());
        System.out.println("是否为数组对象:" + cl.isArray());
        System.out.println("父类名称:" + cl.getSuperclass().getName());
    }
}
