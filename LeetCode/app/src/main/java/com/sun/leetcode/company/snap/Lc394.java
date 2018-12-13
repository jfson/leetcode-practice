package com.sun.leetcode.company.snap;

import java.util.Stack;

/**
 * Author: jfson sun
 * Create on:  2018/12/13
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc394 {
    /**
     394. Decode String
     DescriptionHintsSubmissionsDiscussSolution
     Given an encoded string, return it's decoded string.

     The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

     You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

     Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

     Examples:

     s = "3[a]2[bc]", return "aaabcbc".
     s = "3[a2[c]]", return "accaccacc".
     s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
     题意： 解码
     solution:两个stack记录，分别记录num和上次字符串。
     */

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int index = 0;
        String res = "";
        while (index < s.length()) {
            // num
            if (Character.isDigit(s.charAt(index))) {
                int currNum = 0;
                while (Character.isDigit(s.charAt(index))) {
                    currNum = 10 * currNum + (s.charAt(index) - '0');
                    index++;
                }
                numStack.push(currNum);
            }
            //'['
            if (s.charAt(index) == '[') {
                strStack.push(res);
                res = "";
                index++;
            }else if (s.charAt(index) == ']'){
                Integer time = numStack.pop();
                StringBuilder sb = new StringBuilder(strStack.pop());
                for (int i = 0; i < time; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                index++;
            }else {
                res += s.charAt(index);
                index++;
            }
        }


        return res;
    }
}
