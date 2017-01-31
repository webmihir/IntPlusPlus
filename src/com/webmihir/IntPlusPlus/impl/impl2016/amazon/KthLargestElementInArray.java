package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

import java.util.PriorityQueue;


/**
 * 215 (medium): K-th Largest Element in An Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * https://discuss.leetcode.com/category/223
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example:
 * Given [[3,2,1,5,6,4] and k = 2, return 5
 *
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInArray {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<>();

    for (int n : nums) {
      q.offer(n);
      if (q.size() > k) q.poll();
    }
    return q.poll();
  }
}
