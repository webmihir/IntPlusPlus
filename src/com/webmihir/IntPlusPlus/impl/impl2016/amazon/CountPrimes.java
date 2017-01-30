package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

/**
 * 204 (easy): Count Primes
 * https://leetcode.com/problems/count-primes/
 * https://discuss.leetcode.com/category/212
 *
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {
  public int countPrimes(int n) {
    if (n <= 2) return 0;

    boolean[] isNotPrime = new boolean[n];
    isNotPrime[0] = isNotPrime[1] = true;

    for (int i = 2; i * 2 < n; i++) {
      if (isNotPrime[i]) continue;
      for (int j = i*2; j < n; j+=i) {
        isNotPrime[j] = true;
      }
    }
    int c = 0;
    int i = 0;
    for (boolean b : isNotPrime) {
      if (!b) c++;
    }
    return c;
  }
}
