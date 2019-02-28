package com.xdf.llh.algorithms.a2;

/**
 * author: 李刘欢
 * date：2019/2/27 10:19
 * version:1.0.0
 * description: SingleLinkList2 含有头尾的单链表
 */
public class SingleLinkList2<T extends Comparable<? super T>> {
    private Node<T> first;
    private Node<T> last;

    private static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public SingleLinkList2() {
        this.first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(T t) {
        Node<T> newNode = new Node<>(t);
        newNode.next = first;
        first = newNode;
    }

    /**
     * 有序插入
     * 传进来的值大于第一个节点的值，指针后移动 ，找到合适位置，插入pre。next
     *
     * @param t todo 有问题
     */
    public void insertOrder(T t) {
        Node<T> newNode = new Node<>(t);
        Node<T> pre = null;
        Node<T> current = first;

        while (current != null && t.compareTo(current.data) > 0) {
            pre = current;
            current = current.next;
        }
        if (pre == null) {
            first = newNode;
            last = newNode;
        } else {
            pre.next = newNode;
            if (current == null) {
                last = newNode;
            } else {
                newNode.next = current;
            }
        }
    }

    public T deleteFirst() {
        Node<T> temp = this.first;
        first = first.next;
        return temp.data;
    }

    public void insertLast(T t) {
        Node<T> newNode = new Node<>(t);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
    }

    /**
     * todo 暂时未实现
     *
     * @return
     */
    public T deleteLast() {
        if (isEmpty()) {
            return null;
        }
        return null;
    }
}
