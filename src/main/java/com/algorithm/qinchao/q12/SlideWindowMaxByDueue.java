package com.algorithm.qinchao.q12;

import java.util.LinkedList;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/2 09:26
 * @description 时间复杂度=N个数据的对比O(N)*每次的对比次数O(1)
 */
public class SlideWindowMaxByDueue {
    public int[] maxSlideWindow(int[] nums,int k) {
        if (nums.length < k) {
            return new int[0];
        }
        LinkedList<Integer> deque = new LinkedList();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            //队列有元素，如果队列的最左侧元素不在框内，需要剔除
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            //如果队列有元素而且队尾比新元素要小，踢出去
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            //加入新元素,要使用offer。不能使用push，使用push会加入头位置
//            deque.push(i);
            deque.offer(i);
            //一轮后挑出当次最大值   ，最大值为当前队列的最左元素
            if (i + 1 >= k) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        SlideWindowMaxByDueue slideWindowMaxByDueue = new SlideWindowMaxByDueue();
        int[] result = slideWindowMaxByDueue.maxSlideWindow(nums, 3);
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }
    }
}
