package com.sun.leetcode.company.ab;

/**
 * Author: jfson sun
 * Create on:  2019/1/13
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc246 {
    /**
     246. Strobogrammatic Number
     Easy
     A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

     Write a function to determine if a number is strobogrammatic. The number is represented as a string.

     Example 1:

     Input:  "69"
     Output: true
     Example 2:

     Input:  "88"
     Output: true
     Example 3:

     Input:  "962"
     Output: false
     // 题意：旋转180度看起来还是一样的
     // reverse 后，6变成9；9变成6；其他数不变
     // 排除 2，3，4，5，7
     */


    public boolean isStrobogrammatic(String num) {
        if(num.contains("2") || num.contains("3") || num.contains("4") ||num.contains("5") || num.contains("7"))
            return false;


        StringBuilder sb = new StringBuilder();

        for(int i = num.length()-1;i >= 0;i--){
            char curr = num.charAt(i);

            if(curr == '6'){
                sb.append('9');
            }else if(curr == '9'){
                sb.append('6');
            }else{
                sb.append(curr);
            }
        }

        return num.equals(sb.toString());

    }
}
