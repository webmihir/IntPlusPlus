package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


/**
 * 414 (easy): Third Maximum Integer
 * https://leetcode.com/problems/third-maximum-number/
 * https://discuss.leetcode.com/category/542
 *
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 * Output: 1
 * Explanation: The third maximum is 1.
 *
 * Example 2:
 * Input: [1, 2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 *
 * Example 3:
 * Input: [2, 2, 3, 1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaxInteger {
  public int thirdMax(int[] nums) {
    Set<Integer> set = new HashSet<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i : nums) {
      if (!set.contains(i)) {
        set.add(i);
        pq.offer(i);

        if (pq.size() > 3) set.remove(pq.poll());
      }
    }

    int max = pq.peek();
    if (pq.size() < 3) {
      while (!pq.isEmpty()) max = pq.poll();
    }
    return max;
  }
}
