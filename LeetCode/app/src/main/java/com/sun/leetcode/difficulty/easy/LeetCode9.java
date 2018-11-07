package com.sun.leetcode.difficulty.easy;


/**
 * Author:jfson sun
 * Create on:  2018/9/24
 * Description：Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * question ： 前后读都是回文数
 * 思路 ：A:翻转相等  B: 或者转String 翻转
 *
 */
public class LeetCode9 {

    public boolean isPalindrome(int x) {
        String xNum = String.valueOf(x);
        String revertNum = new StringBuffer(xNum).reverse().toString();
        return xNum.equals(revertNum);
    }
}
