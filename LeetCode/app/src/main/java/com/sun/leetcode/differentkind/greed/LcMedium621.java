package com.sun.leetcode.differentkind.greed;

import java.util.Arrays;

/**
 * Author: jfson sun
 * Create on:  2018/11/26
 * Question:
 * Description:
 * Train of thought:
 */
public class LcMedium621 {
    /**
     * Task Scheduler
     Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different
     tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
     However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals
     that CPU are doing different tasks or just be idle.

     You need to return the least number of intervals the CPU will take to finish all the given tasks.

     Example:
     Input: tasks = ["A","A","A","B","B","B"], n = 2
     Output: 8
     Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

     Example:
     input:["A","A","A","A","A","B","C","D","E"], n = 2
     Explanation: A,B,C,D,E,A,idle,idle,A,idle,idle,A,idle,idle,A -> 15
     Explanation: A,B,C，A,D,E,A,idle,idle,A,idle,idle,A ->12


     Note:

     The number of tasks is in the range [1, 10000].
     The integer n is in the range [0, 100].

     题意：任务分配
     group: k-1
     每个group: n+1
     ans = (k-1)(n+1) + 1
     最终需要最少的任务时间：（最多任务数-1）*（n + 1） + （相同最多任务的任务个数）。

     solution: 先排序，找到num , max的数。
     */

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            map[tasks[i] - 'A']++;
        }

        Arrays.sort(map);

        int i = 25;// index 25 任务最多
        while (i>=0 && map[i] == map[25]) i--; // 找到相同的任务个数

        return Math.max(tasks.length,(map[25] -1)*(n+1) +(25-i));
    }
}
