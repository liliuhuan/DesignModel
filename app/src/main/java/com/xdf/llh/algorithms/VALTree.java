package com.xdf.llh.algorithms;

import java.util.Comparator;

/**
 * author: 李刘欢
 * date：2019/2/21 17:31
 * version:1.0.0
 * description: VALTree  平衡二叉树 : 带有平衡条件的二叉查找树。
 *
 * @see BinarySearchTree  查看二叉查找树    平衡条件： 每个VALTree的左子树和右子树的高度最多相差1的二叉查找树，其实就是二叉树执行了查找二叉树的操作，然后平衡一下；
 */
public class VALTree<T extends Comparable<? super T>> {
    /**
     * 根节点
     */
    private VALNode<T> root;
    private Comparator<? super T> cmp;
    private static final int ALLOWED_IMALANCE = 1;

    private static class VALNode<T> {
        T element;
        VALNode<T> left;
        VALNode<T> right;
        int height;

        VALNode(T element, VALNode<T> left, VALNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            height = 0;
        }
    }

    /**
     * 构造函数
     */
    public VALTree() {
        this(null);
    }

    public VALTree(Comparator<? super T> cmp) {
        root = null;
        this.cmp = cmp;
    }

    /**
     * 置空
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 检测是否包含
     *
     * @param t
     * @return
     */
    public boolean contains(T t) {
        return contains(t, root);
    }

    /**
     * 找到最小值
     *
     * @return
     */
    public T findMin() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return findMin(root).element;
    }

    /**
     * 找最大值
     *
     * @return
     */
    public T findMax() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return findMax(root).element;
    }

    /**
     * 插入树
     *
     * @param t 插入的值
     */
    public void insert(T t) {
        root = insert(t, root);
    }

    /**
     * 删除树
     *
     * @param t 删除的值值
     */
    public void remove(T t) {
        root = remove(t, root);
    }

    public void printTree() {
        if (!isEmpty()) printTree(root);
    }

    private boolean contains(T t, VALNode<T> root) {
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

    /** 找到最小节点
     * @param root
     * @return
     */
    private VALNode<T> findMin(VALNode<T> root) {
        if (root == null) {
            return null;
        } else if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }

    /** 找到树的最大节点
     * @param root
     * @return
     */
    private VALNode<T> findMax(VALNode<T> root) {
        if (root != null) {
            while (root.right != null) {
                root = root.right;
            }
        }
        return root;
    }

    /** 插入知道节点中
     * @param t
     * @param root
     * @return
     */
    private VALNode<T> insert(T t, VALNode<T> root) {
        if (root == null) {
            return new VALNode<>(t, null, null);
        }
        int compareResult = t.compareTo(root.element);
        if (compareResult < 0) {
            root = insert(t, root.left);
        } else if (compareResult > 0) {
            root = insert(t, root.right);
        } else {
            // TODO: 2019/2/20  相等已经存在，暂时不操作
        }
        return balance(root);
    }

    /**
     * 返回节点的深度
     *
     * @param t
     * @return
     */
    private int height(VALNode<T> t) {
        return t == null ? -1 : t.height;
    }

    /**
     * 平衡树
     *
     * @param root 需要平衡的节点
     * @return
     */
    private VALNode<T> balance(VALNode<T> root) {
        if (root == null) {
            return null;
        }
        /**
         * 判断是否平衡，需要旋转  ： 左节点深度 大于 右节点深度  旋转左节点
         */
        if (height(root.left) - height(root.right) > ALLOWED_IMALANCE) {
            /**
             * 左节点的左节点深度 大于 左节点的右节点深度  左旋转；
             */
            if (height(root.left.left) > height(root.left.right)) {
                root = rotateWithLeftChild(root);
            } else {
                root = doubleWithLeftChild(root);
            }
        } else if ((height(root.right) - height(root.left) > ALLOWED_IMALANCE)) {
            if (height(root.right.right) > height(root.right.left)) {
                root = rotateWithRightChild(root);
            } else {
                root = doubleWithRightChild(root);
            }
        }
        root.height = Math.max(height(root.left), height(root.right)) + ALLOWED_IMALANCE;
        return root;
    }

    /**
     * 单旋转 （左孩子）{@link assets val_left.png}
     *
     * @param node 左旋转的节点
     * @return
     */
    private VALNode<T> rotateWithLeftChild(VALNode<T> node) {
        /**
         * 旋转代码 三步 1.找到左节点 2.把左节点的右孩子给node的做节点 3.把左的右节点指向node；
         */
        VALNode<T> leftNode = node.left;
        node.left = leftNode.right;
        leftNode.right = node;

        node.height = Math.max(height(node.left), height(node.right)) + ALLOWED_IMALANCE;
        leftNode.height = Math.max(height(leftNode.left), node.height) + 1;
        /**
         * 更新新的root 节点为k1
         */
        return leftNode;
    }

    /**
     * 双旋转 （左孩子）{@see asset val_double_left.png}
     * 先右旋转，再左旋转
     *
     * @param k3 也是root节点
     * @return
     */
    private VALNode<T> doubleWithLeftChild(VALNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * 单旋转 （右孩子）{@see val_right.png}
     *
     * @param root
     * @return
     */
    private VALNode<T> rotateWithRightChild(VALNode<T> root) {
        VALNode<T> k1 = root.right;
        root.right = k1.left;
        k1.left = root;

        root.height = Math.max(height(root.left), height(root.right)) + ALLOWED_IMALANCE;
        k1.height = Math.max(height(k1.left), root.height) + 1;
        return k1;
    }

    /**
     * 双旋转 （右孩子）
     *
     * @param k3
     * @return
     */
    private VALNode<T> doubleWithRightChild(VALNode<T> k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

    /**
     * @see BinarySearchTree remove()方法解释
     * @param t
     * @param root
     * @return
     */
    private VALNode<T> remove(T t, VALNode<T> root) {
        if (root == null)
            return null;
        int compareResult = t.compareTo(root.element);
        if (compareResult < 0) {
            root.left = remove(t, root.left);
        } else if (compareResult > 0) {
            root.right = remove(t, root.right);
        } else if (root.left != null && root.right != null) {// TODO: 2019/2/20 两个孩子的节点
            root.element = findMin(root.right).element;
            root.right = remove(root.element, root.right);
        } else {
            root = (root.left != null) ? root.left : root.right;
        }
        return balance(root);
    }

    private void printTree(VALNode<T> root) {
        if (root != null) {
            /**
             * 中序遍历
             */
            printTree(root.left);
            System.out.print(root.element);
            printTree(root.right);
            /**
             * 后续遍历  height(root.left); 先知道子节点的高度，一步一步知道自己节点的高度
             */
        }
    }
}
