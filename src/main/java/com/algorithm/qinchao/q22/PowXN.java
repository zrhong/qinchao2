package com.algorithm.qinchao.q22;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/4 09:52
 * @description 计算X的n次方值
 */
public class PowXN {
    /**
     * 直接使用库函数
     *
     * @param x 底数
     * @param n 指数
     * @return
     */
    double powXnByLib(int x, int n) {
        return Math.pow(x, n);
    }

    /**
     * 使用循环阶乘  时间复杂度O(N)
     *
     * @param x
     * @param n
     * @return
     */
    double powXnByViolence(double x, int n) {
        if (x == 0) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        double result = 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        for (int i = 1; i <= n; i++) {
            result = result * x;
        }
        return result;
    }

    /** 使用递归分治方法，时间复杂度=O(logn)
     * @param x
     * @param n
     * @return
     */
    double powXnByRecursiveDivision(double x, int n) {
        if (x == 0) {
            return x;
        }
        if (n == 0) {
            return 1;
        }

        double result = 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        if (n % 2 == 0) {
            result = powXnByRecursiveDivision(x, n >> 1);
            return result * result;
        } else {
            result = powXnByRecursiveDivision(x, n - 1 >> 1);
            return x * result * result;
        }
    }

    public static void main(String[] args) {
        PowXN powXN = new PowXN();
        int x = 2;
        int n = -2;
        LocalDateTime start = LocalDateTime.now();
        System.out.println(powXN.powXnByLib(x, n));
        LocalDateTime end = LocalDateTime.now();
        System.out.println(Duration.between(start, end).getSeconds());
        LocalDateTime start1 = LocalDateTime.now();
        System.out.println(powXN.powXnByViolence(x, n));
        LocalDateTime end1 = LocalDateTime.now();
        System.out.println(Duration.between(start1, end1).getSeconds());
        LocalDateTime start2 = LocalDateTime.now();
        System.out.println(powXN.powXnByRecursiveDivision(x, n));
        LocalDateTime end2 = LocalDateTime.now();
        System.out.println(Duration.between(start2, end2).getSeconds());
    }
}
