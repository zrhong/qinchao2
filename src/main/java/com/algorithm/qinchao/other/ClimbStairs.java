package com.algorithm.qinchao.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/14 21:54
 * @description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 */
public class ClimbStairs {
    Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairsByRecursive(n);
    }

    private int climbStairsByRecursive(int n) {
        if (n <= 2) {
            return n;
        }
        int result = 0;
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            result = climbStairsByRecursive(n - 1)+climbStairsByRecursive(n - 2);
            cache.put(n, result);
        }
        return result;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println("请输入阶梯数");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            System.out.println("方法数：" + climbStairs.climbStairs(n));
        }
    }
}
