package com.webmihir.IntPlusPlus.interfaces;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public abstract class Revision {
  /**
   * CTCI 1.5 (Page 91): There are three types of edits that can be performed on strings: insert a character, remove a character, or
   * replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
   * Example:
   * pale, ple --> true
   * pales, pale --> true
   * pale, bake --> false
   * @param s1
   * @param s2
   * @return
   */
  public boolean isOneEditAway(String s1, String s2) { throw new NotImplementedException(); }
}
