package com.algorithm.qinchao.q18;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/3 09:25
 * @description 验证是否二叉搜索树 二叉搜索树的特点，左子树的所有节点均小于根节点，右子树的所有节点均大于根节点
 */
public class ValidBinarySearchTree {
    boolean isBinarySearchTree(TreeNode root, Integer max, Integer min) {
        //如果当前根节点是个null，直接返回
        if (null == root) {
            return true;
        }
        //左子树的比较，比较左子树时，应该是使用最大值比较，因为左子树的根节点都是最大的
        if (null != max && root.data >= max) {
            return false;
        }
        //右子树的比较，比较右子树时，应该是使用最小值比较，因为右子树的根节点都是最小的
        if (null != min && root.data <= min) {
            return false;
        }
        //如果没有结果，证明还有，继续往下比较，递归
        return isBinarySearchTree(root.leftChild, root.data, min)//左子树把当前根节点的值作为最大值，用于左子树的比较
                && isBinarySearchTree(root.rightChild, max, root.data);/*右子树把当前根节点的值作为最小值，用于右子树的比较*/
    }
    public static void main(String[] args) {
        TreeNode left = new TreeNode(7, new TreeNode(5, null, null), new TreeNode(8, null, null));
        TreeNode right = new TreeNode(15, new TreeNode(13, null, null), new TreeNode(18, null, null));
        Tree tree = new Tree(new TreeNode(10, left, right));
        ValidBinarySearchTree validBinarySearchTree = new ValidBinarySearchTree();
        System.out.println(validBinarySearchTree.isBinarySearchTree(tree.root, null, null));
    }

}
