package com.algorithm.qinchao.q06;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/9/30 13:02
 * @description
 */
public class ReverseLinkedList1 {
    @Setter
    @Getter
    static class ListNode {
        int value;
        ListNode next;
        ListNode(int x) {
            this.value = x;
        }
        ListNode() {

        }
    }

    static ListNode reverseLinkedList(ListNode head) {
        ListNode result = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;//截取的点
            curr.next = result;//将当前的next指针断开
            result = curr;//curr只剩下断开后的前半部分
            curr = temp;//截取的后半部分赋值到当前留给下次用
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode result = reverseLinkedList(node);
        while (result != null) {
            System.out.print(result.getValue());
            result = result.next;
        }
    }
}
