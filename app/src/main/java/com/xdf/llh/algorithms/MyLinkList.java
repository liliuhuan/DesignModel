package com.xdf.llh.algorithms;

import android.support.annotation.NonNull;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * author: 李刘欢
 * date：2019/2/20 11:44
 * version:1.0.0
 * description: MyLinkList  双向链表
 */
public class MyLinkList<T> implements Iterable<T> {
    private int theSize;//当前加入的元素数量
    private int modCount;
    private Node<T> beginNode;
    private Node<T> endNode;

    private static class Node<T> {
        public T data;
        public Node<T> prev;
        public Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public MyLinkList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        beginNode = new Node<>(null, null, null);
        endNode = new Node<>(null, beginNode, null);
        beginNode.next = endNode;
        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int dx) {
        return getNode(dx).data;
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
        addBefore(getNode(idx, 0, size()), t);
    }

    public T set(int dx, T t) {
        Node<T> nodeOld = getNode(dx);
        T dataOld = nodeOld.data;
        nodeOld.data = t;
        return dataOld;
    }

    public T remove(int idx) {
        return remove(getNode(idx));
    }

    private void addBefore(Node<T> node, T t) {
        Node<T> newNode = new Node<>(t, node.prev, node);
        newNode.prev.next = newNode;
        node.prev = newNode;
        theSize++;
        modCount++;
    }

    private T remove(Node<T> node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        theSize--;
        modCount++;
        return node.data;
    }

    private Node<T> getNode(int idx) {
        return getNode(idx, 0, size());
    }

    private Node<T> getNode(int idx, int lower, int upper) {
        Node<T> temp;
        if (idx < lower || idx > upper) throw new IndexOutOfBoundsException();
        if (idx < size() / 2) {
            temp = beginNode.next;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
        } else {
            temp = endNode;
            for (int i = size(); i > idx; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }


    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = beginNode.next;
        private int expectModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endNode;
        }

        @Override
        public T next() {
            if (modCount != expectModCount)
                throw new ConcurrentModificationException();
            if (!hasNext())
                throw new NoSuchElementException();
            T data = current.data;
            current = current.next;
            okToRemove = true;
            return data;
        }

        @Override
        public void remove() {
            if (modCount != expectModCount)
                throw new ConcurrentModificationException();
            if (!okToRemove)
                throw new IllegalStateException();
            MyLinkList.this.remove(current.prev);
            expectModCount++;
            okToRemove = false;
        }
    }
}
