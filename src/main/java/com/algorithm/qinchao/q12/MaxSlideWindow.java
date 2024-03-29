package com.algorithm.qinchao.q12;

import java.util.LinkedList;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/1 21:08
 * @description
 */
public class MaxSlideWindow {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums == null || nums.length == 0) {
                return new int[0];
            }
            LinkedList<Integer> deque = new LinkedList<Integer>();
            int[] res = new int[nums.length + 1 - k];
            for(int i = 0; i < nums.length; i++){
                // 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
                if(!deque.isEmpty() && deque.peekFirst() == i - k) {
                    deque.poll();
                }
                // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
                while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.removeLast();
                }
                // 加入新数
                deque.offerLast(i);
                // 队列头部就是该窗口内第一大的
                if((i + 1) >= k) {
                    res[i + 1 - k] = nums[deque.peek()];
                }
            }
            return res;
        }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        MaxSlideWindow maxSlideWindow = new MaxSlideWindow();
        System.out.println(maxSlideWindow.maxSlidingWindow(nums, 3));
    }
}
