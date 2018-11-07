package com.sun.leetcode.differentkind.array;

/**
 * Author: jfson sun
 * Create on:  2018/11/1
 * Question:    238. Product of Array Except Self
 * Description:
 * Train of thought:
 */
public class MediumLc238 {

    /**
     Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

     Example:

     Input:  [1,2,3,4]
     Output: [24,12,8,6]
     Note: Please solve it without division and in O(n).

     Follow up:
     Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)


     题意：输入1--》 2* 3* 4 = 24 。。。 输入i,获取其他元素的乘积
     题目比较好理解，但是有几个关键点这里需要明确一下：

     不能用除法。意思就是：你不能上来先把所有数乘积算出来，然后再逐个除以每个元素，这种思路是无聊、没技术含量而且不被允许的。
     时间复杂度必须控制到O(n)。意思是：如果用O(n^2)的方法，那外层一个for循环，内层左右遍历就解决了，也是很无聊的解法。
     空间复杂度最好是常数，但是重新分配的返回数组不算在内。

     思路：
        1，2，3，4
        第一次for,current 元素前面的所有乘积
        1,1,2,6
        第二次for,current 元素后面的所有乘积

        两次的乘积就是结果

        1*2*3*4  ,3*4*1 ,4*2,6*1

     */

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        int[] ret = new int[nums.length];
        ret[0] =1;

        // 索引前的所有乘积求出来 为 i 之前的乘积
        for (int i = 1; i < nums.length; i++) {
            ret[i] = ret[i-1] * nums[i-1];
        }


        int right = 1;
        for (int i = nums.length-1; i >=0; i--) {
            ret[i] *= right;
            right *= nums[i];
        }

        return ret;
    }
}
