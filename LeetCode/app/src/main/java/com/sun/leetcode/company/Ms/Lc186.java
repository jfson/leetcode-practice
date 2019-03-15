package com.sun.leetcode.company.Ms;

/**
 * Author: jfson sun
 * Create on:  2019/3/15
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc186 {
    /**
     186. Reverse Words in a String II
     Medium

     245

     80

     Favorite

     Share
     Given an input string , reverse the string word by word.

     Example:

     Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
     Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
     Note:

     A word is defined as a sequence of non-space characters.
     The input string does not contain leading or trailing spaces.
     The words are always separated by a single space.
    题意：翻转字符串
     solution:这道题让我们翻转一个字符串中的单词，跟之前那题 Reverse Words in a String 没有区别，
     由于之前那道题我们就是用in-place的方法做的，而这道题反而更简化了题目，因为不考虑首尾空格了和单词之间的多空格了，
     方法还是很简单:
     先把每个单词翻转一遍，再把整个字符串翻转一遍，
     或者也可以调换个顺序，先翻转整个字符串，再翻转每个单词
     */
    public void reverseWords(char[] str) {
            if(str == null || str.length < 2) return;

            int len = str.length;
            int currStart = 0;
            for(int i = 0;i <= len;i++){
                if(i == len || str[i] == ' '){
                    reverseIndex(str,currStart,i-1);
                    currStart = i +1;
                }
            }

            reverseIndex(str,0,len-1);
        }

        private void reverseIndex(char[] str,int start,int end){
            while(start < end){
                char swap = str[start];
                str[start] = str[end];
                str[end] = swap;
                start++;
                end--;
            }
        }
}
