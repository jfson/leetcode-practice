package com.sun.leetcode.difficulty.easy;


/**
 * Author: jfson sun
 * Create on:  2018/9/28
 * Question:    67. Add Binary
 * Description: Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 * Train of thought:
 */
public class LeetCode67 {
//    Input: a = "11", b = "1"
//    Output: "100"

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;

        int aLength = a.length() - 1;
        int bLength = b.length() - 1;
        StringBuilder ret = new StringBuilder();

        int lastPositionSum = 0;

        // a,b 共同位
        while (aLength >= 0 && bLength >= 0) {
            // - '0' 为了ascii码转int值
            int num = (a.charAt(aLength) - '0' + b.charAt(bLength) - '0') + lastPositionSum;
            lastPositionSum = num / 2;
            ret.append(num % 2);
            aLength--;
            bLength--;

        }

        // a > b
        while (aLength >= 0) {
            int num = a.charAt(aLength) - '0' + lastPositionSum;
            lastPositionSum = num / 2;
            ret.append(num % 2);

            aLength--;

        }

        // a 《 b
        while (bLength >= 0) {
            int num = b.charAt(bLength) - '0' + lastPositionSum;
            lastPositionSum = num / 2;
            ret.append(num % 2);

            bLength--;
        }

        //补位
        if (lastPositionSum >0){
            ret.append(lastPositionSum);
        }

        return ret.reverse().toString();
    }
}
