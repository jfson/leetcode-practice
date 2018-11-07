package com.sun.leetcode.differentkind.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/10/29
 * Question: Sort Array By Parity
 * Description:  even number  偶数排前面
 * Train of thought:
 */
public class EasyLc905 {


    //solution 1
    public int[] sortArrayByParity(int[] A) {

        if (A == null || A.length == 0) {
            return new int[0];
        }

        int[] ret = new int[A.length];
        int start = 0;
        int end = A.length-1;

        for(int i = 0;i<A.length;i++){
            if (A[i]%2 == 0){
                ret[start++] = A[i];
            }else {
                ret[end--] = A[i];
            }
        }

        return ret;
    }

    // [3,1,2,4]
    // 1. [3 ,1,2,4]
    // 2. [3 ,1,2,4]
    // 3. [2 ,1,3,4]
    // 4. [2 ,4,3,1]

    // solution 2   空间复杂度O1
    public int[] sortArrayByParity2(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }

        for(int i = 0,j=0;j<A.length;j++){

            if (A[j]%2==0){
                int temp = A[i];
                A[i++] = A[j];
                A[j] = temp;
            }
        }

        return A;
    }

}
