package com.sun.leetcode.company.ab;

/**
 * Author: jfson sun
 * Create on:  2019/1/4
 * Question:
 * Description:
 * Train of thought:
 */
public class RegularExpression {
    /*
      Regular Expression
      AirBnB Interview Question
      正则解析
      *(星号)星号表示您所期望的，在模式的那个位置将会有0个或更多以前的字符。
      . 点表示该位置的任何字符。
      +(+)。加号表示图案中该处的一个或多个先前字符。
      "saaaa", "s+a*"
   */
    public class Solution {
        public boolean regMatch(String source, String pattern) {
            if (pattern.length() == 0) return source.length() == 0;
            if (pattern.length() == 1) {
                if (source.length() > 1 || source.length() == 0) return false;
                return source.charAt(0) == pattern.charAt(0);
            }

            if (source.length() != 0 && (pattern.charAt(0) == '.' || pattern.charAt(0) == source.charAt(0))) {
                if (pattern.charAt(1) == '*') {
                    return regMatch(source.substring(1), pattern) || regMatch(source, pattern.substring(2));
                } else if (pattern.charAt(1) == '+') {
                    return regMatch(source.substring(1), pattern.substring(2)) || regMatch(source.substring(1), pattern.substring(2));
                } else {
                    return regMatch(source.substring(1), pattern.substring(1));
                }
            }
            //
            return pattern.charAt(1) == '*' && regMatch(source, pattern.substring(2));
        }
    }
}
