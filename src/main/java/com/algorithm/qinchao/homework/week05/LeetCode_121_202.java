package com.algorithm.qinchao.homework.week05;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/16 14:27
 * @description 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_121_202 {
    /**
     * base case：
     * dp[-1][k][0] = dp[i][0][0] = 0
     * dp[-1][k][1] = dp[i][0][1] = -infinity
     * <p>
     * 状态转移方程：
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
     * <p>
     * 此时k=1   dp[i][k][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])  ->dp[i][k][1] = max(dp[i-1][1][1], 0 - prices[i])
     * 所有k都是一样，直接忽略得到
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], - prices[i])
     * dp_i_0 = 0（不买肯定为0）, dp_i_1 = Integer.MIN_VALUE（卖可能是最高的，所有负的最多）;
     * 只需记录上一次的状态最大值一次替换即可
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int dpI0 = 0;
        int dpI1 = Integer.MIN_VALUE;
        for (int price : prices) {
            dpI0 = Math.max(dpI0, dpI1 + price);
            dpI1 = Math.max(dpI1, -price);
        }
        return Math.max(dpI0, dpI1);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(LeetCode_121_202.maxProfit(prices));
    }
}
