package com.sun.leetcode.difficulty.medium;

/**
 * Author: jfson sun
 * Create on:  2018/10/5
 * Question:
 * Description:
 * Train of thought:
 */
public class LeetCode12 {


    public String intToRoman(int num) {
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numSymbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

//        if (num <= 0) return "";

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i<value.length; i++) {
            while (num >= value[i]) {
                num -= value[i];
                roman.append(numSymbol[i]);
            }
        }

        return roman.toString();
    }
}
