package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

/**
 * 242 (easy): Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 * https://discuss.leetcode.com/category/303
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] chars = new int[26];
    for (int i = 0; i < s.length(); i++) {
      chars[s.charAt(i)-'a']++;
      chars[t.charAt(i)-'a']--;
    }
    for (int i : chars) if (i != 0) return false;
    return true;
  }
}
