package com.sun.leetcode.difficulty.easy;


/**
 * Author: jfson sun
 * Create on:  2018/9/26
 * Question: Implement strStr()
 * Description:  Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Train of thought:
 */
public class LeetCode28 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        if (haystack == null || haystack.length() < needle.length()) return -1;

        if (haystack.equals(needle)) return 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) { // index reduce needle.length()  Clarification : ==
            for (int j = 0; j < needle.length(); j++) { // 汗颜 。。不可以用indexOf...但是可以用别的。。哈哈哈哈
                if (haystack.substring(i, i + needle.length()).equals(needle)) {
                    return i;
                }
            }
        }

        return -1;
    }
}
