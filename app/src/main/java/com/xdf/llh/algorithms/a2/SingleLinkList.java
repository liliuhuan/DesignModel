package com.xdf.llh.algorithms.a2;

/**
 * author: 李刘欢
 * date：2019/2/27 10:11
 * version:1.0.0
 * description: SingleLinkList  单链表
 */
public class SingleLinkList<T> {
    private Node<T> first;

    private static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
        }

    }

    public SingleLinkList() {
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(T t) {
        Node<T> newNode = new Node<>(t);
        newNode.next = first;
        first = newNode;
    }

    public T deleteFirst() {
        Node<T> temp = this.first;
        first = first.next;
        return temp.data;
    }

}
