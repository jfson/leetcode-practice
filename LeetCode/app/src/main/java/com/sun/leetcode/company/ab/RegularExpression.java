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


    public class Solution_2 {
        public boolean regMatch(String s, String p) {
            if (s == null || p == null) return false;
            boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
            dp[0][0] = true;
            for (int i = 1; i <= p.length(); i++) {
                if (p.charAt(i - 1) == '*' && dp[i - 2][0]) dp[i][0] = true;
            }

            for (int i = 1; i <= p.length(); i++) {
                for (int j = 1; j <= s.length(); j++) {
                    if (p.charAt(i - 1) == '.' || p.charAt(i - 1) == s.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(i - 1) == '*' || p.charAt(i - 1) == '+') {
                        if (p.charAt(i - 2) == '.' || p.charAt(i - 2) == s.charAt(j - 1)) {
                            if (p.charAt(i - 1) == '*') {
                                dp[i][j] = dp[i - 2][j] || dp[i - 2][j - 1] || dp[i][j - 1];
                            } else {
                                dp[i][j] = dp[i - 2][j - 1] || dp[i][j - 1];
                            }
                        } else {
                            dp[i][j] = p.charAt(i - 1) == '*' && dp[i - 2][j];
                        }
                    }
                }
            }
            return dp[p.length()][s.length()];
        }
    }
}
