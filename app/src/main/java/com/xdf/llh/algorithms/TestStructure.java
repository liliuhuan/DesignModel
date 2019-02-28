package com.xdf.llh.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

/**
 * author: 李刘欢
 * date：2019/2/19 15:20
 * version:1.0.0
 * description: TestStructure   表 栈 队列
 */
public class TestStructure {
    // TODO: 2019/2/19   Iterator 删除策略
    private void test() {
        /**
         * 数组，get线性时间 插入删除O(n)
         */
        ArrayList<String> list = new ArrayList<>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = (String) iterator.next();
            if (next.equals("aa")) {
                iterator.remove();
            }
        }
        /**
         * 双链表 删除插入简单，get耗时
         */
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("1");
        linkedList.removeFirst();
        linkedList.addLast("2");
        linkedList.removeLast();
        linkedList.getFirst();
        linkedList.getLast();

        ListIterator<String> listIterator = linkedList.listIterator();
        /**
         * 栈
         */
        Stack<String> stack = new Stack<>();
        stack.push("11");
        stack.pop();
        stack.peek();
        stack.empty();
        /**
         * 队列
         */
        Queue<String> queue = new ArrayDeque<>();


//        SortedList list1 = new SortedList(1);
    }
}
