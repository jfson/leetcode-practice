package com.sun.leetcode.jianzhioffer;

/**
 * Author: jfson sun
 * Create on:  2020/3/21
 * Question:
 * Description:
 * Train of thought:

 */
public class Dp04 {
    /**
     大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     n<=39

     1、1、2、3、5、8,12
     F(1)=1，F(2)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 3，n ∈ N*）

     10000
     */


    /**
     * Dynamic Programming
     解法：空间换时间
     核心思想：计算出每一项
     */
    public int dp(int n){
        //[1,1,2,3,5,8。。。]
        int[] array = new int[n+1];//开辟数组空间
        for (int i = 1; i <= n ; i++) {
            if (i == 1 || i == 2){
                array[i] = 1;
            }else {
                array[i] = array[i-1] + array[i-2];
            }
        }

        return array[n];
    }


    /**
     * 递归来解决
     * 递归：自己调用自己
     * 重要point: 找出口
     * 造成重复。时间复杂度：耗时比较长
     */
    public int fibonacci(int n) {
        //安全校验
        if (n <= 0){
            return 0;
        }

        if (n == 1 || n == 2){
            return 1;
        }

        // 第 3项
        // return fibonacci(1) + fibonacci(2)
        //          1         +   1   = 2

        //第4项
        //return fibonacci(2) + fibonacci(3)
        //   1   + fibonacci(2) + fibonacci(1)
        //   1   + 1 + 1 = 3


        // 10000项
        // fibonacci(10000-1) + fibonacci(10000-2)
        // fibonacci(10000-1) --> fibonacci(9999) -> fibonacci(9999-1) + fibonacci(9999 -2 ) -->fibonacci(9998) + fibonacci(9997)
        // fibonacci(10000-2) --> fibonacci(9998) -> fibonacci(9997) + fibonacci(9996 )

        return fibonacci(n-1) + fibonacci(n-2);
    }
}
