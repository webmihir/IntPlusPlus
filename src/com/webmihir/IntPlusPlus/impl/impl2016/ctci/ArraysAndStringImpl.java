package com.webmihir.IntPlusPlus.impl.impl2016.ctci;

import com.webmihir.IntPlusPlus.interfaces.ctci.ArraysAndStrings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ArraysAndStringImpl extends ArraysAndStrings {
  /**
   * 1.1 (Page 90): Implement an algorithm to determine if a string has all unique characters.
   * What if you cannot use additional Data Structures?
   * @param s
   * @return
   */
  @Override
  public boolean isUnique(String s) {
    Set<Character> set = new HashSet<>();
    if (s == null || s.isEmpty()) return true;

    for (char c : s.toCharArray()) {
      if (set.contains(c)) return false;
      set.add(c);
    }
    return true;
  }

  /**
   * 1.2 (Page 90): Given two strings, write a method to decide if one is a permutation of the other
   * @param s1
   * @param s2
   * @return
   */
  @Override
  public boolean isPermutation(String s1, String s2) {
    if (s1 == null && s2 == null) return true;
    if (s1 == null || s2 == null) return false;
    if (s1.length() != s2.length()) return false;

    Map<Character, Integer> map = new HashMap<>();
    for(char c : s1.toCharArray()) {
      int cnt = map.containsKey(c) ? map.get(c) : 0;
      map.put(c, cnt+1);
    }

    for(char c: s1.toCharArray()) {
      if (!map.containsKey(c) || map.get(c) == 0) return false;
      map.put(c, map.get(c)-1);
    }
    return true;
  }

  /**
   * 1.3 (Page 90): Write a method to replace all spaces in a string with %20. You may assume that the String has sufficient space
   * at the end to hold the additional characters, and that you are given the "true" length of the String.
   * Example:
   * Input: "Mr John Smith    ", 13
   * Output: "Mr%20John%20Smith
   * @param ch
   * @param length

   * @return
   */
  @Override
  public String urlIfy(char[] ch, int length) {
    return super.urlIfy(ch, length);
  }

  /**
   * 1.4 (Page 91): Given a String, write a function to check if it is a permutation of a palindrome.
   * A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement
   * of letters. The palindrom does not need to be limited to just dictionary words.
   * Example
   * Input: Tact Coa
   * Output: True (Permutations: "taco cat", "atco cta", etc.
   * @param s
   * @return
   */
  @Override
  public boolean isPalindromePermutation(String s) {
    return super.isPalindromePermutation(s);
  }

  /**
   * 1.5 (Page 91): There are three types of edits that can be performed on strings: insert a character, remove a character, or
   * replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
   * Example:
   * pale, ple --> true
   * pales, pale --> true
   * pale, bake --> false
   * @param s1
   * @param s2
   * @return
   */
  @Override
  public boolean isOneEditAway(String s1, String s2) {
    return super.isOneEditAway(s1, s2);
  }

  /**
   * 1.6 (Page 91): Implement a method to perform basic string compression using the counts of repeated characters.
   * Example, the string "aabcccccaaa" would become "a2b1c5a3".
   * If the compressed string would not become smaller than the original string, your method should return the original string.
   * You can assume the string has only uppercase and lowercase letters (a-z, A-Z).
   * @param s
   * @return
   */
  @Override
  public String compressedString(String s) {
    return super.compressedString(s);
  }

  /**
   * 1.7 (Page 91): Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
   * write a method to rotate the image by 90 degrees. Can you do this in place?

   * @param matrix
   */
  @Override
  public void rotateMetrix(int[][] matrix) {
    super.rotateMetrix(matrix);
  }

  /**
   * 1.8 (Page 91): Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0

   * @param matrix
   */
  @Override
  public void zeroMatrix(int[][] matrix) {
    super.zeroMatrix(matrix);
  }

  /**
   * 1.9 (Page 91): Assume you have a method isSubString which checks if one word is a substring of another
   * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to
   * isSubString. Example: "waterbottle" is a rotation of "erbottlewat".
   * @param s1
   * @param s2
   * @return
   */
  @Override
  public boolean isRotation(String s1, String s2) {
    return super.isRotation(s1, s2);
  }

  /**
   * 16.8 (Page 182): Given any integer, print an English Phrase that describes the integer.
   * Example: 1234 -> "One Thousand Two Hundred Thirty Four"
   * @param n
   * @return
   */
  @Override
  public String englishInteger(int n) {
    return super.englishInteger(n);
  }
}
