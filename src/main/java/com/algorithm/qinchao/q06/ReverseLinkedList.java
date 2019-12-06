package com.algorithm.qinchao.q06;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/9/30 11:09
 * @description https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    static ListNode revertListByNormal(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (null != curr) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    static ListNode reverseListByDiGui(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.getValue());
            temp = temp.next;
        }
        System.out.println();
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListByDiGui(head.next);
        System.out.println("p:" + p.getValue());
        head.next.next = head;
        head.next = null;
        return p;
    }

    @Getter
    @Setter
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int x) {
            value = x;
        }
    }

    static ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        head = root;
        while (head.next != null
                && head.next.next != null) {
            ListNode n1 = head.next;
            ListNode n2 = head.next.next;
            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            head = n1;

        }
        return root.next;
    }

    static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {//特殊情况处理，节点数量小于2
            return head;
        }
        ListNode root = new ListNode(0);//必须定义一个根节点，从而记住最后链表的头部
        root.next = head;//自定义节点next与链表链接上
        ListNode pre = root;//需要一个节点记住，发生交换前，上一次交换的末尾节点索引点

        while (pre.next != null && pre.next.next != null) {//下一次交换的下一个节点，下下个节点都不为空才能交换
            ListNode start = pre.next;//定义下一次交换的第一个节点
            ListNode then = pre.next.next;//定义下一次交换的第二个节点
            //第一个和第二个节点位置交换
            //这里有个必须注意的是，链表位置交换，比如1->2->3->4->5，这个链表，2和3要交换。执行交换操作就是
            //1先指向3，然后2执行4，最后3指向2,这样就链接起来了。
            pre.next = then;
            start.next = then.next;
            then.next = start;

            pre = start;//最后更新下一次交换前的上个节点node
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode result = null;
//        result = revertListByNormal(node);
        result = swapPairs2(node);
        printAll(result);


    }

    static void printAll(ListNode result) {
        while (result != null) {
            System.out.print(result.getValue());
            result = result.next;
        }
    }
}
