package com.sun.leetcode.company.bytedance;

/**
 * Author: jfson sun
 * Create on:  2020/3/1
 * Question:
 * Description:
 * Train of thought:
 */
public class BigNumber {
    /**
     * 两个大数相乘
     * <p>
     * 12
     * 34
     * -----
     * 8
     * 4
     * 6
     * 3
     * -----
     */

    public static String bigNumber(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        reverse(aChars);
        reverse(bChars);


        int[] result = new int[a.length() + b.length()];
        for (int i = 0; i < aChars.length; i++) {
            for (int j = 0; j < bChars.length; j++) {
                result[i + j] += (aChars[i] - '0') * (bChars[j] - '0');
            }
        }

//        8  10  3
        // 804
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < result.length; i++) {
            if (result[i] >= 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }

        if (result[result.length-1] != 0){
            sb.append(result[result.length-1]);
        }

        for (int i = result.length - 2; i >= 0; i--) {
            sb.append(result[i]);
        }

        return sb.toString();
    }

    private static void reverse(char[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            char temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
    }
}
