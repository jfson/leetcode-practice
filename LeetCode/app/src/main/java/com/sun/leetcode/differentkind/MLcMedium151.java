package com.sun.leetcode.differentkind;

/**
 * Author: jfson sun
 * Create on:  2018/12/3
 * Question:
 * Description:
 * Train of thought:
 */
public class MLcMedium151 {
    /**
     * Given an input string, reverse the string word by word.
     * <p>
     * Example:
     * <p>
     * Input: "the sky is blue",
     * Output: "blue is sky the".
     * Note:
     * <p>
     * A word is defined as a sequence of non-space characters.
     * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
     * You need to reduce multiple spaces between two words to a single space in the reversed string.
     * Follow up: For C programmers, try to solve it in-place in O(1) space.
     * 题意：reverse 单词
     */

    public String reverseWords(String s) {
        if (s == null) return s;
        String[] parts = s.trim().split("\\s+");

        String out = " ";

        for (int i = parts.length-1; i > 0; i--) {
            out += parts[i] + " ";
        }

        return out + parts[0];
    }
}
