package com.algorithm.qinchao.q15;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/2 15:17
 * @description 时间复杂度 = O(N*N)
 */
public class SumTwoNumsByViolence {
    public int[] sumTwoNums(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[0];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int target = 9;
        SumTwoNumsByViolence sumTwoNumsByViolence = new SumTwoNumsByViolence();
        int[] ints = sumTwoNumsByViolence.sumTwoNums(nums, target);
        for (int n:ints) {
            System.out.println(n);
        }
    }
}
