package com.sun.leetcode.difficulty.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/10/6
 * Question:    17. Letter Combinations of a Phone Number
 * Description:
 * Train of thought:
 */
public class LeetCode17 {
    /**
     17. Letter Combinations of a Phone Number
     Medium

     1721

     243

     Favorite

     Share
     Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

     A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



     Example:

     Input: "23"
     Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     Note:

     Although the above answer is in lexicographical order, your answer could be in any order you want.


     */
    String[] values = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) return list;

        StringBuilder str = new StringBuilder();
        dfs(list,str,digits,0);


        return list;
    }

    private void dfs( List<String> list,StringBuilder stringBuilder,String digits,int index){
        if (index == digits.length()){
            list.add(stringBuilder.toString());
            return;
        }

        int startIndex = digits.charAt(index) - '0';
        String currentStr = values[startIndex];

        for (int i = 0; i < currentStr.length() ;i++) {
            stringBuilder.append(currentStr.charAt(i));
            dfs(list,stringBuilder,digits,index+1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);// 删除最后一位
        }
    }


}
