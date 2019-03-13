package com.sun.leetcode.company.Ms;

import java.util.Stack;

/**
 * Author: jfson sun
 * Create on:  2018/12/17
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc402 {

    /**
     * 402. Remove K Digits
     * DescriptionHintsSubmissionsDiscussSolution
     * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
     * <p>
     * Note:
     * The length of num is less than 10002 and will be ≥ k.
     * The given num does not contain any leading zero.
     * Example 1:
     * <p>
     * Input: num = "1432219", k = 3
     * Output: "1219"
     * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
     * Example 2:
     * <p>
     * Input: num = "10200", k = 1
     * Output: "200"
     * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
     * Example 3:
     * <p>
     * Input: num = "10", k = 2
     * Output: "0"
     * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
     * <p>
     * 题意： 删除n个字符。找出最小值
     * solution:假设num的组成是"abc....."，如果删掉'a'，那么剩下的是"bc...."，一定是由b打头；
     * 如果删掉任何a之后的字符，剩下的string必定由a打头。于是比较a和b的大小即可，用Greedy的思路选择最优解即可。
     */

    public String removeKdigits(String num, int k) {
        if ("0".equals(num) || k < 1) return num;

        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                --k;
            }

            if (stack.empty() && c == '0') { // discard '0' at end
                continue;
            }

            stack.push(c);
        }

        while (!stack.empty() && k-- > 0) { // case 1234
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()){
            sb.insert(0,stack.pop());
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
