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
     * 假设p位置之前是排好序的，
     * 数组：4 ,1 ,3 ,5,2
     * 1次：1,4,3,5,2  1,4交换
     * 2次：1,3,4,5,2  4,3交换
     * 3次：1,3,4,5,2  不交换
     * 4次：1,2,3,4,5   3,4,5后移动 ，2插入到【1】的位置
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


    /**
     * 冒泡排序 :外层循环，从高位遍历，内层循环从低位遍历，如果内层循环两个相邻的数比较大于0进行交换，一趟确认最大数字，一直按最大数字有侧排列
     *
     * @param a
     */
    private void test2(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 插入排序：外层从小到大循环，找到循环当前值，内层反序循环，
     * 当内层位置大于0并且右侧小于左侧值时，把左侧值付给右侧，相当于大值右移；
     * 循环到左值小于右值，留出的空位插入外层的临时变量值。
     */
    private void test3(int[] a) {
        int k;
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            for (k = i; k > 0 && a[k] < a[k - 1]; k--) {
                a[k] = a[k - 1];
            }
            a[k] = temp;
        }
    }
}
