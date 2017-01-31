package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


/**
 * 451 (medium): Sort Characters By Frequency
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * https://discuss.leetcode.com/category/578
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 * Input: "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 * Example 2:
 * Input: "cccaaa"
 * Output: "cccaaa"
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 *
 * Example 3:
 * Input: "Aabb"
 * Output: "bbAa"
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharsByFrequency {
  public String frequencySort(String s) {
    Character[] chs = new Character[s.length()];
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      chs[i] = c;
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    Arrays.sort(chs, new Comparator<Character>() {
      @Override
      public int compare(Character c1, Character c2) {
        int diff = map.get(c2) - map.get(c1);
        if (diff != 0) return diff;
        return c2 - c1;
      }
    });

    StringBuilder sb = new StringBuilder();
    for (char c : chs) sb.append(c);
    return sb.toString();
  }
}
