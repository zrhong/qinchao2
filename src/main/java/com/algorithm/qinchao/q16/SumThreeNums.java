package com.algorithm.qinchao.q16;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/2 16:05
 * @description
 */
public class SumThreeNums {
    /**
     * 暴力破解法，三层循环，时间复杂度O(N*N*N),空间复杂度O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] sumThreeNumsByViolence(int[] nums, int target) {
        if (nums.length < 3) {
            throw new RuntimeException("数组异常");
        }
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == target) {
                        return new int[]{nums[i], nums[j], nums[k]};
                    }
                }
            }
        }
        return new int[0];
    }

    /**
     * 优化版，利用set，时间复杂度O(N*N)，空间复杂度O(N)，使用了额外的set存储数据
     * @param nums
     * @param target
     * @return
     */

    public int[] sumThreeNumsByPretty(int[] nums, int target) {
        if (nums.length < 3) {
            throw new RuntimeException("数组异常");
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int temp = target - nums[i] - nums[j];
                if (set.contains(temp)) {
                    return new int[]{nums[i], nums[j], temp};
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return new int[0];
    }


    /**
     * 先将数组排序，时间复杂度为快排NlogN,使用中间逼近法，通过指针的移动判断，时间复杂度=遍历所有元素O(N)*遍历剩下的元素O(N)+NlogN =O(N*N) ,
     * @param nums
     * @param target
     * @return
     */
    public int[] sumThreeNumsBySort(int[] nums, int target) {
        if (nums.length < 3) {
            throw new RuntimeException("数组异常");
        }
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i++) {
            int temp = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left != right) {
                if (nums[left] + nums[right] + temp > target) {
                    right--;
                } else if (nums[left] + nums[right] + temp < target) {
                    left++;
                } else {
                    return new int[]{temp,nums[left],nums[right]};
                }
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,3,-1,-3,5,3,6,7};
        int target = 9;
        SumThreeNums sumThreeNums = new SumThreeNums();
        int[] ints = sumThreeNums.sumThreeNumsByViolence(nums, target);
        for (int n:ints) {
            System.out.println(n);
        }

        int[] ints2 = sumThreeNums.sumThreeNumsByPretty(nums, target);
        for (int n:ints2) {
            System.out.println(n);
        }

        int[] ints3 = sumThreeNums.sumThreeNumsBySort(nums, target);
        for (int n:ints3) {
            System.out.println(n);
        }
    }
}
