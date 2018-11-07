package com.sun.leetcode.difficulty.easy;


import java.util.HashMap;

/**
 * Author:jfson sun
 * Create on:  2018/9/24
 * Question:13. Roman to Integer
 * Description：Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * 思路 ：往前2位一读，在前面则减，后面则加
 */
public class LeetCode13 {

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ret = map.get(s.charAt(s.length() - 1)); // i == length - 2,最后一位没有算

        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                ret += map.get(s.charAt(i));
            } else {
                ret -= map.get(s.charAt(i));
            }
        }

        return ret;
    }
}
