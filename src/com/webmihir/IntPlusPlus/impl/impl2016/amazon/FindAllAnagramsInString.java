package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

import java.util.ArrayList;
import java.util.List;


/**
 * #438 (easy): 	Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * https://discuss.leetcode.com/category/563
 */
//Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
//
//    Strings consists of lowercase English letters only and the length of both strings s and p will
//    not be larger than 20,100.
//
//    The order of output does not matter.
//
//    Example 1:
//    Input:
//    s: "cbaebabacd" p: "abc"
//
//    Output:
//    [0, 6]
//
//    Explanation:
//    The substring with start index = 0 is "cba", which is an anagram of "abc".
//    The substring with start index = 6 is "bac", which is an anagram of "abc".
//
//
//    Example 2:
//
//    Input:
//    s: "abab" p: "ab"
//
//    Output:
//    [0, 1, 2]
//
//    Explanation:
//    The substring with start index = 0 is "ab", which is an anagram of "ab".
//    The substring with start index = 1 is "ba", which is an anagram of "ab".
//    The substring with start index = 2 is "ab", which is an anagram of "ab".
public class FindAllAnagramsInString {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> ret = new ArrayList<>();
    if (s == null || p == null || s.length() == 0 || p.length() == 0) return ret;
    if (s.length() < p.length()) return ret;

    int[] mapP = toMap(p, 0, p.length() - 1);
    int[] mapS = toMap(s, 0, p.length() - 1);

    for (int i = 0; i < s.length() - p.length(); i++) {
      if (isEqual(mapP, mapS)) ret.add(i);
      char firstElem = s.charAt(i);

      int cnt = mapS[firstElem - 'a'];
      mapS[firstElem - 'a'] --;

      char nextElem = s.charAt(i + p.length());
      //System.out.println("i=" + i + ", f=" + firstElem + ", n=" + nextElem);
      mapS[nextElem - 'a'] ++;
    }
    if (isEqual(mapP, mapS)) ret.add(s.length() - p.length());
    return ret;
  }

  private boolean isEqual(int[] map1, int[] map2) {
    for (int i = 0; i < 26; i++) {
      if (map1[i] != map2[i]) return false;
    }
    return true;
  }

  private int[] toMap(String s, int begin, int end) {
    int[] ret = new int[26];
    for (int i = begin; i <= end; i++) {
      char c = s.charAt(i);
      ret[c - 'a'] ++;
    }
    return ret;
  }
}
