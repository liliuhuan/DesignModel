package com.xdf.llh.algorithms;

/**
 * author: 李刘欢
 * date：2019/2/22 14:19
 * version:1.0.0
 * description: TestSort
 */
public class TestSort {
    /**
     * 插入排序 ：在第p趟，我们将p位置的元素向左移动，直到在前p+1个元素中的正确位置被找到
     *
     * @see asset sort1.png
     */

    public static <T extends Comparable<? super T>> void insertSort(T[] a) {
        int j;
        for (int p = 1; p < a.length; p++) {
            T t = a[p];
            for (j = p; j > 0 && t.compareTo(a[j - 1]) < 0; j--) {
                // FIXME: 2019/2/22  往后迁移1个位置
                a[j] = a[j - 1];
            }
            a[j] = t;
        }
    }
}
