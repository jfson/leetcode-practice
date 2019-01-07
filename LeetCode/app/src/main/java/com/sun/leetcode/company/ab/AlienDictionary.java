package com.sun.leetcode.company.ab;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Author: jfson sun
 * Create on:  2019/1/7
 * Question:
 * Description:
 * Train of thought:
 */
public class AlienDictionary {
    /**
     外星人字典
     LeetCode269

     外星人有自己的语言。虽然他们使用的字母表和英文相同，但是字母的顺序不同。
     现在你获得了一部外星人的字典，字典中单词的顺序按照外星人的字母表顺序排列。
     你通过字典分析出外星人的字母顺序吗？

     Example：

     [  "wrt",  "wrf",  "er",  "ett",  "rftt"]正确顺序是”wertf”。

     w>r>t
     w>r>f
     e>r
     e>t>t
     r>f>tt

     注释：
     1.可以假设所有的字母都是小写的。
     2.可以假设，如果a是b的前缀，那么在给定的字典中，a必须出现在b之前。
     3. 如果订单无效，则返回空字符串。
     4.可能有多个有效的字母顺序，返回任意一个都可以。

     Example 2:
     Input:["z","x"]
     Output: "zx"

     Example 3:
     Input:["z","x","z"]
     Output: ""

     Explanation: The order is invalid, so return "".
     题意：根据字典分析出外星人的字母顺序，拼出一个词(拓扑排序)
     solution: BFS或者DFS..一般用BFS
     */


    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";

        // 有重复的字符，所以用set
        Map<Character,Set<Character>> map = new HashMap<>();

        Map<Character,Integer> degree = new HashMap<>();
        String result = "";

        // 所有元素先存起来
        for (String str:words){
            for (char cha :str.toCharArray()){
                degree.put(cha,0);
            }
        }
        /*
        step:1
        [  "wrt",  "wrf",  "er",  "ett",  "rftt"]
         degree map:
         w:0
         r:0
         f:0
         e:0
         t:0
        */

        for(int i = 0;i < words.length -1;i++){
            String curr = words[i];
            String next = words[i+1];
            int length = Math.min(curr.length(),next.length());

            for (int j = 0; j < length; j++){
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2){
                    Set<Character> set = new HashSet<>();
                    if (map.containsKey(c1)){
                        set = map.get(c1);
                    }

                    if (!set.contains(c2)){
                        set.add(c2);
                        map.put(c1,set);//覆盖
                        degree.put(c2,degree.get(c2)+1);
                    }
                    break;
                }
            }
        }

         /*
        step:2
        [  "wrt",  "wrf",  "er",  "ett",  "rftt"]

         map:t:tf,w:we,r:rtf,e:er
         degree map:
         w:2
         r:0
         f:1
         e:1
         t:0
        */

        Queue<Character> queue = new LinkedList<>();
        for(char c:degree.keySet()){
            if (degree.get(c) == 0){
                queue.add(c);
            }
        }


        while (!queue.isEmpty()){
            char c = queue.remove();
            result += c;

            if (map.containsKey(c)){
                for (char c2:map.get(c)){
                    degree.put(c2,degree.get(c2)-1);
                    if (degree.get(c2) == 0){
                        queue.add(c2);
                    }
                }
            }
        }

        if (result.length() != degree.size()) return "";

        return result;
    }

}
