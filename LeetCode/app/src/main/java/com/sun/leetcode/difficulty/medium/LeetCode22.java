package com.sun.leetcode.difficulty.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/10/6
 * Question:    22. Generate Parentheses
 * Description:
 * Train of thought:
 */
public class LeetCode22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;

        String item = new String();


        dfs(res, item, n, n);
        return res;
    }

    public void dfs(List<String> res, String itemString, int left, int right) {
        if (left > right) return;

        if (left == 0 && right == 0) { // dfs 临界条件
            res.add(itemString);
            return;
        }

        if (left > 0) {
            dfs(res, itemString + '(', left - 1, right);
        }

        if (right > 0) {
            dfs(res, itemString + ')', left, right - 1);
        }
    }
}
