package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

import com.webmihir.IntPlusPlus.interfaces.common.ListNode;


/**
 * 206 (easy): Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 * https://discuss.leetcode.com/category/214
 *
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    if (head == null) return head;

    ListNode a = head;
    ListNode b = a.next;
    ListNode c = (b != null) ? b.next : null;
    a.next = null;
    while (b != null) {
      b.next = a;
      a = b;
      b = c;
      c = (b != null) ? b.next : c;
    }
    return a;
  }
}
