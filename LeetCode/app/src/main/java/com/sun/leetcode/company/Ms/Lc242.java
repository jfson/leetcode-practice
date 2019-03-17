package com.sun.leetcode.company.Ms;

/**
 * Author: jfson sun
 * Create on:  2019/3/17
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc242 {
    /**
     242. Valid Anagram
     Easy

     Given two strings s and t , write a function to determine if t is an anagram of s.

     Example 1:

     Input: s = "anagram", t = "nagaram"
     Output: true
     Example 2:

     Input: s = "rat", t = "car"
     Output: false
     Note:
     You may assume the string contains only lowercase alphabets.

     Follow up:
     What if the inputs contain unicode characters? How would you adapt your solution to such case?
     题意：给定两个字符串s和t，写一个函数来确定t是否是s的字谜。其实就是重拍后查看字符出现的次数是否一致。
     solution: 一个数组，每个字符对应一个索引。s中出现一次，+1计数，t中出现一次，-1计数，最后所有索引次数应该为0；
     */

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] ret = new int[26];
        for(char cur:s.toCharArray()){
            ret[cur - 'a']++;
        }

        for(char cur:t.toCharArray()){
            ret[cur - 'a']--;
        }

        for(int count:ret){
            if(count != 0){
                return false;
            }
        }

        return true;
    }
}
