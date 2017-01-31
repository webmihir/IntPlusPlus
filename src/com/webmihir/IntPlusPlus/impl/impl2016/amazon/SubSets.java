package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

import java.util.ArrayList;
import java.util.List;


/**
 * 78 (Medium): Subsets
 * https://leetcode.com/problems/subsets/
 * https://discuss.leetcode.com/category/86
 *
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 *
 * For example,
 * If nums = [1,2,3], a solution is:
 *
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 */
public class SubSets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ret = new ArrayList<>();
    ret.add(new ArrayList<Integer>());
    if (nums.length == 0) return ret;
    for (int i : nums) {
      List<List<Integer>> tmp = new ArrayList<>();
      for (List<Integer> l : ret) {
        List<Integer> newList = new ArrayList<>();
        newList.addAll(l);
        newList.add(i);
        tmp.add(newList);
      }
      ret.addAll(tmp);
    }
    return ret;
  }
}
