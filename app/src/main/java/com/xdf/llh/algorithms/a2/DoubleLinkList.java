package com.xdf.llh.algorithms.a2;

/**
 * author: 李刘欢
 * date：2019/2/27 14:40
 * version:1.0.0
 * description: DoubleLinkList 双向链表
 */
public class DoubleLinkList<T> {
    private Node<T> first;
    private Node<T> last;

    private static class Node<T> {
        public T data;
        public Node<T> pre;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public DoubleLinkList() {
        this.first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFrist(T t){
        Node<T> newNode = new Node<>(t);
        if (isEmpty()){
            last = newNode;
        }else {
            first.pre = newNode;
        }
        newNode.next = first;
        first = newNode;
    }

    public void insertLast(T t){
        Node<T> newNode = new Node<>(t);
        if (isEmpty()){
            first = newNode;
        }else {
            last.next = newNode;
            newNode.pre = last;
        }
        last = newNode;
    }
}
