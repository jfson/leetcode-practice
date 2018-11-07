package com.sun.leetcode.difficulty.medium;

/**
 * Author: jfson sun
 * Create on:  2018/10/7
 * Question: 29. Divide Two Integers
 * Description:
 * Train of thought:
 */
public class LeetCode29 {
    //https://github.com/tongzhang1994/Facebook-Interview-Coding/blob/master/29.%20Divide%20Two%20Integers.java
    /**
     * 不能用取模等等
     * <p>
     * 1. + -
     * 2. 越界  long
     * 3. 结果 = 0 3/5
     * 4. 正常
     *
     * // 如果用常规减法  运算会比较慢
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        int sign = 1;

        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) sign = -1;

        if (divisor == 0) return dividend; // java crash

        // resturn = 0
        if (dividend == 0 || dividend > divisor) return 0;

        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);

        return 0; // first time
    }

    public long divide(long dividend, long divisor) {
        if (dividend > divisor) return 0;

        long sum = divisor;
        long x = 1;


        return 0L;
    }
}
