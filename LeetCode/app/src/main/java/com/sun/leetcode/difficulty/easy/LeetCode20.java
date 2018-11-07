package com.sun.leetcode.difficulty.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * Author: jfson sun
 * Create on:  2018/9/24
 * Question: 20. Valid Parentheses
 * Description:Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * Train of thought: 依次压栈，获取栈顶数值比较，对应一组符号则移除一对，最后栈为null 则有效
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {

            // 包含就是end
            if (map.containsKey(s.charAt(i))) { // pop or return
                char topChar = stack.empty() ? '*' : stack.pop();
                if (topChar != map.get(s.charAt(i))) {
                    return false;
                }
            } else { // 不包含则是 start  push
                stack.push(s.charAt(i));
            }
        }

        return stack.empty();
    }
}
