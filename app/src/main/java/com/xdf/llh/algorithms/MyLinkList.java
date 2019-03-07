package com.xdf.llh.algorithms;

import android.support.annotation.NonNull;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * author: 李刘欢
 * date：2019/2/20 11:44
 * version:1.0.0
 * description: MyLinkList  双向链表 实现
 */
public class MyLinkList<T> implements Iterable<T> {
    private int theSize;//当前加入的元素数量
    private int modCount;
    private Node<T> beginNode;
    private Node<T> endNode;

    private static class Node<T> {
        public T data;
        Node<T> prev;
        Node<T> next;

        Node(T data, Node<T> prev, Node<T> next) {
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

    /**
     * 清空链表 创建开始结束节点，这俩节点只是代表入口，出口不代表数据
     */
    private void doClear() {
        beginNode = new Node<>(null, null, null);
        endNode = new Node<>(null, beginNode, null);
        beginNode.next = endNode;
        theSize = 0;
        modCount++;
    }

    int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 获取某位置节点的数据
     *
     * @param dx
     * @return
     */
    public T get(int dx) {
        return getNode(dx).data;
    }

    /**
     * 添加新节点，尾部添加
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
     * @param idx
     * @param t
     */
    public void add(int idx, T t) {
        addBefore(getNode(idx, 0, size()), t);
    }

    /**
     * 设置dx位置节点数据为t
     *
     * @param dx 位置
     * @param t  添加或修改的内容
     * @return 返回修改前的内容
     */
    public T set(int dx, T t) {
        Node<T> nodeOld = getNode(dx);
        T dataOld = nodeOld.data;
        nodeOld.data = t;
        return dataOld;
    }

    /**
     * 删除idx 位置的节点
     *
     * @param idx 位置
     * @return 返回删除的节点
     */
    public T remove(int idx) {
        return remove(getNode(idx));
    }

    /***
     * 添加在node节点之前位置
     * @param node
     * @param t
     */
    private void addBefore(Node<T> node, T t) {
        Node<T> newNode = new Node<>(t, node.prev, node);
        newNode.prev.next = newNode;
        node.prev = newNode;
        theSize++;
        modCount++;
    }

    /**
     * @param node 删除的节点
     * @return 返回删除的节点
     */
    private T remove(Node<T> node) {
        /**
         * 更改前后节点的，前节点 后节点关联实现删除
         */
        node.next.prev = node.prev;
        node.prev.next = node.next;
        theSize--;
        modCount++;
        return node.data;
    }

    /**
     * 根据位置获取节点
     *
     * @param idx
     * @return
     */
    private Node<T> getNode(int idx) {
        return getNode(idx, 0, size());
    }

    /**
     * int k = 0;
     * while (k < idx) {
     * temp = temp.next;
     * k++;
     * }
     *
     * @param idx   位置
     * @param lower 起始位置
     * @param upper 结束位置
     * @return 返回查找的节点
     */
    private Node<T> getNode(int idx, int lower, int upper) {
        Node<T> temp;
        if (idx < lower || idx > upper)
            throw new IndexOutOfBoundsException();
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


    /**
     * @return
     * @see Iterable 接口实现迭代器
     */
    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    /**
     * 迭代器
     */
    private class LinkedListIterator implements Iterator<T> {
        /**
         * 起始位置的第一个有效节点
         */
        private Node<T> current = beginNode.next;
        private int expectModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endNode;
        }

        /**
         * 遍历的时候不允许外部进行插入删除操作，否则报异常
         *
         * @return
         */
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
