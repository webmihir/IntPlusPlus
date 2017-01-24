package com.webmihir.IntPlusPlus.impl.impl2016.ctci;

import com.webmihir.IntPlusPlus.interfaces.common.ListNode;
import com.webmihir.IntPlusPlus.interfaces.ctci.LinkedLists;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class LinkedListsImpl extends LinkedLists {
  /**
   * 2.1 (Page 94): Write code to remove duplicates from an unsorted LinkedList.
   * How would you solve this problem if a temporary buffer was not allowed

   * @param head
   */
  @Override
  public void removeDupes(ListNode head) {
    Set<Integer> set = new HashSet<>();
    if (head == null) {
      return;
    }
    set.add(head.val);
    ListNode cur = head;
    while (cur.next != null) {
      if (set.contains(cur.next.val)) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
        set.add(cur.val);
      }
    }
  }

  /**
   * 2.2 (Page 94): Implement an algorithm to find the k-th to last element of a singly linked list
   * @param head
   * @param k
   * @return
   */
  @Override
  public ListNode kthToLast(ListNode head, int k) {
    ListNode fast = head;
    for (int i = 1; i < k; i++) {
      fast = fast.next;
      if (fast == null) {
        return null;
      }
    }

    ListNode curr = head;
    while (fast.next != null) {
      curr = curr.next;
      fast = fast.next;
    }
    return curr;
  }

  /**
   * 2.3 (Page 94): Implement an algorithm to delete a node in the middle of a singly linked list
   * given access to only that node

   * @param node
   */
  @Override
  public void deleteMiddleNode(ListNode node) {
    if (node == null || node.next == null) {
      return; //cannot be the tail node
    }

    //copy next node's value into current node, then delete the next node
    node.val = node.next.val;
    node.next = node.next.next;
  }

  /**
   * 2.4 (Page 94): Write code to partition a linked list around a value x, such that all nodes less than x come before
   * all nodes greater than or equal to x. If x is contained within the list, the values of x only need to
   * be after the elements less than x (see example):
   * Example:
   * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 (val = 5)
   * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5-> 8

   * @param head
   * @param val
   */
  @Override
  public ListNode partitionList(ListNode head, int val) {
    ListNode newHead = null, newTail = null;

    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      if (newHead == null) {
        newHead = curr;
        newTail = curr;
        newHead.next = null;
      } else {
        if (curr.val < val) {
          curr.next = newHead;
          newHead = curr;
        } else {
          newTail.next = curr;
          newTail = curr;
          curr.next = null;
        }
      }
      curr = next;
    }
    return newHead;
  }

  /**
   * 2.5 (Page 94): You have two numbers represented by a LinkedList, where each node contains a single digit.
   * The digts are stored in reverse order, such that the 1's digit is at the head of the list.
   * Write a function that adds the two numbers and returns the sum as a Linked List.
   * Example:
   * Input (7 -> 1 -> 6) + (5 -> 9 -> 2). i.e. 617+295 = 912
   * Output (2 -> 1 -> 9)
   *
   * @param list1
   * @param list2
   * @return
   */
  @Override
  public ListNode sumLists(ListNode list1, ListNode list2) {
    ListNode head = new ListNode();
    ListNode l1 = list1, l2 = list2;
    int carry = 0;

    ListNode tail = head;
    while (l1 != null && l2 != null) {
      int sum = l1.val + l2.val + carry;
      ListNode newNode = new ListNode(sum % 10);
      tail.next = newNode;
      tail = newNode;
      carry = sum / 10;
      l1 = l1.next;
      l2 = l2.next;
    }

    //Handle case where one list is larger than other
    ListNode nonNull = (l1 != null) ? l1 : l2;
    while (nonNull != null) {
      int sum = nonNull.val + carry;
      ListNode newNode = new ListNode(sum % 10);
      tail.next = newNode;
      tail = newNode;
      carry = sum / 10;
      nonNull = nonNull.next;
    }

    //Handle case where the sum of most significant digit caused a carry
    //i.e. sum list will be larger than either of the two lists
    if (carry != 0) {
      ListNode newNode = new ListNode(carry);
      tail.next = newNode;
      tail = newNode;
    }

    return head.next;
  }

  /** 2.5 (Page 94) Follow-up: For the above question, suppose the digits are stored in forward order.
   * How would you solve it then?
   * @param list1
   * @param list2
   * @return
   */
  @Override
  public ListNode sumLists2(ListNode list1, ListNode list2) {
    return super.sumLists2(list1, list2);
  }

  /**
   * 2.6 (Page 95): Write a function to check if a LinkedList is a palindrome
   * @param head
   * @return
   */
  @Override
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    Stack<Integer> stack = new Stack<>();
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      stack.push(slow.val);
      slow = slow.next;
      fast = fast.next.next;
    }

    //handle odd case here
    if (fast != null) {
      slow = slow.next;
    }

    while (slow != null) {
      if (slow.val != stack.pop()) {
        return false;
      }
      slow = slow.next;
    }
    return true;
  }

  /**
   * 2.7 (Page 95): Given two Singly Linked List, determine if the two lists intersect, and return the intersecting node.
   * Note that the intersection is defined by reference and not by value.
   * That is, if the kth node of the first linked list is the same exact node (by reference) as the jth node of the second list,
   * they are interesecting.
   * @param list1
   * @param list2
   * @return
   */
  @Override
  public ListNode findIntersection(ListNode list1, ListNode list2) {
    if (list1 == null || list2 == null) {
      return null;
    }

    int len1 = len(list1);
    int len2 = len(list2);

    ListNode small = list1, big = list2;
    if (len1 > len2) {
      small = list2;
      big = list1;
    }

    int diff = Math.abs(len1 - len2);
    for (int i = 0; i < diff; i++) {
      big = big.next;
    }

    while (small != null && big != null) {
      if (small == big) {
        return small;
      }
      small = small.next;
      big = big.next;
    }
    return null;
  }

  private int len(ListNode lst) {
    int len = 0;
    while (lst != null) {
      len++;
      lst = lst.next;
    }
    return len;
  }

  /**
   * 2.8 (Page 95): Given a circular linked list, implement and algorithm that returns the node at the beginning of the loop.
   * Example:
   * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 3 (the same 3 as earlier by reference)
   * Output: 3
   * @param head
   * @return
   */
  @Override
  public ListNode findLoop(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }
    }

    //Not a looped list
    if (fast == null || fast.next == null) {
      return null;
    }

    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }
}
