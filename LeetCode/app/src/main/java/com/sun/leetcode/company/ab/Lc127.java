package com.sun.leetcode.company.ab;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author: jfson sun
 * Create on:  2018/12/12
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc127 {
    /**
     * 127. Word Ladder
     * DescriptionHintsSubmissionsDiscussSolution
     * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
     * <p>
     * Only one letter can be changed at a time.
     * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     * Note:
     * <p>
     * Return 0 if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     * You may assume no duplicates in the word list.
     * You may assume beginWord and endWord are non-empty and are not the same.
     * Example 1:
     * <p>
     * Input:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * <p>
     * Output: 5
     * <p>
     * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     * Example 2:
     * <p>
     * Input:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     * <p>
     * Output: 0
     * <p>
     * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
     * <p>
     * 题意：单词阶梯。最短路径从第一个单词转到最后一个单词。每次转变一个字符。转变后需要再字典里
     * solution:最短路径 BFS.改进：双向BFS
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> dict = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int step = 1;
        Set<String> visited = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        if (endSet.contains(target)) {
                            return step + 1;
                        }
                        if (!visited.contains(target) && dict.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            step++;
        }
        return 0;
    }
}
