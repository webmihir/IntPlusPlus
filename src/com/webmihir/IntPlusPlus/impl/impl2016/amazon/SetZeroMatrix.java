package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * https://discuss.leetcode.com/category/81
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class SetZeroMatrix {
  public void setZeroes(int[][] matrix) {
    if (matrix == null || matrix.length == 0) return;

    boolean firstRowZero = false, firstColZero = false;

    //Check first col
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        firstColZero = true;
        break;
      }
    }

    //Check first row
    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        firstRowZero = true;
        break;
      }
    }

    //Set first row & col 0 for a row/col that has 0
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    //Set 0 for rows or columns with 0
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[i].length; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    //Check first row
    if (firstRowZero) {
      for (int i = 0; i < matrix[0].length; i++) matrix[0][i] = 0;
    }

    //Check first col
    if (firstColZero) {
      for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
    }
  }
}
