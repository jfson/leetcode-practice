package com.sun.leetcode.company.Ms;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2019/3/16
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc692 {
    /**
     692. Top K Frequent Words
     Medium

     Given a non-empty list of words, return the k most frequent elements.

     Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

     Example 1:
     Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     Output: ["i", "love"]
     Explanation: "i" and "love" are the two most frequent words.
     Note that "i" comes before "love" due to a lower alphabetical order.
     Example 2:
     Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
     Output: ["the", "is", "sunny", "day"]
     Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
     with the number of occurrence being 4, 3, 2 and 1 respectively.
     Note:
     You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     Input words contain only lowercase letters.
     Follow up:
     Try to solve it in O(n log k) time and O(n) extra space.
     题意：找K个最多项
     solution，map后排序，没啥难度
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String currStr = words[i];
            map.put(currStr, map.getOrDefault(currStr,0) + 1);
        }

        WordModel[] list = new WordModel[map.keySet().size()];
        int i = 0;
        for (String key : map.keySet()) {
            list[i++] = new WordModel(key, map.get(key));
        }

        Arrays.sort(list, new Comparator<WordModel>() {
            @Override
            public int compare(WordModel wordModel, WordModel t1) {
                if(t1.num == wordModel.num){
                    return  wordModel.str.compareTo(t1.str);
                }
                return t1.num - wordModel.num;
            }
        });
        List<String> ret = new ArrayList<>();
        for (int j = 0; j < k; j++) {
            ret.add(list[j].str);
        }

        return ret;
    }

    class WordModel{
        public String str;
        public int num = 0;

        public WordModel(String string, int strNum) {
            this.str = string;
            this.num = strNum;
        }
    }
}
