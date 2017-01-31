package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

/**
 * 459 (easy): Repeated Substring Pattern
 * https://leetcode.com/problems/repeated-substring-pattern/
 * https://discuss.leetcode.com/category/587
 *
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies
 * of the substring together. You may assume the given string consists of lowercase English letters only and its
 * length will not exceed 10000.
 *
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 *
 * Example 2:
 * Input: "aba"
 * Output: False
 *
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatingSubStrPattern {
  public boolean repeatedSubstringPattern(String str) {
    if (str.length() <= 1) return false;

    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == str.charAt(0) && isRepeatingSubStr(str, i)) return true;
    }
    return false;
  }

  private boolean isRepeatingSubStr(String s, int n) {
    if (s.length() % n != 0) return false;
    for (int j = n; j <= s.length()-n; j+=n) {
      int k = 0;
      while (k < n) {
        if (s.charAt(k) != s.charAt(k+j)) return false;
        k++;
      }
    }
    return true;
  }
}
