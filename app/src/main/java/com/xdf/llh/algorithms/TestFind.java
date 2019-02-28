package com.xdf.llh.algorithms;

/**
 * author: 李刘欢
 * date：2019/2/27 16:30
 * version:1.0.0
 * description: TestFind
 */
public class TestFind {
    /**
     * 二分法查找(适合有序的数组查找)
     *
     * @param array
     */
    public void binarySearch(int[] array) {
        if (array == null || array.length == 0) return;
        int low = 0;
        int high = array.length - 1;
        findNumber(array, low, high);
    }

    /**
     * 假设查找的key = 10  递归查找
     *
     * @param a
     * @param low
     * @param high
     * @return 返回的是位置
     */
    /**
     * 查找的关键数字
     */
    private int key = 10;

    private int findNumber(int[] a, int l, int h) {
        int i = l + h;
        int cin = i / 2;
        /**
         * 中间的数值，与要查找的数值进行比较
         */
        int c = a[cin];
        if (c == key) {
            return cin;
        } else if (c > key) {
            findNumber(a, l, cin - 1);
        } else if (c < key) {
            findNumber(a, cin + 1, h);
        }
        return -1;
    }
}
