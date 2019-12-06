package com.algorithm.qinchao.q15;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/2 15:23
 * @description 时间复杂度=遍历所有数据O(N)*操作mapO(1)
 */
public class SumTwoNumsByMap {
    int[] sumTwoNums(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{i, map.get(result)};
            } else {
                map.put(temp, i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int target = 9;
        SumTwoNumsByMap sumTwoNumsByMap = new SumTwoNumsByMap();
        int[] ints = sumTwoNumsByMap.sumTwoNums(nums, target);
        for (int n:ints) {
            System.out.println(n);
        }
    }

}
