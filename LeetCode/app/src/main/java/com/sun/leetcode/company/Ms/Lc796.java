package com.sun.leetcode.company.Ms;

/**
 * Author: jfson sun
 * Create on:  2019/3/17
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc796 {
    /**
     796. Rotate String
     Easy

     We are given two strings, A and B.

     A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

     Example 1:
     Input: A = 'abcde', B = 'cdeab'
     Output: true

     Example 2:
     Input: A = 'abcde', B = 'abced'
     Output: false
     题意： 按顺序截取后reverse，查看是否符合规律
     solution： A + A肯定包含B
     */
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
