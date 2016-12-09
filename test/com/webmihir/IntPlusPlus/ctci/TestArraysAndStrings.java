package com.webmihir.IntPlusPlus.ctci;

import com.webmihir.IntPlusPlus.BaseTest;
import com.webmihir.IntPlusPlus.dataproviders.CtciDataProviders;
import com.webmihir.IntPlusPlus.interfaces.ctci.ArraysAndStrings;

import static org.testng.Assert.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class TestArraysAndStrings extends BaseTest {
  @Test(dataProvider = "arraysandstrings", dataProviderClass = CtciDataProviders.class)
  public void testIsUnique(ArraysAndStrings testClass) {
    assertTrue(testClass.isUnique("a"));
    assertTrue(testClass.isUnique(""));
    assertTrue(testClass.isUnique(null));
    assertTrue(testClass.isUnique("abc"));

    assertFalse(testClass.isUnique("aa"));
    assertFalse(testClass.isUnique("aba"));
  }

  @Test(dataProvider = "arraysandstrings", dataProviderClass = CtciDataProviders.class)
  public void testUrlify(ArraysAndStrings testClass) {
    char[] ch = "a b c    ".toCharArray();
    testClass.urlIfy(ch, 5);
    assertEquals(String.valueOf(ch), "a%20b%20c");

    ch = "         ".toCharArray();
    testClass.urlIfy(ch, 3);
    assertEquals(String.valueOf(ch), "%20%20%20");
  }

  @Test(dataProvider = "arraysandstrings", dataProviderClass = CtciDataProviders.class)
  public void testIsPalindromePermutation(ArraysAndStrings testClass) {
    assertTrue(testClass.isPalindromePermutation("taco act"));
    assertTrue(testClass.isPalindromePermutation("tacoact"));
    assertTrue(testClass.isPalindromePermutation("abAB"));
    assertTrue(testClass.isPalindromePermutation(null));
    assertTrue(testClass.isPalindromePermutation(""));
    assertTrue(testClass.isPalindromePermutation("a"));
    assertTrue(testClass.isPalindromePermutation("a "));

    assertFalse(testClass.isPalindromePermutation("ab"));
    assertFalse(testClass.isPalindromePermutation("abc"));
    assertFalse(testClass.isPalindromePermutation(" ab "));
    assertFalse(testClass.isPalindromePermutation("abc"));
  }

  @Test(dataProvider = "arraysandstrings", dataProviderClass = CtciDataProviders.class)
  public void testIsOneEditAway(ArraysAndStrings testClass) {
    assertTrue(testClass.isOneEditAway("a", "ab"));
    assertTrue(testClass.isOneEditAway("ab", "a"));
    assertTrue(testClass.isOneEditAway("ab", "acb"));
    assertTrue(testClass.isOneEditAway("ab", "cab"));
    assertTrue(testClass.isOneEditAway("ab", "abc"));
    assertTrue(testClass.isOneEditAway("ab", "ab"));
    assertTrue(testClass.isOneEditAway("abc", "adc"));

    assertFalse(testClass.isOneEditAway("abcd", "ab"));
    assertFalse(testClass.isOneEditAway("ab", "cd"));
    assertFalse(testClass.isOneEditAway("abc", "acb"));
  }

  @Test(dataProvider = "arraysandstrings", dataProviderClass = CtciDataProviders.class)
  public void testCompressedString(ArraysAndStrings testClass) {
    assertEquals(testClass.compressedString("aaabb"), "a3b2");
    assertEquals(testClass.compressedString("aabb"), "aabb");
    assertEquals(testClass.compressedString("aaa"), "a3");
    assertEquals(testClass.compressedString("aa"), "aa");
    assertEquals(testClass.compressedString("aab"), "aab");
    assertEquals(testClass.compressedString("aaabbaa"), "a3b2a2");
    assertEquals(testClass.compressedString("aaaab"), "a4b1");
    assertEquals(testClass.compressedString("abbbb"), "a1b4");
  }

  @Test(dataProvider = "arraysandstrings", dataProviderClass = CtciDataProviders.class)
  public void testZeroMatrix(ArraysAndStrings testClass) {
    final int[][] matrix = {
        {0, 1, 2, 3, 4},
        {5, 6, 7, 8, 9},
        {10, 11, 12, 13, 14},
        {15, 16, 17, 18, 19}
    };

    int[][] testMatrix = clone(matrix);
    testClass.zeroMatrix(testMatrix);
    super.assertEquals(testMatrix, new int[][] { {0, 0, 0, 0, 0}, {0, 6, 7, 8, 9}, {0, 11, 12, 13, 14}, {0, 16, 17, 18, 19} });

    testMatrix = clone(matrix);
    Arrays.fill(testMatrix[0], 0);
    testClass.zeroMatrix(testMatrix);
    super.assertEquals(testMatrix, new int[][] { {0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}});

    testMatrix = clone(matrix);
    for (int i = 0; i < testMatrix.length; i++) testMatrix[i][0] = 0;
    testClass.zeroMatrix(testMatrix);
    super.assertEquals(testMatrix, new int[][] { {0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}});

    testMatrix = clone(matrix);
    testMatrix[0][0] = 100;
    testMatrix[1][1] = 0;
    testClass.zeroMatrix(testMatrix);
    super.assertEquals(testMatrix, new int[][] { {100, 0, 2, 3, 4}, {0, 0, 0, 0, 0}, {10, 0, 12, 13, 14}, {15, 0, 17, 18, 19}});
  }

  @Test(dataProvider = "arraysandstrings", dataProviderClass = CtciDataProviders.class)
  public void testIsRotation(ArraysAndStrings testClass) {
    assertTrue(testClass.isRotation("waterbottle", "erbottlewat"));
    assertTrue(testClass.isRotation("waterbottle", "waterbottle"));
    assertTrue(testClass.isRotation("waterbottle", "ewaterbottl"));
    assertTrue(testClass.isRotation("waterbottle", "aterbottlew"));

    assertFalse(testClass.isRotation("waterbottle", "ttlewaterba"));
  }
}
