package com.algorithm.qinchao.q18;

import lombok.*;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/3 10:16
 * @description 树
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tree {
    TreeNode root;

    public TreeNode find(Integer num) {
        if (null == num) {
            return null;
        }
        TreeNode current = root;
        while (current != null) {
            if (num > current.data) {
                current = current.rightChild;
            } else if (num < current.data) {
                current = current.leftChild;
            } else {
                return current;
            }
        }
        return null;
    }
}
