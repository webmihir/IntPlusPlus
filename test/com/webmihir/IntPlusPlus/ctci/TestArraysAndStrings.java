package com.webmihir.IntPlusPlus.ctci;

import com.webmihir.IntPlusPlus.impl.impl2016.ctci.ArraysAndStringImpl;
import com.webmihir.IntPlusPlus.interfaces.ctci.ArraysAndStrings;
import static org.testng.Assert.*;
import org.testng.annotations.Test;


public class TestArraysAndStrings {
  private final ArraysAndStrings _testClass = new ArraysAndStringImpl();

  @Test
  public void testIsUnique() {
    assertTrue(_testClass.isUnique("a"));
    assertTrue(_testClass.isUnique(""));
    assertTrue(_testClass.isUnique(null));
    assertTrue(_testClass.isUnique("abc"));

    assertFalse(_testClass.isUnique("aa"));
    assertFalse(_testClass.isUnique("aba"));
  }
}
