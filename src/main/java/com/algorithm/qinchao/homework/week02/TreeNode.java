package com.algorithm.qinchao.homework.week02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/3 10:14
 * @description 树节点
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(Integer val) {
        this.val = val;
    }
}
