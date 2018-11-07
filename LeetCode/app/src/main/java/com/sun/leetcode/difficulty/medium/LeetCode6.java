package com.sun.leetcode.difficulty.medium;

/**
 * Author: jfson sun
 * Create on:  2018/10/5
 * Question:    6. ZigZag Conversion
 * Description:    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * Train of thought: 每一列的第一个 为 2n-2
 */
public class LeetCode6 {
    public String convert(String s, int numRows) {
        int length = s.length();
        StringBuilder str = new StringBuilder();
        if (numRows > s.length() || numRows <= 1) {
            return s;
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0, index = i; index < length; j++, index = (2 * numRows - 2) * j + i) {
                str.append(s.charAt(index));// 列 第一个元素
                if (i == 0 || i == numRows - 1) continue; // 对角元素
                if (index + (numRows - i -1) * 2 <s.length()){
                    str.append(s.charAt(index + (numRows -i -1) * 2));
                }
            }
        }

        return str.toString();
    }
}
