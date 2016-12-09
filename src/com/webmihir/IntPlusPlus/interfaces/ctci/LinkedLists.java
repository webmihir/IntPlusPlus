package com.webmihir.IntPlusPlus.interfaces.ctci;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public abstract class LinkedLists {
  /**
   * 2.1 (Page 94): Write code to remove duplicates from an unsorted LinkedList.
   * How would you solve this problem if a temporary buffer was not allowed
   * @param head
   */
  public void remoteDupes(ListNode head) { throw new NotImplementedException(); }

  /**
   * 2.2 (Page 94): Implement an algorithm to find the k-th to last element of a singly linked list
   * @param head
   * @return
   */
  public ListNode kthToLast(ListNode head)  { throw new NotImplementedException(); }

  /**
   * 2.3 (Page 94): Implement an algorithm to delete a node in the moddle of a singly linked list
   * given access to only that node
   * @param node
   */
  public void deleteMiddleNode(ListNode node)  { throw new NotImplementedException(); }

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
  public void partitionList(ListNode head, int val) { throw new NotImplementedException(); }

  /**
   * 2.5 (Page 94): You have two numbers represented by a LinkedList, where each node contains a single digit.
   * The digts are stored in reverse order, such that the 1's digit is at the head of the list.
   * Write a function that adds the two numbers and returns the sum as a Linked List.
   * Example:
   * Input (7 -> 1 -> 6) + (5 -> 9 -> 2). i.e. 617+285 = 912
   * Output (2 -> 1 -> 9)
   *
   * @param list1
   * @param list2
   * @return
   */
  public ListNode sumLists(ListNode list1, ListNode list2) { throw new NotImplementedException(); }

  /** 2.5 (Page 94) Follow-up: For the above question, suppose the digits are stored in forward order.
   * How would you solve it then?
   * @param list1
   * @param list2
   * @return
   */
  public ListNode sumLists2(ListNode list1, ListNode list2) { throw new NotImplementedException(); }

  /**
   * 2.6 (Page 95): Write a function to check if a LinkedList is a palindrome
   * @param head
   * @return
   */
  public boolean isPalindrome(ListNode head) { throw new NotImplementedException(); }

  /**
   * 2.7 (Page 95): Given two Singly Linked List, determine if the two lists intersect, and return the intersecting node.
   * Note that the intersection is defined by reference and not by value.
   * That is, if the kth node of the first linked list is the same exact node (by reference) as the jth node of the second list,
   * they are interesecting.
   * @param list1
   * @param list2
   * @return
   */
  public ListNode findIntersection(ListNode list1, ListNode list2) { throw new NotImplementedException(); }

  /**
   * 2.8 (Page 95): Given a circular linked list, implement and algorithm that returns the node at the beginning of the loop.
   * Example:
   * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 3 (the same 3 as earlier by reference)
   * Output: 3
   * @param head
   * @return
   */
  public ListNode findLoop(ListNode head) { throw new NotImplementedException(); }

  public class ListNode {
    ListNode next;
    int val;
  }
}
