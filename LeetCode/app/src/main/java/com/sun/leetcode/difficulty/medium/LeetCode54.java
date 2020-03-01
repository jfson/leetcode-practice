package com.sun.leetcode.difficulty.medium;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/10/10
 * Question:    54. Spiral Matrix
 * Description: Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * Train of thought:  转圈取值
 */
public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix, Context context) {
        List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0) return res;

        int m = matrix.length;
        int n = matrix[0].length;

        int x = 0, y = 0;

        while (m > 0 && n > 0) {
            // if one row


            if (m == 1) {
                for (int i = 0; i <n; i++) {
                    res.add(matrix[x][y++]);
                }
                break;
            }else if (n == 1) {// one column
                for (int i = 0; i < m; i++) {
                    res.add(matrix[x++][y]);
                }
                break;
            }

            // top - move
            for (int i = 0; i < n - 1; i++) {
                res.add(matrix[x][y++]);
            }

            // right - move
            for (int i = 0; i < m - 1; i++) {
                res.add(matrix[x++][y]);
            }

            // bottom
            for (int i = 0; i < n - 1; i++) {
                res.add(matrix[x][y--]);
            }

            // left
            for (int i = 0; i < m - 1; i++) {
                res.add(matrix[x--][y]);
            }

            x++;
            y++;
            m = m - 2;
            n = n - 2;
        }

        String ss = "";
        for (Integer re : res) {
            ss += re + ",";
            Toast.makeText(context,ss,Toast.LENGTH_LONG).show();
        }
        return res;
    }



}
