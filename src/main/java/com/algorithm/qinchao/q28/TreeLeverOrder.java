package com.algorithm.qinchao.q28;

import com.algorithm.qinchao.q18.TreeNode;
import com.algorithm.qinchao.q20.BinarySearchTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/4 14:02
 * @description 二叉树的层次遍历
 */
public class TreeLeverOrder {
    /**
     * 二叉树的广度优先排序 时间复杂度O(N)
     * @param root
     * @return
     */
    public List<List<Integer>> treeLeverOrderByBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque deque = new LinkedList();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i <size ; i++) {
                TreeNode currentNode = (TreeNode) deque.poll();
                currentLevel.add(currentNode.getData());
                if (currentNode.getLeftChild() != null) {
                    deque.add(currentNode.getLeftChild());
                }
                if (currentNode.getRightChild() != null) {
                    deque.add(currentNode.getRightChild());
                }
            }
            result.add(currentLevel);
        }
        return result;
     }

    /**
     *
     * @param root
     * @return
     */
    public List<List<Integer>> treeLeverOrderByDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        treeLeverOrderByDFS2(root, result, 1);
        return result;
    }

    /**
     * 利用递归实现深度优先排序
     * @param node
     * @param lists
     * @param level
     */
    public void treeLeverOrderByDFS2(TreeNode node, List<List<Integer>> lists, int level) {
        //先将层数的数组创建好
        if (lists.size() < level) {
            lists.add(new ArrayList<>());
        }
        lists.get(level - 1).add(node.getData());
        if (node.getLeftChild() != null) {
            treeLeverOrderByDFS2(node.getLeftChild(), lists, level + 1);
        }
        if (node.getRightChild() != null) {
            treeLeverOrderByDFS2(node.getRightChild(), lists, level + 1);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(7);
        tree.insert(15);
        tree.insert(5);
        tree.insert(8);
        tree.insert(13);
        tree.insert(18);
        tree.insert(9);
        tree.insert(11);
        tree.insert(14);
        tree.insert(19);
        TreeLeverOrder treeLeverOrder = new TreeLeverOrder();
        System.out.println(treeLeverOrder.treeLeverOrderByBFS(tree.getRoot()));
        System.out.println(treeLeverOrder.treeLeverOrderByDFS(tree.getRoot()));
    }
}
