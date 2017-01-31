package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 15 (medium): 3Sum
 * https://leetcode.com/problems/3sum/
 * https://discuss.leetcode.com/category/23
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 *
 * Example:
 * given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *  [-1, 0, 1],
 *  [-1, -1, 2]
 * ]
 */
public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ret = new ArrayList<>();
    if (nums.length < 3) return ret;
    Arrays.sort(nums);
    for (int i = 0; i <= nums.length - 3; i++) {
      if (i > 0 && nums[i] == nums[i-1]) continue;
      int begin = i+1;
      int end = nums.length - 1;
      while (begin < end) {
        int sum = nums[i] + nums[begin] + nums[end];
        if (sum == 0) {
          List<Integer> ts = new ArrayList<>();
          ts.add(nums[i]); ts.add(nums[begin]); ts.add(nums[end]);
          if (!ret.contains(ts)) ret.add(ts);
          begin ++; end --;
          while (begin < nums.length && nums[begin] == nums[begin-1]) begin ++;
          while (end >= 0 && nums[end] == nums[end + 1]) end--;
        } else if (sum > 0) {
          end --;
        } else {
          begin ++;
        }
      }
    }

    return ret;
  }
}
