package com.xdf.llh.algorithms;

import android.support.annotation.NonNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * author: 李刘欢
 * date：2019/2/20 11:03
 * version:1.0.0
 * description: MyArrayList 数组实现
 */
public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;//当前加入的元素数量
    private T[] theItems;

    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    /**
     * 初始化，默认10的数组容器
     */
    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 扩容
     */
    public void trimToSize() {
        ensureCapacity(size());
    }

    /**
     * 取得某个位置的值
     *
     * @param dx 位置
     * @return
     */
    public T get(int dx) {
        checkException(dx);
        return theItems[dx];
    }

    /**
     * 检测异常，只有位置符合的才能进行操作
     *
     * @param dx
     */
    private void checkException(int dx) {
        if (dx < 0 || dx > size())
            throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * 修改某个位置的值
     *
     * @param dx 位置
     * @param t  值
     * @return 返回修改前的值
     */
    public T set(int dx, T t) {
        checkException(dx);
        T tOld = theItems[dx];
        theItems[dx] = t;
        return tOld;
    }

    /**
     * 进行扩容，并拷贝数据到新数组中
     *
     * @param newCapacity 扩容的大小
     */
    private void ensureCapacity(int newCapacity) {
        if (newCapacity < size()) return;
        T[] theItemsOld = this.theItems;
        this.theItems = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            this.theItems[i] = theItemsOld[i];
        }
    }

    /**
     * 添加新的值，在尾部
     *
     * @param t
     * @return
     */
    public boolean add(T t) {
        add(size(), t);
        return true;
    }

    /**
     * 在某个位置添加一个元素。
     *
     * @param idx 添加的位置
     * @param t   添加的值
     */
    public void add(int idx, T t) {
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        /**
         * 将dx位置之后的值，向右移动，留出位置插入新值
         */
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = t;
        theSize++;
    }

    /** 删除idx位置的值
     * @param idx 位置
     * @return 删除的值
     */
    public T remove(int idx) {
        T theItemOld = theItems[idx];
        /**
         * 把 idx位置之后的值向左移动一位，相当于删除idx位置的值
         */
        for (int i = idx; i < size(); i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return theItemOld;
    }

    /**
     * @return
     * @see Iterable 迭代器接口实现，可以用迭代器遍历数组
     */
    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }


    private class ArrayListIterator implements Iterator<T> {
        private int currentCount = 0;
        private int limitSize = MyArrayList.this.theSize;
        private T[] elementData = MyArrayList.this.theItems;

        @Override
        public boolean hasNext() {
            return currentCount < limitSize;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return elementData[currentCount++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--currentCount);
        }
    }
}
