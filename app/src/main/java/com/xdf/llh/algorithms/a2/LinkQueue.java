package com.xdf.llh.algorithms.a2;

/**
 * author: 李刘欢
 * date：2019/2/27 10:27
 * version:1.0.0
 * description: LinkQueue  链表管理类
 */
public class LinkQueue<T> {
    private SingleLinkList linkList;

    public LinkQueue() {
        this.linkList = new SingleLinkList();
    }

    public boolean isEmpty(){
        return linkList.isEmpty();
    }

    public void insert(T t){
        linkList.insertFirst(t);
    }
    public void remove(){
        linkList.deleteFirst();
    }
}
