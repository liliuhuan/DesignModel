package com.xdf.llh.algorithms;

/**
 * author: 李刘欢
 * date：2019/2/26 15:56
 * version:1.0.0
 * description: MyQueue 简单的队列
 */
public class MyQueue<T> {
    private int maxSize;
    private T[] array;
    private int front;
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
        T t = array[front++];
        if (front == maxSize) {
            front = 0;
        }
        mItems--;
        return t;
    }

    public T peekFront() {
        return array[front];
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
