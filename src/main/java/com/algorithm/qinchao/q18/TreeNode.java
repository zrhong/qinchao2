package com.algorithm.qinchao.q18;

import lombok.*;

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
    Integer data;
    TreeNode leftChild;
    TreeNode rightChild;
}
