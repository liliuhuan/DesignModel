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
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 构造函数
     */
    public BinarySearchTree() {
        this(null);
    }

    /**
     * 可以传递比较器
     *
     * @param cmp
     */
    public BinarySearchTree(Comparator<? super T> cmp) {
        root = null;
        this.cmp = cmp;
    }

    /**
     * 置空
     */
    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 是否包含
     *
     * @param t 查数组
     * @return true 包含 false 不包含
     */
    public boolean contains(T t) {
        return contains(t, root);
    }

    /**
     * 查找最小数值
     *
     * @return
     */
    public T findMin() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return findMin(root).element;
    }

    /**
     * 查找最大数值
     *
     * @return
     */
    public T findMax() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return findMax(root).element;
    }

    /**
     * 插入数值
     *
     * @param t
     */
    public void insert(T t) {
        root = insert(t, root);
    }

    /**
     * 删除数值
     *
     * @param t
     */
    public void remove(T t) {
        root = remove(t, root);
    }

    /**
     * 打印二叉树
     */
    public void printTree() {
        if (isEmpty()) {
            return;
        }
        printTree(root);
    }

    /**
     * @param t    要查找的值
     * @param root 根节点
     * @return
     */
    private boolean contains(T t, BinaryNode<T> root) {
        if (t == null) return false;
        int compareResult = t.compareTo(root.element);
        /**
         * 左边树都小于有边树的值；
         */
        if (compareResult < 0) {
            return contains(t, root.left);
        } else if (compareResult > 0) {
            return contains(t, root.right);
        } else {
            return true;
        }
    }

    /**
     * 根节点的左节点的左节点一直循环下去
     *
     * @param root 根节点
     * @return
     */
    private BinaryNode<T> findMin(BinaryNode<T> root) {
//        if (root == null) {
//            return null;
//        } else if (root.left == null) {
//            return root;
//        }
        if (root != null) {
            while (root.left != null) {
                root = root.left;
            }
        }
        return root;
    }

    /**
     * 根节点的右节点的右节点一直循环下去
     *
     * @param root
     * @return
     */
    private BinaryNode<T> findMax(BinaryNode<T> root) {
        if (root != null) {
            while (root.right != null) {
                root = root.right;
            }
        }
        return root;
    }

    /**
     * 找到合适的位置进行插入
     *
     * @param t    插入的值
     * @param node 插入的节点
     * @return
     */
    private BinaryNode<T> insert(T t, BinaryNode<T> node) {
        if (node == null) {
            /**
             * 实际上插入的值，最终都会走这方法
             */
            return new BinaryNode<>(t, null, null);
        }
        int compareResult = t.compareTo(node.element);
        if (compareResult < 0) {
            node = insert(t, node.left);
        } else if (compareResult > 0) {
            node = insert(t, node.right);
        } else {
            // TODO: 2019/2/20  相等已经存在，暂时不操作
        }
        return node;
    }

    /**
     * 删除的节点
     *
     * @param t    要删除的值
     * @param node
     * @return
     */
    private BinaryNode<T> remove(T t, BinaryNode<T> node) {
        /**
         * 如果存在，最终会走这里；把node.left == null 返回相当于删除操作
         */
        if (node == null) return null;
        int compareResult = t.compareTo(node.element);
        if (compareResult < 0) {
            node.left = remove(t, node.left);
        } else if (compareResult > 0) {
            node.right = remove(t, node.right);
        } else if (node.left != null && node.right != null) {// TODO: 2019/2/20 两个孩子的节点, 找到右侧最小的进行补位,并删除最小的
            /**
             * 以下部分都是要删除的此节点判断，如果两个孩子，找到右面孩子最小的数组站位；如果单个孩子，让左侧孩子占位，如果没有左孩子，右孩子站位
             */
            node.element = findMin(node.right).element;//补位
            node.right = remove(node.element, node.right); //删除最小的
        } else {
            /**
             * 此节点是删除节点；如果左不为空，左节点补位；否则右节点补位；node.right可以为空，表示空节点；
             * FIXME 节点的左右指向为空也就代表着节点删除了。
             */
            node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }

    /**
     * 打印二叉树，左子树 右子树
     *
     * @param root
     */
    private void printTree(BinaryNode<T> root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.element);
            printTree(root.right);
        }
    }
}
