package com.sun.leetcode.differentkind.array;

import android.util.Log;

/**
 * Author: jfson sun
 * Create on:  2018/10/31
 * Question:    1-bit and 2-bit Characters
 * Description:
 * Train of thought:
 */
public class EasyLc717 {
    /**
     * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
     * <p>
     * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
     * <p>
     * Example 1:
     * Input:
     * bits = [1, 0, 0]
     * Output: True
     * Explanation:
     * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
     * Example 2:
     * Input:
     * bits = [1, 1, 1, 0]
     * Output: False
     * Explanation:
     * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
     * <p>
     * <p>
     * 题意：是否能以0，10，11 组成以0结尾的数
     * solution：EasyLc167.java
     EasyLc697.java
     */


    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null) return false;
        if( bits.length == 1 && bits[0] == 0) return true;

        int oneNums = 0;
        //Starting from one but last, as last one is always 0.
        for (int i = bits.length - 2; i >= 0 && bits[i] != 0; i--) {
            oneNums++;
        }

        if (oneNums % 2 > 0) return false;

        return true;
    }
}
