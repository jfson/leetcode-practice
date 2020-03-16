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
     * 替换空格
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     0 --> 0000 0000
     1 --> 0000 0001

     a ---> 0000 XXXX
     b ---比a大1
     */

    public String replaceSpace(StringBuffer str) {
        String ret = "";
        //安全校验
        if(str == null){
            return ret;
        }

        int length = str.length();
        if (length == 0){
            return ret;
        }

        //空格 --> ' '
        //We Are Happy : String
        //char[]   ['W','e',' ','A'...]
        //char[] chars = str.toString().toCharArray();;
        //We%20A..
        for(int i = 0; i < length; i++){
            if (str.charAt(i) == ' '){
                ret += "%20";
            }else {
                ret += str.charAt(i);
            }
        }

        return ret;
    }

    //修饰符 +  返回值  +  方法名 （方法参数）
      public   void    get(StringBuffer str) {


      }


      public int  getChengji(String name){
        if (name == "zhangsan"){
            return 100;
        }else if (name.equals("lisi")){
            return 10;
        }

        return 0;
      }






































//
//        String ret = "";
//        if(str == null){
//            return ret;
//        }
//
//        String string = str.toString();
//        if(string == null || string.length() == 0){
//            return ret;
//        }
//        //string = string.trim();
//
//        for(int i = 0;i < string.length(); i++){
//            if(string.charAt(i) == ' '){
//                ret += "%20";
//            }else{
//                ret += string.charAt(i);
//            }
//        }
//
//        return ret;
//    }
}
