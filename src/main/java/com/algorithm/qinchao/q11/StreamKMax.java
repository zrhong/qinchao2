package com.algorithm.qinchao.q11;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/1 13:50
 * @description
 */
public class StreamKMax {
    private PriorityQueue<Integer> queue;
    private int k;

    StreamKMax(int k, int[] arr) {
        this.k = k;
        queue = new PriorityQueue<Integer>(k);
        for (int n : arr) {
            add(n);
        }
    }

    void add(int element) {
        if (queue.size() < k) {
            queue.offer(element);
        } else if (queue.peek() < element) {
            queue.poll();
            queue.offer(element);
        }
        System.out.println(Arrays.asList(queue.toArray()));
    }

    public static void main(String[] args) {
        StreamKMax streamKMax = new StreamKMax(4, new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入数字");
            int input = scanner.nextInt();
            streamKMax.add(input);
        }
    }

}
