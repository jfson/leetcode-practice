package com.sun.leetcode.company.Ms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author: jfson sun
 * Create on:  2019/12/22
 * Question:
 * Description:
 * Train of thought:
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

 示例 1:

 输入: [10,2]
 输出: 210
 示例 2:

 输入: [3,30,34,5,9]
 输出: 9534330
 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class Lc179 {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String aStrArr : str) {
            sb.append(aStrArr);
        }
        String result = sb.toString();
        //特殊情况 若干个零
        if (result.charAt(0) == '0') {
            result = "0";
        }
        return result;
    }

}
