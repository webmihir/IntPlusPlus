package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

import com.webmihir.IntPlusPlus.interfaces.common.ListNode;


/**
 * 2 (medium): Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 * https://discuss.leetcode.com/category/10
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.You may assume the two numbers do not contain any leading zero,
 * except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode res = new ListNode(-1);
    ListNode tail = res;

    while (l1 != null && l2 != null) {
      int sum = l1.val + l2.val + carry;
      carry = sum / 10;
      sum = sum % 10;
      ListNode sumNode = new ListNode(sum);
      tail.next = sumNode;
      tail = sumNode;
      l1 = l1.next;
      l2 = l2.next;
    }

    ListNode remainingNode = (l1 == null) ? l2 : l1;
    while (remainingNode != null) {
      int sum = remainingNode.val + carry;
      carry = sum / 10;
      sum = sum % 10;
      ListNode sumNode = new ListNode(sum);
      tail.next = sumNode;
      tail = sumNode;
      remainingNode = remainingNode.next;
    }

    if (carry > 0) {
      tail.next = new ListNode(carry);
    }
    return res.next;
  }
}
