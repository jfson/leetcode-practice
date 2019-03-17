package com.sun.leetcode.company.Ms;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2019/3/17
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc412 {
    /**
     412. Fizz Buzz
     Easy
     Write a program that outputs the string representation of numbers from 1 to n.

     But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

     Example:

     n = 15,

     Return:
     [
     "1",
     "2",
     "Fizz",
     "4",
     "Buzz",
     "Fizz",
     "7",
     "8",
     "Fizz",
     "Buzz",
     "11",
     "Fizz",
     "13",
     "14",
     "FizzBuzz"
     ]
     题意： 3的倍数填充 "Fizz",5的倍数填充 "Buzz",既是3的倍数又5的倍数填充 "FizzBuzz"
     solution: 没啥难度
     */
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<>();

        if(n == 0) return ret;

        for(int i = 1;i<= n; i++){
            if(i%3 ==0 && i%5==0){
                ret.add("FizzBuzz");
                continue;
            }

            if(i%3 == 0){
                ret.add("Fizz");
                continue;
            }

            if(i%5 == 0){
                ret.add("Buzz");
                continue;
            }

            ret.add(String.valueOf(i));
        }
        return ret;

    }
}
