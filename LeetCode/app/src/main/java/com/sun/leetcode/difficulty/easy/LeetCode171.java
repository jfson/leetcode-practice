package com.sun.leetcode.difficulty.easy;

/**
 * Author: jfson sun
 * Create on:  2018/10/3
 * Question:    171. Excel Sheet Column Number
 * Description:
 * Train of thought:
 */
public class LeetCode171 {
//
//    A -> 1
//    B -> 2
//    C -> 3
//            ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//            ...
//    Input: "A"
//    Output: 1
//    Example 2:
//
//    Input: "AB"
//    Output: 28
//    Example 3:
//
//    Input: "ZY"
//    Output: 701

    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;

        int ret = 0;

        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            ret = ret * 26 + num;
        }

        return ret;
    }

}
