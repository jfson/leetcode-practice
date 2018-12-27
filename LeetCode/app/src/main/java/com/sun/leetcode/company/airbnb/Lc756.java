package com.sun.leetcode.company.airbnb;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: jfson sun
 * Create on:  2018/12/27
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc756 {
    /**
     756. Pyramid Transition Matrix
     DescriptionHintsSubmissionsDiscussSolution
     We are stacking blocks to form a pyramid. Each block has a color which is a one letter string, like `'Z'`.

     For every block of color `C` we place not in the bottom row, we are placing it on top of a left block of color `A` and right block of color `B`. We are allowed to place the block there only if `(A, B, C)` is an allowed triple.

     We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples allowed. Each allowed triple is represented as a string of length 3.

     Return true if we can build the pyramid all the way to the top, otherwise false.

     Example 1:
     Input: bottom = "XYZ", allowed = ["XYD", "YZE", "DEA", "FFF"]
     Output: true
     Explanation:
     We can stack the pyramid like this:
     A
     / \
     D   E
     / \ / \
     X   Y   Z

     This works because ('X', 'Y', 'D'), ('Y', 'Z', 'E'), and ('D', 'E', 'A') are allowed triples.
     Example 2:
     Input: bottom = "XXYX", allowed = ["XXX", "XXY", "XYX", "XYY", "YXZ"]
     Output: false
     Explanation:
     We can't stack the pyramid to the top.
     Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D.
     Note:
     bottom will be a string with length in range [2, 8].
     allowed will have length in range [0, 200].
     Letters in all strings will be chosen from the set {'A', 'B', 'C', 'D', 'E', 'F', 'G'}.
     题意：给定金字塔 ('X', 'Y', 'D')底座X,Y..增加顶D..这时候为true
     solution: 拿出底部的元素后，向上递归即可。需要配合map.递归的出口在最后一层元素为1，
     用一个空白字符作为换行标识。如果已经走到最后一行，则charAt(1) == ' '，截取空格字符后面进行下一次递归
     */

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        //key 是 2个character的bottom
        Map<String,List<Character>> map = new HashMap<String, List<Character>>();
        for(String a:allowed){
            String bot = a.substring(0,2);
            if (!map.containsKey(bot)){
                map.put(bot,new ArrayList<Character>());
            }

            map.get(bot).add(a.charAt(2));
        }

        return canStack(map,bottom+' ');
    }

    @TargetApi(Build.VERSION_CODES.N)
    public boolean canStack(Map<String,List<Character>> map, String bottom){
        if (bottom.length() == 1) return true;//递归的出口在最后一层元素为1
        String b = bottom.substring(0,2);
        if (b.charAt(1) == ' ') return canStack(map,bottom.substring(2,bottom.length()) + ' ');

        for(Character ch:map.getOrDefault(b,new ArrayList<Character>())){
            if (canStack(map,bottom.substring(1,bottom.length())+ch)) return true;
        }

        return false;
    }
}
