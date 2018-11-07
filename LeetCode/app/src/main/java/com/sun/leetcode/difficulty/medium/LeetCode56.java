package com.sun.leetcode.difficulty.medium;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.sun.leetcode.model.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/10/11
 * Question:56. Merge Intervals
 * Description:Given a collection of intervals, merge all overlapping intervals.
 * Train of thought:
 */
public class LeetCode56 {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return intervals;
        List<Interval> res = new ArrayList<>();

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });


        for (int i = 0; i < intervals.size(); i++) {
            if (res.size() == 0 || intervals.get(i).start > res.get(res.size() - 1).end) {
                res.add(intervals.get(i));
            } else {
                Interval lastOne = res.get(res.size() - 1);
                Interval current = intervals.get(i);
                lastOne.start = Math.min(lastOne.start, current.start);
                lastOne.end = Math.max(lastOne.end, current.end);
            }
        }

        return res;
    }


}
