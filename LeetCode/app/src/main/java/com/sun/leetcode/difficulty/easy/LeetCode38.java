package com.sun.leetcode.difficulty.easy;

/**
 * Author: jfson sun
 * Create on:  2018/9/26
 * Question: 38.Count and Say
 * Description: The count-and-say sequence is the sequence of integers with the first five terms as following:
 * Train of thought:
 */
public class LeetCode38 {

    /**
     38. Count and Say
     Easy

     The count-and-say sequence is the sequence of integers with the first five terms as following:

     1.     1
     2.     11
     3.     21
     4.     1211
     5.     111221
     1 is read off as "one 1" or 11.
     11 is read off as "two 1s" or 21.
     21 is read off as "one 2, then one 1" or 1211.

     Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

     Note: Each term of the sequence of integers will be represented as a string.



     Example 1:

     Input: 1
     Output: "1"
     Example 2:

     Input: 4
     Output: "1211"
     题意：数前一项的 1的个数，2的个数
     */
    public String countAndSay(int n) {
        int i = 1;
        String res = "1";
        while (i < n) {
            int count = 0;
            StringBuilder sb = new StringBuilder();

            char read = res.charAt(0);

            for (int j = 0; j <= res.length(); j++) {
                if (j != res.length() && res.charAt(j) == read) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(read);

                    if (j != res.length()) {
                        count = 1;
                        read = res.charAt(j);
                    }
                }
            }

            res = sb.toString();
            i++;
        }

        return res;
    }
}
