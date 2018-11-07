package com.sun.leetcode.difficulty.medium;

/**
 * Author: jfson sun
 * Create on:  2018/10/8
 * Question:    43. Multiply Strings
 * Description: Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * Train of thought:
 */
public class LeetCode43 {
    /**
     *    1       2       i = 1
     * x  3       4       j = 1
     * --------------
     * (1*4)（2*4）
     * (1*3) (2*3)
     * ------------------------
     * 0  4   0    8
     *
     * @param num1
     * @param num2
     * @return
     */

    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 ==null || num2.length() == 0) return "";

        int[] pos = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int low = i+j+1;
                int hight = i+j;

                sum += pos[low];
                pos[low] = sum % 10;
                pos[hight] += sum/10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int po : pos) {
            if (!(sb.length() == 0 && po == 0)){
                sb.append(po);
            }
        }


        return sb.length() == 0 ? "0" : sb.toString();
    }
}
