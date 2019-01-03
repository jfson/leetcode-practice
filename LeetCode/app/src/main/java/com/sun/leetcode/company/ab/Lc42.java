package com.sun.leetcode.company.ab;

/**
 * Author: jfson sun
 * Create on:  2018/12/31
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc42 {
    /**
     42. Trapping Rain Water
     DescriptionHintsSubmissionsDiscussSolution
     Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


     The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

     Example:

     Input: [0,1,0,2,1,0,1,3,2,1,2,1]
     Output: 6

     题意： 能装多少水
     solution ： 取两点之间较小的高度。取两个点。左边最大跟右边最大。当前盛水的最大值跟最小高度有关。最小高度减去当前高度。但是需要判定是左边还是右边高
     */

    public int trap(int[] height) {
        int res= 0;
        int left = 0,right = height.length-1;

        int maxLeft = 0,maxRight = 0;

        while (left < right){
            if (height[left] < height[right]){
                maxLeft = Math.max(maxLeft,height[left]);
                res += maxLeft - height[left];
                left++;
            }else {
                maxRight = Math.max(maxRight,height[right]);
                res += maxRight - height[right];
                right--;
            }
        }

        return res;
    }

}
