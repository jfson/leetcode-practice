package com.sun.leetcode.company.Ms;

/**
 * Author: jfson sun
 * Create on:  2018/12/22
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc344 {
    /**
     344. Reverse String
     DescriptionHintsSubmissionsDiscussSolution
     Write a function that takes a string as input and returns the string reversed.

     Example 1:

     Input: "hello"
     Output: "olleh"
     Example 2:

     Input: "A man, a plan, a canal: Panama"
     Output: "amanaP :lanac a ,nalp a ,nam A"
     */

    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int i = 0,j=chars.length-1;

        while (i< j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }


        return new String(chars);
    }
}
