package com.sun.leetcode.differentkind.array;

/**
 * Author: jfson sun
 * Create on:  2018/11/1
 * Question:    495. Teemo Attacking
 * Description:
 * Train of thought:
 */
public class MediumLc495 {
    /**
     In LOL world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition. Now, given the Teemo's attacking
     ascending time series towards Ashe and the poisoning time duration per Teemo's attacking, you need to output the total time that Ashe is
     in poisoned condition.

     You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe be in poisoned condition immediately.



     题意： 计算总共的中毒时间：
     Input: [1,4], 2
     Output: 4
     1时中毒2秒，第4s时又中毒2s..return 2+2 = 4

     Input: [1,2], 2
     Output: 3
     1时中毒 2s
     2时中毒 1s，有1s重叠了
     return 1+2 = 3

     solution: 间隔时间大于中毒时间就取中毒时间和，小于则取间隔时间。注意：最后一下中毒时间别忘记了。
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration <= 0) return 0;

        int ret = 0;

        for (int i = 1; i < timeSeries.length; i++) {
            ret += (timeSeries[i] -timeSeries[i-1]) > duration ? duration:timeSeries[i] -timeSeries[i-1];
        }

        ret+=duration;//last one
        return ret;
    }

}
