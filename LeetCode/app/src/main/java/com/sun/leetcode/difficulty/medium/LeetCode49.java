package com.sun.leetcode.difficulty.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: jfson sun
 * Create on:  2018/10/10
 * Question:    49. Group Anagrams
 * Description: Given an array of strings, group anagrams together.
 * Train of thought:
 */
public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Arrays.sort(strs);
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String sortStr = String.valueOf(chars);
            if (!map.containsKey(sortStr)) {
                map.put(sortStr, new ArrayList<String>());
            }

            map.get(sortStr).add(str);
        }


        return new ArrayList<>(map.values());
    }
}
