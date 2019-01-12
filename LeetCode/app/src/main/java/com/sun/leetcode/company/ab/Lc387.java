package com.sun.leetcode.company.ab;

/**
 * Author: jfson sun
 * Create on:  2019/1/12
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc387 {
    /**
     题意：找到第一个不重复的额字符，返回索引
     solution: String.lastIndexOf() == String.indexOf()
     */


    public int firstUniqChar(String s) {
        for(int i=0;i<s.length();i++){
            String curr = s.substring(i,i+1);
            if(s.lastIndexOf(curr)==(s.indexOf(curr))){
                return i;
            }
        }
        return -1;
    }
}
