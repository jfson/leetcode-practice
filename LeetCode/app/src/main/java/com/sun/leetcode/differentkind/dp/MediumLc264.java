package com.sun.leetcode.differentkind.dp;

import java.util.ArrayList;

/**
 * Author: jfson sun
 * Create on:  2018/11/20
 * Description:
 */
public class MediumLc264 {
    /**
     Write a program to find the n-th ugly number.

     Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

     Example:

     Input: n = 10
     Output: 12
     Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
     Note:

     1 is typically treated as an ugly number.
     n does not exceed 1690.
     题意： 丑数-->只包含因子 2、3 和 5 的数称作丑数（被2，3，5整除）
     solution:
     step 1: 1 * 2、 1* 3、 1* 5  ---> 取 1* 2,next step ->  2*2
     step 2: 2 * 2、 1* 3、 1* 5  ---> 取 1* 3，next step -> 2*3
     step 3: 2 * 2、 2* 3、 1* 5  ---> 取 2* 2,next step ->  3*2
     step 4: 3 * 2、 2* 3、 1* 5  ---> 取 1* 5，next step -> 2* 5
     step 5: 3 * 2、 2* 3、 2* 5  ---> 取 2* 3，next step -> 3* 3  、4*2

     */

    public int nthUglyNumber(int n) {
        int a =0,b=0,c=0;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < n){
            int cur1 = res.get(a)* 2;
            int cur2 = res.get(b)* 3;
            int cur3 = res.get(c)* 5;

            int min = Math.min(cur1,Math.min(cur2,cur3));
            res.add(min);
            if (cur1 == min) a++;
            if (cur2 == min) b++;
            if (cur3 == min) c++;
        }

        return res.get(res.size()-1);
    }
}
