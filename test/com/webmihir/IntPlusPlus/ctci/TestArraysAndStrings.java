package com.webmihir.IntPlusPlus.ctci;

import com.webmihir.IntPlusPlus.BaseTest;
import com.webmihir.IntPlusPlus.dataproviders.CtciDataProviders;
import com.webmihir.IntPlusPlus.interfaces.ctci.ArraysAndStrings;
import java.util.Arrays;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


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
  public void testRotateMatrix(ArraysAndStrings testClass) {
    int[][] matrix =
        {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}, {31, 32, 33, 34, 35, 36}};
    testClass.rotateMatrix(matrix);
    super.assertEquals(matrix,
        new int[][]{{31, 25, 19, 13, 7, 1}, {32, 26, 20, 14, 8, 2}, {33, 27, 21, 15, 9, 3}, {34, 28, 22, 16, 10, 4}, {35, 29, 23, 17, 11, 5}, {36, 30, 24, 18, 12, 6}});

    matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    testClass.rotateMatrix(matrix);
    super.assertEquals(matrix, new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}});

    matrix = new int[][]{{1, 2}, {3, 4}};
    testClass.rotateMatrix(matrix);
    super.assertEquals(matrix, new int[][]{{3, 1}, {4, 2}});

    matrix = new int[][]{{1}};
    testClass.rotateMatrix(matrix);
    super.assertEquals(matrix, new int[][]{{1}});
  }

  @Test(dataProvider = "arraysandstrings", dataProviderClass = CtciDataProviders.class)
  public void testZeroMatrix(ArraysAndStrings testClass) {
    final int[][] matrix = {{0, 1, 2, 3, 4}, {5, 6, 7, 8, 9}, {10, 11, 12, 13, 14}, {15, 16, 17, 18, 19}};

    int[][] testMatrix = clone(matrix);
    testClass.zeroMatrix(testMatrix);
    super.assertEquals(testMatrix,
        new int[][]{{0, 0, 0, 0, 0}, {0, 6, 7, 8, 9}, {0, 11, 12, 13, 14}, {0, 16, 17, 18, 19}});

    testMatrix = clone(matrix);
    Arrays.fill(testMatrix[0], 0);
    testClass.zeroMatrix(testMatrix);
    super.assertEquals(testMatrix, new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}});

    testMatrix = clone(matrix);
    for (int i = 0; i < testMatrix.length; i++) {
      testMatrix[i][0] = 0;
    }
    testClass.zeroMatrix(testMatrix);
    super.assertEquals(testMatrix, new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}});

    testMatrix = clone(matrix);
    testMatrix[0][0] = 100;
    testMatrix[1][1] = 0;
    testClass.zeroMatrix(testMatrix);
    super.assertEquals(testMatrix,
        new int[][]{{100, 0, 2, 3, 4}, {0, 0, 0, 0, 0}, {10, 0, 12, 13, 14}, {15, 0, 17, 18, 19}});
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
