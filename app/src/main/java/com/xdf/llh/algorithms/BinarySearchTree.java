package com.xdf.llh.algorithms;

import java.util.Comparator;

/**
 * author: 李刘欢
 * date：2019/2/20 15:37
 * version:1.0.0
 * description: BinarySearchTree  二叉查找树 ：左边树都小于有边树的值；
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
    /**
     * 根节点
     */
    private BinaryNode<T> root;
    private Comparator<? super T> cmp;

    private static class BinaryNode<T> {
        public T element;
        public BinaryNode<T> left;
        public BinaryNode<T> right;

        public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<? super T> cmp) {
        root = null;
        this.cmp = cmp;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T t) {
        return contains(t, root);
    }

    public T findMin() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return findMax(root).element;
    }

    public void insert(T t) {
        root = insert(t, root);
    }

    public void remove(T t) {
        root = remove(t, root);
    }

    public void printTree() {
        printTree(root);
    }

    private boolean contains(T t, BinaryNode<T> root) {
        if (t == null) return false;
        int compareResult = t.compareTo(root.element);
        if (compareResult < 0) {
            return contains(t, root.left);
        } else if (compareResult > 0) {
            return contains(t, root.right);
        } else {
            return true;
        }
    }

    private BinaryNode<T> findMin(BinaryNode<T> root) {
        if (root == null) {
            return null;
        } else if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }

    private BinaryNode<T> findMax(BinaryNode<T> root) {
        if (root != null) {
            while (root.right != null) {
                root = root.right;
            }
        }
        return root;
    }

    private BinaryNode<T> insert(T t, BinaryNode<T> root) {
        if (root == null) {
            return new BinaryNode<>(t, null, null);
        }
        int compareResult = t.compareTo(root.element);
        if (compareResult < 0) {
            root = insert(t, root.left);
        } else if (compareResult > 0) {
            root = insert(t, root.right);
        } else {
            // TODO: 2019/2/20  相等已经存在，暂时不操作
        }
        return root;
    }

    private BinaryNode<T> remove(T t, BinaryNode<T> root) {
        if (root == null)
            return null;
        int compareResult = t.compareTo(root.element);
        if (compareResult < 0) {
            root.left = remove(t, root.left);
        } else if (compareResult > 0) {
            root.right = remove(t, root.right);
            /**
             * 一下部分都是要删除的此节点判断，如果两个孩子，找到右面孩子最小的数组站位；如果单个孩子，让左侧孩子站位，如果没有左海子，右孩子站位
             */
        } else if (root.left != null && root.right != null) {// TODO: 2019/2/20 两个孩子的节点
            root.element = findMin(root.right).element;
            root.right = remove(root.element, root.right);
        }else {
            root = (root.left != null) ? root.left : root.right;
        }
        return root;
    }

    private void printTree(BinaryNode<T> root) {
    }
}
