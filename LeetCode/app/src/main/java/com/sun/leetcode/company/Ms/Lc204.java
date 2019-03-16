package com.sun.leetcode.company.Ms;

/**
 * Author: jfson sun
 * Create on:  2019/3/16
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc204 {
    /**
     204. Count Primes
     Easy
     Count the number of prime numbers less than a non-negative number, n.

     Example:

     Input: 10
     Output: 4
     Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
     题意：找素数
     solution：
     1不是质数也不是素数

     2 是质数。2的倍数都不是素数：2*2；2*3；2*4;2*5...
     3 是质数。3的倍数都不是素数：3*2；3*3；3*4；3*5...
     。。。

     */

    public int countPrimes(int n) {
        boolean[] noPrimes = new boolean[n];

        int count = 0;
        // 1 不是素数
        for(int i = 2;i<n;i++){
            if(noPrimes[i] == false){
                count++;
                for(int j = 2;j * i < n;j++){
                    noPrimes[j * i ] = true;
                }
            }
        }
        return count;
    }
}
