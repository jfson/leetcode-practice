package com.sun.leetcode.company.bytedance;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2020/2/29
 * Question:    LeetCode54
 * Description: 回字环形打印二维数组,二维数组长度一致
 * Train of thought:
 */
public class PrintArray {
    /**
        1   2     3     4
        12  13    14    5
        11   16   15    6
        10    9   8     7

     回字环形打印二维数组,二维数组长度一致
     */
    public static List<Integer> printArray(int[][] matrix, Context context){
        List<Integer> ret = new ArrayList<>();

        if(matrix == null || matrix.length == 0){
            return ret;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int x = 0,y = 0;

        int k = 0;
        while (k < m * n){
            //极端情况
            if(m == 1){
                for (int i = 0; i < n; i++) {
                    ret.add(matrix[m][i]);
                    k++;
                }
                break;
            }else if (n == 1){
                for (int i = 0; i < m; i++) {
                    ret.add(matrix[i][n]);
                    k++;
                }
                break;
            }

            for (int i = 0; i < n - 1; i++) {
                ret.add(matrix[x][y++]);
                k++;
            }

            for (int i = 0; i < m - 1; i++) {
                ret.add(matrix[x++][y]);
                k++;
            }

            for (int i = 0; i < n - 1; i++) {
                ret.add(matrix[x][y--]);
                k++;
            }

            for (int i = 0; i < m - 1; i++) {
                ret.add(matrix[x--][y]);
            }

            x++;
            y++;
            m -=2;
            n -=2;
        }


        String ss = "t";
        for (Integer re : ret) {
            ss += re + ",";
            Toast.makeText(context,ss,Toast.LENGTH_LONG).show();
        }
        return ret;
    }
}
