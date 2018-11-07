package com.sun.leetcode.difficulty.easy;

/**
 * Author: jfson sun
 * Create on:  2018/10/2
 * Question:    125. Valid Palindrome
 * Description:
 * Train of thought:
 */
public class LeetCode125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        s = s.toLowerCase(); // 全部转成大写或者小写

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }

            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
}
