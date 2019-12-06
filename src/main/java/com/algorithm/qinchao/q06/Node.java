package com.algorithm.qinchao.q06;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/1 10:16
 * @description 栈/队列的一个节点数据结构
 */
@Setter
@Getter
@NoArgsConstructor
public class Node {
    String value;
    Node next = null;

    Node(String x) {
        this.value = x;
    }
}