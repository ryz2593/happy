package com.ryz2593.happy.study.algorithmbasic.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ryz2593
 * @date 2019/8/21
 * @desc
 */
public class BinaryTree {


    private static List<BinaryTreeNode> nodeList = null;

    public void createBinaryTree(int[] array) {
        nodeList = new LinkedList<>();
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new BinaryTreeNode(array[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            //左孩子
            nodeList.get(parentIndex).setLeft(nodeList.get(parentIndex * 2 + 1));
            //右孩子
            nodeList.get(parentIndex).setRight(nodeList.get(parentIndex * 2 + 2));
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        //左孩子
        nodeList.get(lastParentIndex).setLeft(nodeList.get(lastParentIndex * 2 + 1));
        //右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).setRight(nodeList.get(lastParentIndex * 2 + 2));
        }

    }

    /**
     * 先序遍历采用递归的方式
     *
     * @param root
     */
    public void preOrder(BinaryTreeNode root) {
        if (null != root) {
            System.out.print(root.getData() + "\t");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    /**
     * 先序遍历采用非递归的方式
     *
     * @param root
     */
    public void preOrderNonRecursive(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                System.out.print(root.getData() + "\t");
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            root = root.getRight();
        }
    }

    /**
     * 中序遍历采用递归的方式
     *
     * @param root
     */
    public void inOrder(BinaryTreeNode root) {
        if (null != root) {
            inOrder(root.getLeft());
            System.out.print(root.getData() + "\t");
            inOrder(root.getRight());
        }
    }

    /**
     * 中序遍历采用非递归的方式
     *
     * @param root
     */
    public void inOrderNonRecurive(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (null != root) {
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.empty()) {
                break;
            }
            root = stack.pop();
            System.out.print(root.getData() + "\t");
            root = root.getRight();
        }
    }

    /**
     * 后序遍历采用递归的方式
     *
     * @param root
     */
    public void postOrder(BinaryTreeNode root) {
        if (null != root) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getData() + "\t");
        }
    }

    /**
     * 后序遍历采用非递归的方式
     *
     * @param root
     */
    public void postOrderNonRecurive(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            if (null != root) {
                stack.push(root);
                root = root.getLeft();
            } else {
                if (stack.empty()) {
                    break;
                }
                if (null == stack.lastElement().getRight()) {
                    root = stack.pop();
                    System.out.print(root.getData() + "\t");
                    while (root == stack.lastElement().getRight()) {
                        System.out.print(stack.lastElement().getData() + "\t");
                        root = stack.pop();
                        if (stack.isEmpty()) {
                            break;
                        }
                    }
                }
                if (!stack.isEmpty()) {
                    root = stack.lastElement().getRight();
                } else {
                    root = null;
                }
            }
        }
    }

    /**
     * 层序遍历
     *
     * @param root
     */
    public void levelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            System.out.print(temp.getData() + "\t");
            if (null != temp.getLeft()) {
                queue.offer(temp.getLeft());
            }
            if (null != temp.getRight()) {
                queue.offer(temp.getRight());
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode node10 = new BinaryTreeNode(10, null, null);
        BinaryTreeNode node8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode node9 = new BinaryTreeNode(9, null, node10);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, node8, node9);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);


        BinaryTree tree = new BinaryTree();

        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        BinaryTree tree1 = new BinaryTree();
        tree1.createBinaryTree(array);
        BinaryTreeNode root = nodeList.get(0);
        tree1.preOrder(root);
        System.out.println();
        tree1.preOrderNonRecursive(root);
        System.out.println();

        System.out.println("----先序遍历----");
        tree.preOrder(node1);
        System.out.println();
        tree.preOrderNonRecursive(node1);
        System.out.println();

        System.out.println("----中序遍历----");
        tree.inOrder(node1);
        System.out.println();
        tree.inOrderNonRecurive(node1);
        System.out.println();

        System.out.println("----后序遍历----");
        tree.postOrder(node1);
        System.out.println();
        tree.postOrderNonRecurive(node1);
        System.out.println();

        System.out.println("----层序遍历----");
        tree.levelOrder(node1);
        System.out.println();

    }
}
