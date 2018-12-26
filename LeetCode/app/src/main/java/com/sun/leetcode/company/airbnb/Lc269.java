package com.sun.leetcode.company.airbnb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: jfson sun
 * Create on:  2018/12/10
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc269 {
    /**

     269. Alien Dictionary
     DescriptionHintsSubmissionsDiscussSolution
     There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

     Example 1:

     Input:
     [
     "wrt",
     "wrf",
     "er",
     "ett",
     "rftt"
     ]

     Output: "wertf"
     Example 2:

     Input:
     [
     "z",
     "x"
     ]

     Output: "zx"
     Example 3:

     Input:
     [
     "z",
     "x",
     "z"
     ]

     Output: ""

     Explanation: The order is invalid, so return "".
     Note:

     You may assume all letters are in lowercase.
     You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
     If the order is invalid, return an empty string.
     There may be multiple valid order of letters, return any one of them is fine.

     题意：给个字符串数组。每个字符串按字典顺序出现。 先出现的在前面，最后所有非重复的组成一个单词，按先后顺序
     先后位置不对的情况，返回空（拓扑排序BFS/DFS）优先BFS...
     */

    public String alienOrder(String[] words) {

        return "";
    }


    public String alienOrder2(String[] words) {
        if (words == null || words.length == 0) return "";
        StringBuilder res = new StringBuilder();

        HashMap<Character, Set<Character>> map = new HashMap<>();
        int[] degree = new int[26];
        int count = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (degree[c - 'a'] == 0) {
                    count++;
                    degree[c - 'a'] = 1;
                }
            }
        }

        for (int i = 0; i < words.length -1; i++) {
            char[] curr = words[i].toCharArray();
            char[] next = words[i+1].toCharArray();

            int len = Math.min(curr.length,next.length);
            for (int j = 0; j < len; j++) {
                if (curr[j] != next[j]){
                    if (!map.containsKey(curr[j])){
                        map.put(curr[j],new HashSet<Character>());
                    }

                    if (map.get(curr[j]).add(next[j])){
                        degree[next[j]-'a']++;
                    }
                    break;
                }
            }
        }

//        ...

        return res.toString();
    }
}
