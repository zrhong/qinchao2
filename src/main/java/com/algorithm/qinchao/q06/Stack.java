package com.algorithm.qinchao.q06;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/9/30 17:28
 * @description
 */
@Getter
@Setter
@NoArgsConstructor
/**
 * 模拟栈结构
 * @author zhuruihong
 */
public class Stack {
    //栈顶指针
    private Node top = null;

    /**
     * 入栈
     *
     * @param element
     */
    void push(String element) {
        Node newNode = new Node(element);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * 出栈
     *
     * @return
     */
    String pop() {
        if (top == null) {
            return null;
        }
        String value = top.getValue();
        top = top.next;
        return value;
    }

    /**
     * 使用栈结构模拟队列先进先出
     *
     * @param in
     * @param out
     */
    void stack2Queue(Stack in, Stack out) {
        Node inTop = in.getTop();
        Node outTop = out.getTop();
        if (inTop == null && outTop != null) {
            printAll(out, true);
        } else if (inTop != null && outTop == null) {
            while (inTop != null) {
                out.push(inTop.getValue());
                inTop = inTop.getNext();
            }
            printAll(out, true);
        } else if (inTop != null && outTop != null) {
            printAll(out, false);
            while (inTop != null) {
                out.push(inTop.getValue());
                inTop = inTop.getNext();
            }
            printAll(out, true);
        } else {
            System.out.println("空");
        }

    }

    /**
     * 弹栈并输出
     *
     * @param stack
     * @param nextline
     */
    void printAll(Stack stack, boolean nextline) {
        String element = null;
        while ((element = stack.pop()) != null) {
            System.out.print(element + " ");
//            top = top.getNext();
        }
        if (nextline) {
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请选择操作，0：入元素，1：输出元素");
            String operate = sc.next();
            if ("0".equals(operate)) {
                System.out.println("请输入队列元素");
                String element = sc.next();
                stack.push(element);
            } else if ("1".equals(operate)) {
                stack.stack2Queue(stack, new Stack());
            } else if ("9".equals(operate)) {
                break;
            } else {
                System.out.println("输入有误，请重新输入");
            }
        }
        System.out.println("gameover");
    }

}
