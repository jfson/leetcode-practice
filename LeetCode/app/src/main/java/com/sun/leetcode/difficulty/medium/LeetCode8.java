package com.sun.leetcode.difficulty.medium;

/**
 * Author: jfson sun
 * Create on:  2018/10/5
 * Question: String to Integer (atoi)
 * Description:
 * Train of thought:
 */
public class LeetCode8 {
    public int myAtoi(String str) {
        int sign = 1; // 正
        int res = 0;

        int i = 0;

        if (str == null || str.length() == 0) return 0;

        while (i < str.length() && str.charAt(i) == ' ') i++;

        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        if (str.charAt(i) == '+') {
            if (sign == -1) return 0;
            i++;
        }

        for (; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') break;

            // 溢出
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0') > Integer.MAX_VALUE % 10)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            res = res * 10 + (str.charAt(i) - '0');
        }


        return res * sign;
    }
}
