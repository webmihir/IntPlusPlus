package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

import java.util.Stack;


/**
 * 155 (easy): Min Stack
 * https://leetcode.com/problems/min-stack/
 * https://discuss.leetcode.com/category/163
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
  class Mystruct {
    public int val;
    public int min;

    public Mystruct(int val) { this.val = val; }
    public Mystruct(int val, int min) { this.val = val; this.min = min; }
  }

  Stack<Mystruct> stack;
  Integer min;

  /** initialize your data structure here. */
  public MinStack() {
    stack = new Stack<>();
    min = null;
  }

  public void push(int x) {
    if (min == null) min = x;
    else if (min.intValue() > x) min = x;
    Mystruct m = new Mystruct(x, min);
    stack.push(m);
  }

  public void pop() {
    Mystruct m = stack.pop();
    if (stack.isEmpty()) min = null;
    else min = stack.peek().min;
  }

  public int top() {
    return stack.peek().val;
  }

  public int getMin() {
    return min.intValue();
  }
}
