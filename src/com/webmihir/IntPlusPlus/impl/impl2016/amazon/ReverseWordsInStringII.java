package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

/**
 * 186 (medium): Reverse words in a String II
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 * https://discuss.leetcode.com/category/194
 *
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 *
 * For example, Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Could you do it in-place without allocating extra space?
 */
public class ReverseWordsInStringII {
  public void reverseWords(char[] s) {
    reverse(s, 0, s.length - 1);

    int begin = 0;
    for (int i = 0; i < s.length; i++) {
      if (i == s.length - 1 || s[i + 1] == ' ') {
        reverse(s, begin, i);
        begin = i+2;
      }
    }
  }

  private void reverse(char[] s, int begin, int end) {
    while (begin < end) {
      char c = s[begin];
      s[begin++] = s[end];
      s[end--] = c;
    }
  }
}
