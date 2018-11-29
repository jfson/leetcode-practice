package com.sun.leetcode.differentkind.divide;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/11/29
 * Question:
 * Description:
 * Train of thought:
 */
public class LcMedium241 {
    /**
     * 241. Different Ways to Add Parentheses
     * DescriptionHintsSubmissionsDiscussSolution
     * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
     * <p>
     * Example 1:
     * <p>
     * Input: "2-1-1"   ways(2-1-1)
     * Output: [0, 2]
     * Explanation:
     * ((2-1)-1) = 0    ways(2-1) - ways(1)
     * (2-(1-1)) = 2    ways(2) - ways(1-1)
     * Example 2:
     * <p>
     * Input: "2*3-4*5"
     * Output: [-34, -14, -10, -10, 10]
     * Explanation:
     * (2*(3-(4*5))) = -34
     * ((2*3)-(4*5)) = -14
     * ((2*(3-4))*5) = -10
     * (2*((3-4)*5)) = -10
     * (((2*3)-4)*5) = 10
     * <p>
     * 题意： 根据计算顺序不同，获得不同的解
     * solution ： 硬做
     * ways("x) = { x }
     * {a,b,c} x {1,2} = {a+1,b+1,c+1,a+2,b+2,c+2}
     * w(n) = w(1) * w(n-1) + w(2) * 2(n-2) + ... + w(n-1)* w(1)
     * <p>
     * "2-1-1"
     * a = "2"  b = "1-1"
     */

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '-' || c == '+' || c == '*') {
                String a = input.substring(0, i);
                String b = input.substring(i + 1);
                List<Integer> al = diffWaysToCompute(a);
                List<Integer> bl = diffWaysToCompute(b);

                for (Integer x : al) {
                    for (Integer y : bl) {
                        if (c == '-') {
                            res.add(x - y);
                        } else if (c == '+') {
                            res.add(x + y);
                        } else if (c == '*') { //*
                            res.add(x * y);
                        }
                    }
                }
            }
        }

        if (res.size() == 0) res.add(Integer.valueOf(input));

        return res;
    }
}
