package com.sun.leetcode.company.ab;

import com.sun.leetcode.model.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author: jfson sun
 * Create on:  2019/1/12
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc252 {
    /**
     252. Meeting Rooms
     Easy

     Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
     determine if a person could attend all meetings.

     Example 1:

     Input: [[0,30],[5,10],[15,20]]
     Output: false
     Example 2:

     Input: [[7,10],[2,4]]
     Output: true

     题意： 判断是否能参加所有的会议
     */
    public boolean canAttendMeetings(Interval[] intervals) {
        Comparator<Interval> com = new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval t1) {
                if (interval.start != t1.start ){
                    return interval.start - t1.start;
                }
                return interval.end - t1.end;
            }
        };

        Arrays.sort(intervals,com);

        for (int i = 0;i < intervals.length-1;i++ ){
            if (intervals[i].end > intervals[i+1].start) return false;
        }


        return true;
    }
}
