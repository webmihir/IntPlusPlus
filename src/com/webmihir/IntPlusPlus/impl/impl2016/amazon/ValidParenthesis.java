package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * 20 (easy): Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 * https://discuss.leetcode.com/category/28
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParenthesis {
  public boolean isValid(String s) {
    if (s.length() == 0) return true;

    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put(']', '[');
    map.put('}', '{');
    Stack<Character> stack = new Stack<>();
    char[] chs = s.toCharArray();
    for (char c : chs) {
      if (map.containsKey(c)) {
        if (stack.isEmpty() || stack.pop() != map.get(c)) return false;
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }
}
