package com.sun.leetcode.difficulty.medium;


/**
 * Author: jfson sun
 * Create on:  2018/10/4
 * Question:    5. Longest Palindromic Substring
 * Description:    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Train of thought: palindromic
 */
public class LeetCode5 {

//    Input: "babad"
//    Output: "bab"

//    or
//    Input: "cbbd"
//    Output: "bb"

//    return
    // aba
    // abba

    // use DP or from middle to other side

    String maxStr = "";

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;

        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);  // aba  start with  b
            helper(s, i, i + 1); // abba
        }

        return maxStr;
    }

    //from middle to other side
    public void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        String substring = s.substring(left + 1, right);
        if (substring.length() > maxStr.length()) {
            maxStr = substring;
        }
    }
}
