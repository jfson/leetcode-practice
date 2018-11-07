package com.sun.leetcode.differentkind.array;

/**
 * Author: jfson sun
 * Create on:  2018/10/29
 * Question: 832. Flipping an Image
 * Description:
 * Train of thought:
 */
public class EasyLc832 {

    // solution 1
    // 注意 交换 temp
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0) return A;

        for (int i = 0; i < A.length; i++) {
            int[] res = A[i];
            for (int j = 0; j < res.length / 2; j++) {
                int temp = res[j];
                res[j] = res[res.length - 1 - j];
                res[res.length - 1 - j] = temp;
            }

            for (int j = 0; j < res.length; j++) {
                res[j] = res[j] == 1 ? 0 : 1;
            }
        }


        return A;
    }

    // solution 2
    // follow up 找规律
    // 1 转换成0 就是 ^=1
    //

    public int[][] flipAndInvertImage2(int[][] A) {
        if (A == null || A.length == 0) return A;
        int n = A.length;

        for (int[] ints : A) {
            for (int i = 0; i * 2 < n; i++) {
                if (ints[i] == ints[n - i - 1]) { //b ^= 1, a = b
                    ints[i] = ints[n - i - 1] ^= 1;
                }
            }
        }

        return A;
    }
}
