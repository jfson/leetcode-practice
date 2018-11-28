package com.sun.leetcode.differentkind.greed;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Author: jfson sun
 * Create on:  2018/11/27
 * Question:
 * Description:
 * Train of thought:
 */
public class LcMedium767 {
    /**
     767. Reorganize String

     Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

     If possible, output any possible result.  If not possible, return the empty string.

     Example 1:

     Input: S = "aab"
     Output: "aba"
     Example 2:

     Input: S = "aaab"
     Output: ""

     Note:
     S will consist of lowercase letters and have length in range [1, 500].


     题意：重新排列，使相邻的两个字符不相同。不满足则返回null
     solution: 先存起来，根据数量进行排序。然后用队列一次进行压string
     */

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) return null;

        Map<Character,Integer> map =new HashMap<>();
        // 存储
        for (int i = 0; i < S.length(); i++) {
            int count = map.getOrDefault(S.charAt(i),0)+1;
            if (count > (S.length()+1)/2) return ""; //超过一半就不满足
            map.put(S.charAt(i),count);
        }

        // 排序
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1]-a[1];// 逆序
            }
        });

        for (char c : map.keySet()) {
            pq.add(new int[]{c,map.get(c)});
        }

        //Build result
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            int[] first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length()-1)){ // add first
                sb.append((char) first[0]); // 踩坑，需要转char，否则是asik 编码值
                first[1]--;
                if (first[1]>0){
                    pq.add(first);
                }
            }else { // add second
                int[] second = pq.poll();
                sb.append((char)second[0]);
                second[1]--;
                if (second[1]>0){
                    pq.add(second);
                }
                pq.add(first);
            }
        }

        return sb.toString();
    }
}
