package com.sun.leetcode.difficulty.easy;

/**
 * Author: jfson sun
 * Create on:  2018/10/3
 * Question:    172. Factorial Trailing Zeroes
 * Description:Given an integer n, return the number of trailing zeroes in n!. 阶乘末尾 的0的个数
 * Train of thought:
 */
public class LeetCode172 {

    // 阶乘容易溢出，不可直接计算阶乘

    // 拆解
    // 10 拆解为 2* 5
    // 2的个数远大于 5 ，取5的个数
    // 含有5的个数还有 25，125等等需要考虑

    public int trailingZeroes(int n) {
        int ret = 0;

        while (n>0){ // 求 5的个数
            ret += n /5;
            n /= 5;
        }

        return ret;
    }
}
