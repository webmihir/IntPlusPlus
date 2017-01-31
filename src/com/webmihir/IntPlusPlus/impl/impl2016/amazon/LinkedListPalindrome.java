package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

import com.webmihir.IntPlusPlus.interfaces.common.ListNode;
import java.util.Stack;


/**
 * 234 (easy): Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 * https://discuss.leetcode.com/category/290
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class LinkedListPalindrome {
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;
    if (head.next.next == null) return (head.val == head.next.val);
    ListNode slow = head;
    ListNode fast = head.next;
    Stack<Integer> stack = new Stack<>();

    while (fast != null && fast.next != null) {
      stack.push(slow.val);
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast != null) stack.push(slow.val);
    slow = slow.next;
    while (!stack.isEmpty()) {
      if (stack.pop() != slow.val) return false;
      slow = slow.next;
    }
    return true;
  }
}
