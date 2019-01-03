package com.sun.leetcode.company.ab;

/**
 * Author: jfson sun
 * Create on:  2019/1/3
 * Question:
 * Description:
 * Train of thought:
 */

import java.util.*;

public class PalindromePairs {
    /*
        Palindrome Pairs - HashMap
        AirBnB Interview Question
        题意：String[]中可以拼成回文的元素索引
     */
        private boolean isPalindrome(String s) {
            for (int i = 0; i < s.length() / 2; ++i)
                if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                    return false;
            return true;
        }

        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> res = new ArrayList<>();
            if (words == null) return res;
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < words.length; i++) map.put(words[i], i);
            for (int i = 0; i < words.length; i++) {
                int left = 0, right = 0;
                while (left <= right) {
                    String s = words[i].substring(left, right);
                    Integer j = map.get(new StringBuilder(s).reverse().toString());
                    if (j != null && i != j && isPalindrome(words[i].substring(left == 0 ? right : 0, left == 0 ? words[i].length() : left)))
                        res.add(Arrays.asList(left == 0 ? new Integer[]{i, j} : new Integer[]{j, i}));
                    if (right < words[i].length()) right++;
                    else left++;
                }
            }
            return res;
        }
}
