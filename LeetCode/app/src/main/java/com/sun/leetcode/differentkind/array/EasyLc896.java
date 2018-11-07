package com.sun.leetcode.differentkind.array;

/**
 * Author: jfson sun
 * Create on:  2018/10/30
 * Question:    896. Monotonic Array
 * Description:
 * Train of thought:
 */
public class EasyLc896 {
    // 单调函数
    // solution 1
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0) return false;

        int start = A[0];
        for (int i = 1; i < A.length; i++) {
            if (start >= A[i]) {
                start = A[i];
                if (i == A.length - 1) return true;
            }else {
                break;
            }
        }

        start = A[0];
        for (int i = 0; i < A.length; i++) {
            if (start <= A[i]) {
                start = A[i];
                if (i == A.length - 1) return true;
            }else {
                break;
            }
        }

        return false;
    }

    // solution 2
    public boolean isMonotonic1(int[] A) {
        boolean inc = true,dec = true;

        for (int i = 1; i < A.length; i++) {
            inc = inc & A[i-1] <= A[i];
            dec = dec & A[i-1] >= A[i];
        }

        // 满足一个递增/递减即可
        return inc||dec;
    }
}
