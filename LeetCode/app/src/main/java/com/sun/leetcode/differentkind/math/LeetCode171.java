package com.sun.leetcode.differentkind.math;

/**
 * Author: jfson sun
 * Create on:  2019/1/15
 * Question:
 * Description:
 * Train of thought:
 */
public class LeetCode171 {
    /**
     171. Excel Sheet Column Number
     Easy

     Given a column title as appear in an Excel sheet, return its corresponding column number.

     For example:

     A -> 1
     B -> 2
     C -> 3
     ...
     Z -> 26
     AA -> 27
     AB -> 28
     ...
     Example 1:

     Input: "A"
     Output: 1
     Example 2:

     Input: "AB"
     Output: 28
     Example 3:

     Input: "ZY"
     Output: 701
     题意： 转换；其实是26进制
     */

    public int titleToNumber(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length-1; i >=0; i--) {
            int curr = chars[i] - 'A' +1;
            sum += curr * Math.pow(26, s.length()-i-1);
        }

        return sum;
    }
}
