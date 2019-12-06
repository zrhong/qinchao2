package com.algorithm.qinchao.other;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/13 16:33
 * @description 双向链表的单节点类
 */
public class Node<K,V> {
    final K key;
    V value;
    Node<K, V> prev;
    Node<K, V> next;

    Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
