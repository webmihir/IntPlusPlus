package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

import com.webmihir.IntPlusPlus.interfaces.common.ListNode;


/**
 * #21 (easy): 	Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * https://discuss.leetcode.com/category/29/merge-two-sorted-lists
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeSortedLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode tail = head;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        tail.next = l1;
        tail = l1;
        l1 = l1.next;
      } else {
        tail.next = l2;
        tail = l2;
        l2 = l2.next;
      }

      tail.next = null;
    }

    if (l1 != null) tail.next = l1;
    else tail.next = l2;
    return head.next;
  }
}
