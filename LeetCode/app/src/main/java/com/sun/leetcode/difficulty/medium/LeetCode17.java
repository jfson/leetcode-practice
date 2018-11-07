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
