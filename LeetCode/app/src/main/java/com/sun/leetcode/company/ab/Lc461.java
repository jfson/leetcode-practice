package com.sun.leetcode.company.ab;

/**
 * Author: jfson sun
 * Create on:  2019/1/12
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc461 {
    /**
     The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

     Given two integers x and y, calculate the Hamming distance.

     Note:
     0 ≤ x, y < 231.

     Example:

     Input: x = 1, y = 4

     Output: 2

     Explanation:
     1   (0 0 0 1)
     4   (0 1 0 0)
            ↑   ↑

     The above arrows point to positions where the corresponding bits are different.
     */


    public int hammingDistance(int x, int y) {
        int res = x^y,ans = 0;

        while (res != 0){
            if (res%2 == 1) ans++;
            res /= 2;
        }

        return ans;
    }
}
