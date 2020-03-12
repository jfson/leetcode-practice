package com.sun.leetcode.jianzhioffer;

/**
 * Author: jfson sun
 * Create on:  2020/3/12
 * Question:
 * Description:
 * Train of thought:
 */
public class ReplaceSpace02 {
    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */

    public String replaceSpace(StringBuffer str) {
        String ret = "";
        if(str == null){
            return ret;
        }

        String string = str.toString();
        if(string == null || string.length() == 0){
            return ret;
        }
        //string = string.trim();

        for(int i = 0;i < string.length(); i++){
            if(string.charAt(i) == ' '){
                ret += "%20";
            }else{
                ret += string.charAt(i);
            }
        }

        return ret;
    }
}
