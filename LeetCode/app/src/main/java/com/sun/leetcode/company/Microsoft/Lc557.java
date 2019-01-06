package com.sun.leetcode.company.Microsoft;

import java.util.Arrays;

/**
 * Author: jfson sun
 * Create on:  2019/1/5
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc557 {
    /**
     557. Reverse Words in a String III
     DescriptionHintsSubmissionsDiscussSolution
     Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

     Example 1:
     Input: "Let's take LeetCode contest"
     Output: "s'teL ekat edoCteeL tsetnoc"
     Note: In the string, each word is separated by single space and there will not be any extra space in the string.

     题意：翻转数组。空格当分隔符
     */

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;

        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String curr :strs){
            sb.append(curr).append(" ");
        }

        return sb.toString().trim();
    }

    public String reverse(String str){
        if (str == null || str.length() == 0) return str;

        char[] strs = str.toCharArray();
        for (int i = 0; i < strs.length/2; i++) {
            char temp = strs[i];
            strs[i] = strs[strs.length-1-i];
            strs[str.length()-1-i] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (char s:strs){
            sb.append(s);
        }

        return sb.toString();
    }
}
