package com.algorithm.qinchao.q12;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/2 10:34
 * @description 时间复杂度=N个数据遍历*最大堆的最大值维护logk
 */
public class SlideWindowMaxByPriorityQueue {
    public int[] slideWindowMax(int[] nums, int k) {
        if (nums.length < k) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        //PriorityQueue是最小堆，Collections.reverseOrder()是反转，就是最大堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            //窗口最左侧移除
            if (i >= k) {
                priorityQueue.remove(nums[i - k]);
            }
            //加入新数，最大堆自己维护最大的值最堆顶，logk复杂度
            priorityQueue.offer(nums[i]);
            if (i + 1 >= k) {
                //堆顶为本次最大值
                result[i - k + 1] = priorityQueue.peek();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        SlideWindowMaxByPriorityQueue slideWindowMaxByDueue = new SlideWindowMaxByPriorityQueue();
        int[] result = slideWindowMaxByDueue.slideWindowMax(nums, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
