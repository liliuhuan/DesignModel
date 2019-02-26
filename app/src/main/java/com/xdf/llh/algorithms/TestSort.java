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
     * @see {asset} sort1.png
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

    /**
     * 冒泡排序 : 比较相邻的两个数，如果左边的大于右边的交换位置，一趟下来高位就确定了
     */
    public static void insertSort(int[] a) {
        int out, in;
        for (out = a.length - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (a[in] > a[in + 1]) {
                    swap(a, in, in + 1);
                }
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /***
     * 数组：4 ,1 ,3 ,5,2
     * 1次：1,4,3,5,2
     * 2次：1,3,4,5,2
     * 3次：1,3,4,5,2
     * 4次：1,2,3,4,5
     * @param a
     */
    private void test(int[] a) {
        int j;
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            for (j = i; j > 0; j--) {
                /**
                 * 低位的一直右移动，留出空位在最后的j--位置，然后在插入当前位置的数即a[i]
                 */
                if (a[j] < a[j - 1])
                    a[j] = a[j - 1];
            }
            a[j] = temp;
        }
    }

    private void test2(int[] a){

    }
}
