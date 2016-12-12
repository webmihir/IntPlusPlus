package com.webmihir.IntPlusPlus.interfaces.common;

/**
 * Represents a node in a Singly Linked List
 */
public class ListNode {
  public ListNode next;
  public int val;

  public ListNode() {
  }

  public ListNode(int val) {
    this(val, null);
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.val);
    ListNode next = this.next;
    ListNode fast = (next == null) ? null : next.next;
    while (next != null) {
      sb.append(" --> ");
      sb.append(next.val);
      next = next.next;
      if (fast != null) {
        fast = fast.next;
      }
      if (fast != null) {
        fast = fast.next;
      }
      if (next != null && fast == next) {
        sb = new StringBuilder("<Looped List>");
        break;
      }
    }
    return sb.toString();
  }
}