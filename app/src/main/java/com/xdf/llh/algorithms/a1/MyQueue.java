package com.xdf.llh.algorithms.a1;

/**
 * author: 李刘欢
 * date：2019/2/26 15:56
 * version:1.0.0
 * description: MyQueue 简单的队列  目前不存在扩容，只是简单实现插入，删除
 */
public class MyQueue<T extends Comparable<? super T>> {
    private int maxSize;
    private T[] array;
    /**
     * 队头位置
     */
    private int front;
    /**
     * 队尾位置
     */
    private int rear;
    private int mItems;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        front = 0;
        rear = -1;
        array = (T[]) new Object[maxSize];
        mItems = 0;
    }

    public void insert(T t) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        array[++rear] = t;
        mItems++;
    }

    public T remove() {
        if (front == maxSize) {
            front = 0;
            return null;
        }
        T t = array[front++];
        mItems--;
        return t;
    }

    /**
     * 获取头结点不删除
     *
     * @return
     */
    public T peekFront() {
        return array[front];
    }

    /**
     * 弹出头结点并删除
     *
     * @return
     */
    public T popFront() {
        return remove();
    }

    public boolean isEmpty() {
        return mItems == 0;
    }

    public boolean isFull() {
        return maxSize == mItems;
    }

    public int size() {
        return mItems;
    }
}
