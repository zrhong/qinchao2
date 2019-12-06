package com.algorithm.qinchao.q06;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/1 10:15
 * @description
 */
@NoArgsConstructor
@Setter
@Getter
public class Queue {
    private Node head = null;
    private Node tail = null;

    void enqueue(String elemente) {
        Node newNode = new Node(elemente);
        if (tail == null && head == null) {
            head = newNode;
            tail = newNode;
        } else {
            //队尾指向新节点
            tail.next = newNode;
            //队尾移像新节点的next指针
            tail = tail.next;
        }

    }

    String dequeue() {
        if (head == null) {
            return null;
        }
       String result =  head.getValue();
        //head指针移向下一个元素
        head = head.next;
        //head的下一个元素如果是空，证明已经是队尾了，队尾初始化
        if (head == null) {
            tail = null;
        }
        return result;
    }

}
