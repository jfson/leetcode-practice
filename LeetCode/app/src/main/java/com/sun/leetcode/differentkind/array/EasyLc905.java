package com.sun.leetcode.differentkind.array;

/**
 * Author: jfson sun
 * Create on:  2018/10/29
 * Question: Sort Array By Parity
 * Description:  even number  偶数排前面
 * Train of thought:
 */
public class EasyLc905 {
    /**
     905. Sort Array By Parity
     Easy

     Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

     You may return any answer array that satisfies this condition.



     Example 1:

     Input: [3,1,2,4]
     Output: [2,4,3,1]
     The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


     Note:

     1 <= A.length <= 5000
     0 <= A[i] <= 5000
     题意：排序，偶数排在前面
     solution: 依次交换偶数到前置索引
     */

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
