package com.cunjunwang.algorithm.advanceddatastructure.stack;

import java.util.Stack;

/**
 * Created by CunjunWang on 2019-07-27.
 */
public class ValidParenthesis {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char topChar = stack.pop();
                    if ((c == '}' && topChar != '{') ||
                            (c == ']' && topChar != '[') ||
                            (c == ')' && topChar != '(')) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

}
