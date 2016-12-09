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
    if (s == null || s.isEmpty()) {
      return true;
    }

    for (char c : s.toCharArray()) {
      if (set.contains(c)) {
        return false;
      }
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
    if (s1 == null && s2 == null) {
      return true;
    }
    if (s1 == null || s2 == null) {
      return false;
    }
    if (s1.length() != s2.length()) {
      return false;
    }

    Map<Character, Integer> map = new HashMap<>();
    for (char c : s1.toCharArray()) {
      int cnt = map.containsKey(c) ? map.get(c) : 0;
      map.put(c, cnt + 1);
    }

    for (char c : s1.toCharArray()) {
      if (!map.containsKey(c) || map.get(c) == 0) {
        return false;
      }
      map.put(c, map.get(c) - 1);
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
  public void urlIfy(char[] ch, int length) {
    if (length <= 0) {
      return;
    }
    int i = ch.length - 1;
    int j = length - 1;
    while (j >= 0) {
      if (ch[j] == ' ') {
        ch[i--] = '0';
        ch[i--] = '2';
        ch[i--] = '%';
      } else {
        ch[i--] = ch[j];
      }
      j--;
    }
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
    if (s == null || s.length() <= 1) {
      return true;
    }
    Set<Character> set = new HashSet<>();
    int len = 0;
    for (char c : s.toUpperCase().toCharArray()) {
      if (c == ' ') {
        continue;
      }
      if (set.contains(c)) {
        set.remove(c);
      } else {
        set.add(c);
      }
      len++;
    }

    return (len % 2 == 0) ? set.isEmpty() : (set.size() == 1);
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
    if (s1 == null && s2 == null) {
      return true;
    }
    String first = s1, second = s2;
    if (s1.length() > s2.length()) {
      first = s2;
      second = s1;
    }
    if (s1.length() - s2.length() > 1) {
      return false;
    }

    boolean foundDiff = false;
    int i = 0, j = 0;
    while (i < s1.length() && j < s2.length()) {
      if (s1.charAt(i) != s2.charAt(j)) {
        if (foundDiff) {
          return false;
        }
        foundDiff = true;
        if (s2.length() > s1.length()) {
          j++;
        } else {
          i++;
          j++;
        }
      } else {
        i++;
        j++;
      }
    }
    return true;
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
    if (s == null || s.length() <= 1) {
      return s;
    }
    StringBuilder sb = new StringBuilder();
    char prev = s.charAt(0);
    sb.append(prev);
    int i = 1;
    int cnt = 1;
    while (i < s.length()) {
      if (s.charAt(i) == prev) {
        i++;
        cnt++;
      } else {
        sb.append(cnt);
        cnt = 1;
        prev = s.charAt(i++);
        sb.append(prev);
      }
    }
    sb.append(cnt);

    return sb.length() < s.length() ? sb.toString() : s;
  }

  /**
   * 1.7 (Page 91): Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
   * write a method to rotate the image by 90 degrees. Can you do this in place?

   * @param matrix
   */
  @Override
  public void rotateMatrix(int[][] matrix) {
    super.rotateMatrix(matrix);
  }

  /**
   * 1.8 (Page 91): Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0

   * @param matrix
   */
  @Override
  public void zeroMatrix(int[][] matrix) {
    boolean firstRow = false, firstCol = false;
    if (matrix == null || matrix.length == 0) return;
    int rows = matrix.length, cols = matrix[0].length;

    //Find if the first col needs to be zeroed out later
    for (int i = 0; i < rows; i++) {
      if (matrix[i][0] == 0) {
        firstCol = true;
        break;
      }
    }

    //Find if the first row needs to be zeroed out later
    for (int i = 0; i < cols; i++) {
      if (matrix[0][i] == 0) {
        firstRow = true;
        break;
      }
    }

    //set corresponding first row or col val to 0 for any zero in the matrix
    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    //Zero out necessary rows
    for (int i = 1; i < rows; i++) {
      if (matrix[i][0] == 0) {
        for (int j = 1; j < cols; j++) {
          matrix[i][j] = 0;
        }
      }
    }

    //Zero out necessary cols
    for (int i = 1; i < cols; i++) {
      if (matrix[0][i] == 0) {
        for (int j = 1; j < rows; j++) {
          matrix[j][i] = 0;
        }
      }
    }

    //Zero out first row
    if (firstRow) {
      for (int i = 0; i < cols; i++) {
        matrix[0][i] = 0;
      }
    }

    //Zero out first col
    if (firstCol) {
      for (int i = 0; i < rows; i++) {
        matrix[i][0] = 0;
      }
    }
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
    return s1.length() == s2.length() && isSubString(s1+s1, s2);
  }
}
