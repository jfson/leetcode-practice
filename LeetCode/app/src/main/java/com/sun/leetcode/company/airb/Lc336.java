package com.sun.leetcode.company.airb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/12/25
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc336 {

    /**
     336. Palindrome Pairs
     DescriptionHintsSubmissionsDiscussSolution
     Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

     Example 1:

     Input: ["abcd","dcba","lls","s","sssll"]
     Output: [[0,1],[1,0],[3,2],[2,4]]
     Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
     Example 2:

     Input: ["bat","tab","cat"]
     Output: [[0,1],[1,0]]
     Explanation: The palindromes are ["battab","tabbat"]

     题意： 返回两个可以拼成回文数的索引List
     solution: 暴力解法会超时。HashMap
     */

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        if (words == null || words.length == 0) return result;
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i],i);
        }

        for (int i = 0; i < words.length; i++) {
            int left = 0, right =  0;
            while (left <= right){
                String s = words[i].substring(left,right);
                Integer j = map.get(new StringBuilder(s).reverse().toString());

                if (j != null && i != j && isPalindrome(words[i].substring(left==0?right:0,left ==0 ? words[i].length():left))){
                    System.out.print("i:" + i +"-->j:" +j);
                    System.out.print("left:" +  left +"-->right:" +right);
                    result.add(Arrays.asList(left == 0 ? new Integer[]{i,j} :new Integer[]{j,i}));
                }

                if (right < words[i].length()) {
                    right++;
                }else {
                    left++;
                }
            }
        }

        return result;
    }


    public boolean isPalindrome(String str){
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i -1)){
                return false;
            }
        }
        return true;
    }
}
