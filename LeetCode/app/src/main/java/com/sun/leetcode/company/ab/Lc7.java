package com.sun.leetcode.company.ab;

/**
 * Author: jfson sun
 * Create on:  2019/1/12
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc7 {
    /**
     7. Reverse Integer
     Easy

     1831

     2614

     Favorite

     Share
     Given a 32-bit signed integer, reverse digits of an integer.

     Example 1:

     Input: 123
     Output: 321
     Example 2:

     Input: -123
     Output: -321
     Example 3:

     Input: 120
     Output: 21
     Note:
     Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

     注意：翻转后会溢出，用long接一下
     */
    public int reverse(int x) {
        int pre = 1;
        if(x < 0){
            x = x * (-1);
            pre = -1;
        }

        long reverse = 0;
        int p = x;
        while(p >= 1){
            int num = p % 10;
            reverse = reverse * 10 + num;
            p = p / 10;
        }

        if(reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE) return 0;

        return pre * (int)reverse;
    }
}
