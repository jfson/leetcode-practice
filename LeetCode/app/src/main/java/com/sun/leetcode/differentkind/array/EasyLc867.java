package com.sun.leetcode.differentkind.array;

/**
 * Author: jfson sun
 * Create on:  2018/10/29
 * Question: 867. Transpose Matrix
 * Description:
 * Train of thought:
 */
public class EasyLc867 {
    /**
     input
     [1,2,3],       (0,1) -- (1,0)
     [4,5,6],
     [7,8,9]

     output
     [1,4,7],
     [2,5,8],
     [3,6,9]

     input
     [1,2,3],
     [4,5,6]

     output
     [1,4],         (0,1)  (1,0)
     [2,5],         (1,0)  (0,1)     |   (1,1) (1,1)
     [3,6]          (2,1)   (1,2)

          */

    // 找规律。。没难度吧
    public int[][] transpose(int[][] A) {
        if (A==null || A.length == 0) return A;

        int line = A.length;
        int col = A[0].length;
        int[][] ret = new int[col][line];

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < col; j++) {
                // 注意 ret 的行 ，列颠倒过来了
                ret[j][i] = A[i][j];
            }
        }

        return ret;
    }
}
