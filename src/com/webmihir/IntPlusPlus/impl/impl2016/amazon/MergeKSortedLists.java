package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

import com.webmihir.IntPlusPlus.interfaces.common.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 23 (medium): Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * https://discuss.leetcode.com/category/31
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;
    if (lists.length == 1) return lists[0];

    List<ListNode> ret = Arrays.asList(lists);
    while (ret.size() > 1) {
      List<ListNode> ret2 = new ArrayList<>();
      int mergeSize = (ret.size()/2);
      for (int i = 0; i < mergeSize; i++) {
        ListNode a = ret.get(i*2);
        ListNode b = ret.get(i*2 + 1);
        ret2.add(merge(a,b));
      }
      if (ret.size() % 2 == 1) ret2.add(ret.get(ret.size()-1));
      ret = ret2;
    }
    return ret.get(0);
  }

  private ListNode merge(ListNode a, ListNode b) {
    ListNode c = new ListNode(-1);
    ListNode tail = c;
    while (a != null && b != null) {
      if (a.val < b.val) {
        tail.next = a;
        tail = a;
        a = a.next;
      } else {
        tail.next = b;
        tail = b;
        b = b.next;
      }
    }
    if (a != null) tail.next = a;
    else tail.next = b;
    return c.next;
  }
}
