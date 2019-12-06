package com.algorithm.qinchao.q20;

import com.algorithm.qinchao.q18.TreeNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/3 16:36
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BinarySearchTree {
    private TreeNode root;

    /**
     * 查找二叉搜索树的元素，时间复杂度=O(logn)
     * @param num
     * @return
     */
    public TreeNode find(Integer num) {
        if (null == num) {
            return null;
        }
        TreeNode current = root;
        while (current != null) {
            if (num > current.getData()) {
                current = current.getRightChild();
            } else if (num < current.getData()) {
                current = current.getLeftChild();
            } else {
                return current;
            }
        }
        return null;
    }

    public boolean insert(Integer node) {
        if (null == node) {
            return false;
        }
        TreeNode newNode = new TreeNode(node, null, null);
        if (null == root) {
            root = newNode;
        }
        TreeNode currentNode = root;
        TreeNode parrent = null;
        //新节点一定是插入到最后的，所以判断到最后通过null来控制循环
        while (currentNode != null) {
            //记录父亲节点
            parrent = currentNode;
            Integer data = currentNode.getData();
            //新数据比当前节点大，应该去遍历右子树
            if (node > data) {
                currentNode = currentNode.getRightChild();
                //当前节点的又孩子没有而且这个新数据比当前节点要大，应该放在右子树
                if (currentNode == null) {
                    parrent.setRightChild(newNode);
                    return true;
                }
                //新数据比当前节点小，应该去遍历左子树
            } else if (node < data) {
                currentNode = currentNode.getLeftChild();
                //当前节点的右孩子没有而且这个新数据比当前节点要小，应该放在左子树
                if (currentNode == null) {
                    parrent.setLeftChild(newNode);
                    return true;
                }
                //新数据与当前节点一样，不需要插入，中断循环
            } else {
                return false;
            }
        }
        return false;
    }
}
