package com.sun.leetcode.company.Ms;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.HashMap;
import java.util.Objects;

/**
 * Author: jfson sun
 * Create on:  2019/3/16
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc290 {
    /**
     290. Word Pattern
     Easy

     Given a pattern and a string str, find if str follows the same pattern.

     Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

     Example 1:

     Input: pattern = "abba", str = "dog cat cat dog"
     Output: true
     Example 2:

     Input:pattern = "abba", str = "dog cat cat fish"
     Output: false
     Example 3:

     Input: pattern = "aaaa", str = "dog cat cat dog"
     Output: false
     Example 4:

     Input: pattern = "abba", str = "dog dog dog dog"
     Output: false
     Notes:
     You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

     题意：判断两个string规律是否是顺序对应的。
     solution:
     map.put() 是返回其上一存储的值，这个为索引。利用该特性去判断
     譬如Input: pattern = "abba", str = "dog cat cat dog"
     map.put:
        put(a,0)  -> 0; put(dog,0) -> 0；都为0
        put(b,1)  -> 0; put(cat,1) -> 0；都为 0
        put(b,2)  -> 1; put(cat,2) -> 1；都为 1
        put(a,3)  -> 0; put(cat,3) -> 0；都为 0
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public boolean wordPattern(String pattern, String str) {
        if(pattern.isEmpty() || str.isEmpty()) return false;

        String[] words = str.split(" ");
        if(words.length != pattern.length()) return false;

        HashMap<Object,Integer> map = new HashMap<>();
        for(int i = 0;i<words.length;i++){
//            if(map.put(pattern.charAt(i),i)!=(map.put(words[i],i))){
              // 用!= 有问题
            if (!Objects.equals(map.put(pattern.charAt(i), i),
                    map.put(words[i], i))){
                return false;
            }
        }
        return true;

    }
}
