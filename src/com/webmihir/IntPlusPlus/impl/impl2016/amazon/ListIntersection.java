package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

import com.webmihir.IntPlusPlus.interfaces.common.ListNode;


/**
 * 160 (easy): Intersection of Two Linked List
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 *
 * A:          a1 → a2
 *                   ↘
 *                    c1 → c2 → c3
 *                   ↗
 * B:    b1 → b2 → b3
 * begin to intersect at node c1.
 *
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class ListIntersection {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lenA = 0, lenB = 0;
    ListNode a = headA, b = headB;
    while (a != null || b != null) {
      if (a != null) {
        lenA ++;
        a = a.next;
      }

      if (b != null) {
        lenB ++;
        b = b.next;
      }
    }

    ListNode larger = headA, smaller = headB;
    if (lenB > lenA) {
      larger = headB;
      smaller = headA;
    }

    for (int i = 0; i < Math.abs(lenA-lenB); i++) {
      larger = larger.next;
    }

    while (larger != null && smaller != null) {
      if (larger == smaller) return larger;
      larger = larger.next;
      smaller = smaller.next;
    }
    return null;
  }
}
