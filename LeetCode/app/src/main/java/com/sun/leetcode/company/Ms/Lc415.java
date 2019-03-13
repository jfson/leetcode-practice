package com.sun.leetcode.company.Ms;

/**
 * Author: jfson sun
 * Create on:  2018/12/21
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc415 {
    /**
     * 415. Add Strings
     * DescriptionHintsSubmissionsDiscussSolution
     * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
     * <p>
     * Note:
     * <p>
     * The length of both num1 and num2 is < 5100.
     * Both num1 and num2 contains only digits 0-9.
     * Both num1 and num2 does not contain any leading zero.
     * You must not use any built-in BigInteger library or convert the inputs to integer directly.
     * <p>
     * 题意：求和。
     */


    public String addStrings(String num1, String num2) {
        char[] num1CharArray = num1.toCharArray();
        char[] num2CharArray = num2.toCharArray();

        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (l1 >= 0 || l2 >= 0 || carry == 1) {
            int a = l1 >= 0 ? (num1CharArray[l1--] - '0') : 0;
            int b = l2 >= 0 ? (num2CharArray[l2--] - '0') : 0;

            int sum = a + b + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }


        return sb.toString();
    }
}
