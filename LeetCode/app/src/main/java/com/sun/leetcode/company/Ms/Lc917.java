package com.sun.leetcode.company.Ms;

/**
 * Author: jfson sun
 * Create on:  2019/3/17
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc917 {
    /**
     917. Reverse Only Letters
     Easy

     Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.

     Example 1:

     Input: "ab-cd"
     Output: "dc-ba"
     Example 2:

     Input: "a-bC-dEf-ghIj"
     Output: "j-Ih-gfE-dCba"
     Example 3:

     Input: "Test1ng-Leet=code-Q!"
     Output: "Qedo1ct-eeLg=ntse-T!"

     题意：翻转数组，非字母的元素保持顺序不变
     solution: 记住API：Character.isLetter
     */
    public String reverseOnlyLetters(String S) {
        if(S.isEmpty()) return S;
        int startIndex = 0;
        int endIndex = S.length()-1;
        char[] str = S.toCharArray();

        while(startIndex < endIndex){
            if(!Character.isLetter(str[startIndex])){
                startIndex++;
                continue;
            }
            if(!Character.isLetter(str[endIndex])){
                endIndex--;
                continue;
            }

            char swap = str[startIndex];
            str[startIndex] = str[endIndex];
            str[endIndex] = swap;
            startIndex++;
            endIndex--;
        }

        return String.valueOf(str);
    }
}
