package com.sun.leetcode.differentkind.greed;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/11/26
 * Question:
 * Description:
 * Train of thought:
 */
public class LcMedium406 {
    /**
     406. Queue Reconstruction by Height

     Suppose you have a random list of people standing in a queue. Each person is described by a pair
     of integers (h, k), where h is the height of the person and k is the number of people in front of this
     person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

     Note:
     The number of people is less than 1,100.

     Example
     Input:
     [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

     Output:
     [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

     题意：二维数组。（h,k） h是身高，k是前方比h高的人数，重建队列
     solution: 先排序，在根据k依次进行插入
     */

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return b[0]-a[0];
                }else {
                    return a[1]-b[1];
                }
            }
        });

        List<int[]> resource = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            int[] peo = people[i];
            resource.add(peo[1],peo);
        }

        return resource.toArray(new int[people.length][]);
    }
}
