package com.sun.leetcode.difficulty.easy;

/**
 * Author: jfson sun
 * Create on:  2018/10/2
 * Question:    125. Valid Palindrome
 * Description:
 * Train of thought:
 */
public class LeetCode125 {
    /**
     125. Valid Palindrome
     Easy
     Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

     Note: For the purpose of this problem, we define empty string as valid palindrome.

     Example 1:

     Input: "A man, a plan, a canal: Panama"
     Output: true
     Example 2:

     Input: "race a car"
     Output: false

     题意： 判断一个字符是不是回文。符号或者空格不算
     思路： 非字符的时候跳过即可
     */
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
