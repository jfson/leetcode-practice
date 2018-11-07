package com.sun.leetcode.difficulty.easy;

/**
 * Author: jfson sun
 * Create on:  2018/10/3
 * Question:    168. Excel Sheet Column Title
 * Description: Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * Train of thought:
 */
public class LeetCode168 {
//    1 -> A
//    2 -> B
//    3 -> C
//    ...
//            26 -> Z
//    27 -> AA
//    28 -> AB
//    ...
    // 26进制转换
    public String convertToTitle(int n) {
        if (n<0) return "";
        StringBuilder stringBuilder = new StringBuilder();

        while (n > 0){
            if (n % 26 == 0) {
                stringBuilder.append('Z');
                n = n/26 -1;
            }else {
                int charA = 'A' + (n%26-1);
                stringBuilder.append((char) charA);
                n = n/26;
            }
        }

        return stringBuilder.reverse().toString();
    }
}
