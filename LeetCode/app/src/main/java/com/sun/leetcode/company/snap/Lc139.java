package com.sun.leetcode.company.snap;

import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/12/13
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc139 {
    /**
     139. Word Break
     DescriptionHintsSubmissionsDiscussSolution
     Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

     Note:

     The same word in the dictionary may be reused multiple times in the segmentation.
     You may assume the dictionary does not contain duplicate words.
     Example 1:

     Input: s = "leetcode", wordDict = ["leet", "code"]
     Output: true
     Explanation: Return true because "leetcode" can be segmented as "leet code".
     Example 2:

     Input: s = "applepenapple", wordDict = ["apple", "pen"]
     Output: true
     Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
     Note that you are allowed to reuse a dictionary word.
     Example 3:

     Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     Output: false
     题意：组词
     solution: DP..拆解
     */

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (res[j] && wordDict.contains(s.substring(j,i))){
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
}
