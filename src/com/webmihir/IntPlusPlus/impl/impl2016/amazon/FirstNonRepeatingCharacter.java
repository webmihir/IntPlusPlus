package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

/**
 * 387 (easy): First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * https://discuss.leetcode.com/category/509
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstNonRepeatingCharacter {
  public int firstUniqChar(String s) {
    if (s.length() == 0) return -1;

    int[] chars = new int[26];
    char[] chs = s.toCharArray();
    for (char c: chs) {
      chars[c-'a']++;
    }
    int i = 0;
    for (char c : chs) {
      if (chars[c-'a'] == 1) return i;
      i++;
    }
    return -1;
  }
}
