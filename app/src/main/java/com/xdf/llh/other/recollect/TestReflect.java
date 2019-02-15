package com.xdf.llh.other.recollect;

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
    }

    private void test2() {
        try{
            Class cl=Class.forName("com.xdf.llh.other.recollect.TestReflect");
            System.out.println("类名称:"+cl.getName());
            System.out.println("简单类名称:"+cl.getSimpleName());
            System.out.println("包名:"+cl.getPackage());
            System.out.println("是否为接口:"+cl.isInterface());
            System.out.println("是否为基本类型:"+cl.isPrimitive());
            System.out.println("是否为数组对象:"+cl.isArray());
            System.out.println("父类名称:"+cl.getSuperclass().getName());
        }catch(ClassNotFoundException e){
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
