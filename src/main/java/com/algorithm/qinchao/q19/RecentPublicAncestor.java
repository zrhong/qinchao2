package com.algorithm.qinchao.q19;

import com.algorithm.qinchao.q18.Tree;
import com.algorithm.qinchao.q18.TreeNode;

import java.util.TreeMap;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/3 15:03
 * @description
 */
public class RecentPublicAncestor {
    public TreeNode lowestCommonAncestorByWhile(TreeNode root, TreeNode p, TreeNode q) {
        //非递归的方式
        while (root != null) {
            //判断两个值是否都小于根节点
            if (p.getData() < root.getData() && q.getData() < root.getData()) {
                //直接排查左节点
                root = root.getLeftChild();
            }
            //判断两个值是否都大于右节点
            else if (p.getData() > root.getData() && q.getData() > root.getData()) {
                root = root.getRightChild();
            } else {
                return root;
            }
        }
        return null;
    }

    public TreeNode lowestCommonAncestorByRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p.getData().equals(root.getData()) || q.getData().equals(root.getData())) {
            return root;
        }
        TreeNode left = lowestCommonAncestorByRecursive(root.getLeftChild(), p, q);
        TreeNode right = lowestCommonAncestorByRecursive(root.getRightChild(), p, q);
        if (null == left && null != right) {
            return right;
        } else if (null != left && null != right) {
            return root;
        } else {
            return left;
        }
//        return null == left ? right : null == right ? left : root;
    }


    public static void main(String[] args) {
        TreeNode left = new TreeNode(7, new TreeNode(5, null, null), new TreeNode(8, null, null));
        TreeNode right = new TreeNode(15, new TreeNode(13, null, null), new TreeNode(18, null, null));
        Tree tree = new Tree(new TreeNode(10, left, right));
        RecentPublicAncestor recentPublicAncestor = new RecentPublicAncestor();
        TreeNode t1 = new TreeNode(5, null, null);
        TreeNode t2 = new TreeNode(8, null, null);
        TreeNode treeNode1 = recentPublicAncestor.lowestCommonAncestorByWhile(tree.getRoot(), t1, t2);
        TreeNode treeNode2 = recentPublicAncestor.lowestCommonAncestorByRecursive(tree.getRoot(), t1, t2);
        System.out.println(treeNode1==treeNode2);
        System.out.println(treeNode1);
        System.out.println(treeNode2);
    }
}
