package com.xdf.llh.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * author: 李刘欢
 * date：2019/2/19 11:13
 * version:1.0.0
 * description: TestAlgorithms
 */
public class TestAlgorithms {

    // TODO: 2019/2/19 递归简仑

    /**
     * 1.基准情形 ： 必须有某些基准情形不用递归就能求解
     * 2.不断推进 ： 对于那些递归求解的情形，递归总是朝着一个基准情形不断的推进（否则会造成死循环）
     * 3.设计法则 ： 假设所有的递归调用都能执行
     * 4.合成效益法则 ： 在求解同一问题的实例时，切勿在不同的递归中做重复性的工作。
     *
     * @param x
     * @return
     */
    private int f(int x) {
        if (x == 0) {
            return 0;
        } else {
            return 2 * f(x - 1) + x * x;
        }
    }

    /**
     * 实现排序 可以实现 {@link Comparable}接口 ，只能对引用类型不能使用基本类型
     */
    // TODO: 2019/2/19 泛型函数对象 泛型集合对象需要限定到指定的类型下，才能使用其子类或者超类；泛型数组则不需要
    private void test() {
        String[] arr = {"aaa", "zdj", "AFFF"};
        findMax(arr, new CustomComparableRules());
    }

    class CustomComparableRules implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareToIgnoreCase(o2);
        }
    }

    public static <T> T findMax(T[] arr, Comparator<? super T> cmp) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cmp.compare(arr[i], arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }

    /**
     * 调用compareTo方法时，不能确定T是否实现了Comparable，所以做个限制符。{@see <? super T>} 是泛型T的超类 ，相当于<T extends Comparable<T的超类>>
     * exmple : T 圆形 ，矩形，三角形  <? super T> 是形状。这样可以兼容子类的所有类型
     * @param arr
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T findMax(T[] arr) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }
}
