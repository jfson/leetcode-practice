package com.sun.leetcode.company.airbnb;

import com.sun.leetcode.model.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/12/25
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc759 {
    /**
     759. Employee Free Time
     DescriptionHintsSubmissionsDiscussSolution
     We are given a list schedule of employees, which represents the working time for each employee.

     Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

     Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

     Example 1:
     Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
     Output: [[3,4]]
     Explanation:
     There are a total of three employees, and all common
     free time intervals would be [-inf, 1], [3, 4], [10, inf].
     We discard any intervals that contain inf as they aren't finite.
     Example 2:
     Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
     Output: [[5,6],[7,9]]
     (Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined.)

     Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.

     Note:

     schedule and schedule[i] are lists with lengths in range [1, 50].
     0 <= schedule[i].start < schedule[i].end <= 10^8.

     题意：找空闲时间。
     solution：扫面线，进行虚拟merge,虚拟合并。计算出max_end、start、end、free
     Key:Geometry/Sweep Line
     */

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        List<Interval> timeLine = new ArrayList<>();

        for (List<Interval> intervals : schedule) {
            timeLine.addAll(intervals);
        }

        Collections.sort(timeLine, new Comparator<Interval>() {
            @Override
            public int compare(Interval t1, Interval t2) {
                return t1.start - t2.start;
            }
        });

        Interval temp = timeLine.get(0);
        for (Interval interval : timeLine) {
            if (temp.end < interval.start){
                result.add(new Interval(temp.end,interval.start));
                temp = interval;
            }else {
                temp = temp.end <interval.end ? interval:temp;
            }
        }


        return result;
    }
}
