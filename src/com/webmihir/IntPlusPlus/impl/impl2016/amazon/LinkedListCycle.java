package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

import com.webmihir.IntPlusPlus.interfaces.common.ListNode;


/**
 * 141 (easy): Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 * https://discuss.leetcode.com/category/149
 *
 * Given a linked list, determine if it has a cycle in it.
 * Follow up: Can you solve it without using extra space?
 */
public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;

    ListNode slow = head, fast = head.next;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (fast == slow) return true;
    }
    return false;
  }
}
