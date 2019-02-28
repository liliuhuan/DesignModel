package com.xdf.llh.algorithms.a1;

/**
 * author: 李刘欢
 * date：2019/2/26 15:44
 * version:1.0.0
 * description: MyStack 简单的栈结构
 */
public class MyStack<T> {
    private int maxSize;
    private T[] array;
    /**
     * 记录栈顶位置
     */
    private int top;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        top = -1;
        array = (T[]) new Object[maxSize];
    }

    public void pust(T t) {
        if (isFull()) return;
        array[++top] = t;
    }

    public T pop() {
        return array[top--];
    }

    public T peek() {
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}
