package com.sun.leetcode.company.li;

/**
 * Author: jfson sun
 * Create on:  2019/5/3
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc150 {
    /**
     150. Evaluate Reverse Polish Notation
     Medium

     487

     341

     Favorite

     Share
     Evaluate the value of an arithmetic expression in Reverse Polish Notation.

     Valid operators are +, -, *, /. Each operand may be an integer or another expression.

     Note:

     Division between two integers should truncate toward zero.
     The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
     Example 1:

     Input: ["2", "1", "+", "3", "*"]
     Output: 9
     Explanation: ((2 + 1) * 3) = 9
     Example 2:

     Input: ["4", "13", "5", "/", "+"]
     Output: 6
     Explanation: (4 + (13 / 5)) = 6
     Example 3:

     Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
     Output: 22
     Explanation:
     ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
     = ((10 * (6 / (12 * -11))) + 17) + 5
     = ((10 * (6 / -132)) + 17) + 5
     = ((10 * 0) + 17) + 5
     = (0 + 17) + 5
     = 17 + 5
     = 22
     题意： 逆波兰式。。逆波兰式有个优点就是他不需要括号来表示优先级，直接根据式子本身就可以求解。
     思路是维护一个运算数栈，读到运算数的时候直接进栈；而读到一个运算符，就从栈顶取出两个运算数
     ，运算之后将结果做为一个运算数放回栈中，直到式子结束，此时栈中唯一一个元素便是结果。
     纯数学不做
     */

}
