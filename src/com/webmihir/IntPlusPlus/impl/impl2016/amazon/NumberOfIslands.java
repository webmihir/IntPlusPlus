package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

/**
 * 200 (medium): Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 * https://discuss.leetcode.com/category/208
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Answer: 1
 *
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Answer: 3
 */
public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    int islands = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          islands ++;
          explore(i, j, grid);
        }
      }
    }
    return islands;
  }

  private void explore(int r, int c, char[][] grid) {
    if (r < 0 || r >= grid.length) return;
    if (c < 0 || c >= grid[0].length) return;
    if (grid[r][c] == '0') return;
    grid[r][c] = '0';
    explore(r+1, c, grid);
    explore(r, c+1, grid);
    explore(r, c-1, grid);
    explore(r-1, c, grid);
  }
}
