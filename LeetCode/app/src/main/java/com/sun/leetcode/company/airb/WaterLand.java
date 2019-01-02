package com.sun.leetcode.company.airb;

/**
 * Author: jfson sun
 * Create on:  2019/1/1
 * Question:
 * Description:
 * Train of thought:
 */
public class WaterLand {
    /*

    Water Land / Water Drop / Pour Water
    AirBnB Interview Question
	这个题目比较open－ended。关键是和interviewer讲清楚你的assumption。
	我的assumption：
	（0）handle the water drop by drop。 there are infinitely high walls on the left and right
	（1）水先向左走，走到不能走为止。call it leftMost
	（2）如果leftmost的水比开始点低，leftMost水+1，done
	（3）如果leftmost的水不比开始点低，水向右走，走到不能走为止。call it rightMost
	（4）如果rightmost的水比开始点低，rightMost水+1，done
	（5）如果rightmost的水不比开始点低，leftMost水+1，done

	print();行 * 列
	行：最高的Height
	列：数组的宽度

     */
    public static void main(String[] args) {
        int[] waterLand = new int[]{5,4,2,1,3,2,2,1,0,1,4,3};
        int[] wats = new int[waterLand.length];
        print(waterLand,wats);
        System.out.println();
        System.out.print(" ------- ");
        System.out.println();
        pourWater(waterLand, 5, 8);
    }

    //
    public static void pourWater(int[] heights, int location, int water) {
        int[] waters = new int[heights.length];

        int k = water;
        while(k > 0){
            //left
            int left = location -1;
            while(left >= 0){
                if (heights[left] + waters[left]> heights[left + 1]+ waters[left+1]) {
                    break;
                }
                left--;
            }

            if (heights[left + 1]+ waters[left+1] < heights[location]+ waters[location]) {
                waters[left+1]++;
                k--;
                continue;
            }

            // right
            int right = location + 1;
            while(right < heights.length){
                if (heights[right] + waters[right] > heights[right - 1]+ waters[right-1]) {
                    break;
                }
                right++;
            }

            if (heights[right - 1]+ waters[right-1] < heights[location] + waters[location]) {
                waters[right-1]++;
                k--;
                continue;
            }

            //mid
            waters[location]++;
            k--;
        }

        print(heights,waters);
        System.out.println();
        System.out.print(" ------- ");
        System.out.println();
        print2(heights,waters);
    }
    private static void print2(int[] heights, int[] waters) {
        int n = heights.length;

        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            maxHeight = Math.max(maxHeight, heights[i] + waters[i]);
        }

        for (int height = maxHeight; height >= 0; height--) {
            for (int i = 0; i < n; i++) {
                if (height <= heights[i]) {
                    System.out.print("+");
                } else if (height > heights[i] && height <= heights[i] + waters[i]) {
                    System.out.print("W");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print(int[] heights,int[] waters){
        int n = heights.length;
        int maxHeight = 0;
        for (int i = 0;i<n ;i++ ) {
            maxHeight = Math.max(maxHeight,heights[i] + waters[i]);
        }

        for(int hei = maxHeight;hei >= 0 ;hei--){ // 行
            for (int i = 0;i<n ;i++ ) { // 列
                if (hei <= heights[i]) {
                    System.out.print("+");
                }else if (hei > heights[i] && hei <= heights[i] + waters[i]) {
                    System.out.print("W");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
