package com.sun.leetcode.jianzhioffer;

/**
 * Author: jfson sun
 * Create on:  2020/3/7
 * Question:
 * Description:
 * Train of thought:
 */
public class FindArray01 {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），
     * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * <p>
     * <p>  10
      1  2  3  4
      5  6  7  8
      9  10 11 12
     * <p>
     * <p>
     * 数组： [12,3,4]   length   int[] res = new int[size]
     * 二维数组： int[][] res = new int[3][4]
     * 1 --> res[0][0]
     * 4 --> res[0][3]
     * 9 --> res[2][0]
     * 11 --> res[2][2]
     */


    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        //第一种：暴力解法
//        for (int i = 0; i < array.length; i++) {
//               for (int j = 0;j < array[i].length;j++){
//                   if (array[i][j] == target){
//                       return true;
//                   }
//               }
//        }

        //第二种：利用递增属性
        int i = 0;//行
        int j = array[i].length-1;//列   index

        while (i < array.length && j >= 0){
            if (array[i][j] == target){
                return true;
            }else if (target > array[i][j]){
                j = array[i].length-1;//重置到最后一个元素
                i++;// i = i+1;  i += 1;
            }else {//target < array[i][j]
                j--;//j -= 1; j = j -1;
            }
        }

        return false;
    }


}
