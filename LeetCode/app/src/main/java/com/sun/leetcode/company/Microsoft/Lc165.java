package com.sun.leetcode.company.Microsoft;

/**
 * Author: jfson sun
 * Create on:  2018/12/19
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc165 {
    /**
     * 165. Compare Version Numbers
     * DescriptionHintsSubmissionsDiscussSolution
     * Compare two version numbers version1 and version2.
     * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
     * <p>
     * You may assume that the version strings are non-empty and contain only digits and the . character.
     * The . character does not represent a decimal point and is used to separate number sequences.
     * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
     * <p>
     * Example 1:
     * <p>
     * Input: version1 = "0.1", version2 = "1.1"
     * Output: -1
     * Example 2:
     * <p>
     * Input: version1 = "1.0.1", version2 = "1"
     * Output: 1
     * Example 3:
     * <p>
     * Input: version1 = "7.5.2.4", version2 = "7.5.3"
     * Output: -1
     * <p>
     * 题意：比较版本。需校验版本非空，只包含数字和'.'
     * solution: 用stack
     */

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int length = Math.max(v1.length, v2.length);
        for (int i = 0; i < length; i++) {
            // 可能i < v1.length||v2.length
            Integer value1 = i < v1.length ? Integer.valueOf(v1[i]) : 0;
            Integer value2 = i < v2.length ? Integer.valueOf(v2[i]) : 0;
            int com = value1.compareTo(value2);
            if (com != 0) return com;
        }


        return 0;
    }
}
