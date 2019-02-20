package com.xdf.llh.algorithms;

import android.support.annotation.NonNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * author: 李刘欢
 * date：2019/2/20 11:03
 * version:1.0.0
 * description: MyArrayList
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

    public void trimToSize() {
        ensureCapacity(size());
    }

    public T get(int dx) {
        checkException(dx);
        return theItems[dx];
    }

    private void checkException(int dx) {
        if (dx < 0 || dx > size())
            throw new ArrayIndexOutOfBoundsException();
    }

    public T set(int dx, T t) {
        checkException(dx);
        T tOld = theItems[dx];
        theItems[dx] = t;
        return tOld;
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity < size()) return;
        T[] theItemsOld = this.theItems;
        this.theItems = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            this.theItems[i] = theItemsOld[i];
        }
    }

    public boolean add(T t) {
        add(size(), t);
        return true;
    }

    /**
     * 在某个位置添加一个元素。
     *
     * @param idx
     * @param t
     */
    public void add(int idx, T t) {
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = t;
        theSize++;
    }

    public T remove(int idx) {
        T theItemOld = theItems[idx];
        for (int i = idx; i < size(); i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return theItemOld;
    }

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
