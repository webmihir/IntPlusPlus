package com.webmihir.IntPlusPlus;

import com.webmihir.IntPlusPlus.interfaces.common.ListNode;
import org.testng.Assert;

import static org.testng.Assert.*;


public class BaseTest {
  /*@BeforeMethod
  public void beforeTest(Method m) throws Exception {
    String testMethod = m.getName();
    String prodMethod = Character.toLowerCase(testMethod.charAt(4)) + testMethod.substring(5);
    //System.out.println("Before Test " + prodMethod);
    if (m.getParameterCount() > 0) {
      Parameter p = m.getParameters()[0];
      Object o = p.getClass().newInstance();// p.getType().newInstance();
      Method method = null;
      for (Method m1 : p.getType().getMethods()) {
        if (m1.getName().equals(prodMethod)) {
          method = m1;
          break;
        }
      }

      if (method != null) {
        try {
          method.invoke(o, null);
        } catch (NotImplementedException ex) {
          throw new SkipException("Skipping Test: " + testMethod);
        }
      }
    }
  }*/

  protected void assertEquals(int[][] actual, int[][] expected) {
    Assert.assertEquals(expected.length, actual.length,
        "Expected array has " + expected.length + " rows, Actual has " + actual.length + " rows.");
    Assert.assertEquals(expected[0].length, actual[0].length,
        "Expected array has " + expected[0].length + " cols, Actual has " + actual[0].length + " cols.");

    for (int i = 0; i < expected.length; i++) {
      for (int j = 0; j < expected[0].length; j++) {
        Assert.assertEquals(expected[i][j], actual[i][j],
            "expected[" + i + "][" + j + "]=" + expected[i][j] + ", actual[" + i + "][" + j + "]=" + actual[i][j]);
      }
    }
  }

  protected int[][] clone(int[][] matrix) {
    int[][] arr = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      arr[i] = matrix[i].clone();
    }
    return arr;
  }

  protected void assertEquals(String actual, String expected) {
    Assert.assertEquals(actual, expected);
  }

  protected void assertEquals(int actual, int expected) {
    Assert.assertEquals(actual, expected);
  }

  protected void assertEquals(long actual, long expected) {
    Assert.assertEquals(actual, expected);
  }

  protected void assertEquals(ListNode actual, ListNode expected) {
    ListNode l1 = actual, l2 = expected;

    while (l1 != null && l2 != null) {
      assertEquals(l1.val, l2.val);
      l1 = l1.next;
      l2 = l2.next;
    }

    assertTrue(l1 == null);
    assertTrue(l2 == null);
  }

  protected void assertEquals(ListNode actual, ListNode expected, boolean singleNode) {
    if (singleNode) {
      assertTrue(actual == expected);
    } else {
      assertEquals(actual, expected);
    }
  }

  public void printList(ListNode head) {
    System.out.print("List: ");

    if (head == null) {
      System.out.println("<empty>");
      return;
    }
    System.out.print(head.toString());
    System.out.println();
  }

  protected ListNode createList(int headVal, int... vals) {
    ListNode head = new ListNode(headVal);
    ListNode prev = head;
    for (int val : vals) {
      prev.next = new ListNode(val);
      prev = prev.next;
    }
    return head;
  }

  protected ListNode tail(ListNode head) {
    ListNode cur = head;
    while (cur.next != null) {
      cur = cur.next;
    }
    return cur;
  }
}
