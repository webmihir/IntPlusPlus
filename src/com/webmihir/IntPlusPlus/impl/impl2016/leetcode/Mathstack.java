package com.webmihir.IntPlusPlus.impl.impl2016.leetcode;

import java.util.Arrays;
import java.util.Collections;


/**
 * https://leetcode.com/problems/matchsticks-to-square/
 */
public class Mathstack {
  public boolean makesquare(int[] nums) {
    boolean[] visited = new boolean[nums.length];
    int perimeter = perimeter(nums);
    if (perimeter <= 0 || perimeter % 4 != 0) return false;

    int eachSide = perimeter / 4;
    Arrays.sort(nums);
    reverse(nums);

    for (int i = 0; i < 4; i++) {
      if (!containsSum(nums, eachSide, visited, 0)) return false;
      System.out.print("At i =" + i + ":");
      for (boolean b : visited) System.out.print(b);
      System.out.println();
    }
    return true;
  }

  private void reverse(int[] nums) {
    for (int i = 0; i < nums.length/2; i++) {
      int t = nums[i];
      nums[i] = nums[nums.length - i - 1];
      nums[nums.length - i - 1] = t;
    }
  }

  private int perimeter(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int sum = 0;
    for (int n : nums) sum += n;
    return sum;
  }

  private boolean containsSum(int[] nums, int sum, boolean[] visited, int index) {
    if (sum == 0) return true;
    if (sum < 0) return false;
    if (index >= nums.length) return false;
    boolean found = true;
    for (int i = index; i < nums.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        if (!containsSum(nums, sum - nums[i], visited, i+1)) visited[i] = false;
        else { found = true; break; }
      }
    }
    return found;
  }
}