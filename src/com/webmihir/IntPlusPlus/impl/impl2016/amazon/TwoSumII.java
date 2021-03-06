package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

/**
 * 167 (Easy): Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * https://discuss.leetcode.com/category/175
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to
 * a specific target number. The function twoSum should return indices of the two numbers such that they add up to
 * the target, where index1 must be less than index2.
 *
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSumII {
  public int[] twoSum(int[] numbers, int target) {
    if (numbers == null || numbers.length == 0) return new int[] {-1, -1};

    int begin = 0, end = numbers.length - 1;
    while (begin < end) {
      if (numbers[begin] + numbers[end] == target) return new int[] {begin+1, end+1};

      if (numbers[begin] + numbers[end] > target) end --;
      else begin ++;
    }

    return new int[] {-1, -1};
  }
}
