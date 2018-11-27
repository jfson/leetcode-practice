package com.sun.leetcode.differentkind.greed;

import com.sun.leetcode.model.Interval;

import java.util.Arrays;

/**
 * Author: jfson sun
 * Create on:  2018/11/27
 * Question:
 * Description:
 * Train of thought:
 */
public class LcMedium253 {

    /**
     253. Meeting Rooms II
     Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
     find the minimum number of conference rooms required.

     Example 1:

     Input: [[0, 30],[5, 10],[15, 20]]
     Output: 2
     Example 2:

     Input: [[7,10],[2,4]]
     Output: 1

     题意：找出可以最少使用的会议室
     solution: start存一个数组，end存一个数组。进行排序后遍历。start[i] <end[索引]则room+1.否则end索引+1
     */

    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int curr = 0;
        int room = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (start[i] < end[curr]){
                room++;
            }else {
                curr++;
            }
        }

        return room;
    }
}
