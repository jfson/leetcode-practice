package com.sun.leetcode.jianzhioffer;

/**
 * Author: jfson sun
 * Create on:  2020/3/21
 * Question:
 * Description:
 * Train of thought:
 */
public class Skip05 {
    /**
     * 跳台阶
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     1 : 1
     2 : 1,2--> 2
     3 : 1,2 ; 2,1; 1,1,1-->3 ; 从1级过来 + 从2级过来
     */


    /**
     * 优化
     * @param target
     * @return
     */
    public int dp(int target){
        int[] res = new int[target+1];

        for (int i = 1; i <= target ; i++) {
            if (target == 1){
                res[1] = 1;
                continue;
            }

            if (target == 2){
                res[2] = 2;
                continue;
            }

            res[i] = res[i-1] + res[i-2];

        }


        return res[target];
    }


    public int JumpFloor(int target) {
        if (target <= 0){
            return 0;
        }

        if (target == 1){
            return 1;
        }

        if (target == 2){
            return 2;
        }

        return JumpFloor(target-1)+JumpFloor(target-2);
    }
}
