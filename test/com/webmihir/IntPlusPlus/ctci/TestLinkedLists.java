package com.webmihir.IntPlusPlus.ctci;

import com.webmihir.IntPlusPlus.BaseTest;
import com.webmihir.IntPlusPlus.dataproviders.CtciDataProviders;
import com.webmihir.IntPlusPlus.interfaces.common.ListNode;
import com.webmihir.IntPlusPlus.interfaces.ctci.LinkedLists;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class TestLinkedLists extends BaseTest {
  @Test(dataProvider = "linkedlists", dataProviderClass = CtciDataProviders.class)
  public void testRemoveDupes(LinkedLists testClass) {
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(1))));
    testClass.removeDupes(head);
    assertEquals(head.val, 1);
    assertEquals(head.next.val, 2);
    assertEquals(head.next.next.val, 3);
    assertTrue(head.next.next.next == null);
  }

  @Test(dataProvider = "linkedlists", dataProviderClass = CtciDataProviders.class)
  public void testKthToLast(LinkedLists testClass) {
    //1 -> 2 -> 3
    ListNode head = createList(1, 2, 3);
    assertEquals(testClass.kthToLast(head, 1).val, 3);
    assertEquals(testClass.kthToLast(head, 2).val, 2);
    assertEquals(testClass.kthToLast(head, 3).val, 1);
    assertTrue(testClass.kthToLast(head, 4) == null);
  }

  @Test(dataProvider = "linkedlists", dataProviderClass = CtciDataProviders.class)
  public void testDeleteMiddleNode(LinkedLists testClass) {
    //1 -> 2 -> 3 -> 4
    ListNode mid = new ListNode(2, new ListNode(3, new ListNode(4)));
    ListNode head = new ListNode(1, mid);

    testClass.deleteMiddleNode(mid);
    assertEquals(head.val, 1);
    assertEquals(head.next.val, 3);
    assertEquals(head.next.next.val, 4);
    assertTrue(head.next.next.next == null);
  }

  @Test(dataProvider = "linkedlists", dataProviderClass = CtciDataProviders.class)
  public void testPartitionList(LinkedLists testClass) {
    //TODO: add validators for the returned list

    ListNode head = createList(3, 5, 8, 5, 10, 2, 1);
    ListNode partitioned = testClass.partitionList(head, 5);
    printList(partitioned);

    head = createList(3, 5, 8, 5, 10, 2, 1);
    partitioned = testClass.partitionList(head, 10);
    printList(partitioned);

    head = createList(3, 5, 8, 5, 10, 2, 1);
    partitioned = testClass.partitionList(head, 1);
    printList(partitioned);

    head = createList(3, 5, 8, 5, 10, 2, 1);
    partitioned = testClass.partitionList(head, 0);
    printList(partitioned);
  }

  @Test(dataProvider = "linkedlists", dataProviderClass = CtciDataProviders.class)
  public void testSumLists(LinkedLists testClass) {
    //Simple case
    ListNode l1 = createList(7, 1, 6);
    ListNode l2 = createList(5, 9, 2);
    ListNode exp = createList(2, 1, 9);
    assertEquals(testClass.sumLists(l1, l2), exp);

    //l1 bigger than l2
    l1 = createList(7, 1, 6);
    l2 = createList(9, 2);
    exp = createList(6, 4, 6);
    assertEquals(testClass.sumLists(l1, l2), exp);

    //l2 bigger than l1, with carry
    l1 = createList(9, 2);
    l2 = createList(2, 9, 9);
    exp = createList(1, 2, 0, 1);
    assertEquals(testClass.sumLists(l1, l2), exp);
  }

  //@Test(dataProvider = "linkedlists", dataProviderClass = CtciDataProviders.class)
  public void testSumLists2(LinkedLists testClass) {
    //Simple case
    ListNode l1 = createList(6, 1, 7);
    ListNode l2 = createList(2, 9, 5);
    ListNode exp = createList(9, 1, 2);
    assertEquals(testClass.sumLists(l1, l2), exp);

    //l1 bigger than l2
    l1 = createList(6, 1, 7);
    l2 = createList(2, 9);
    exp = createList(6, 4, 6);
    assertEquals(testClass.sumLists(l1, l2), exp);

    //l2 bigger than l1, with carry
    l1 = createList(2, 9);
    l2 = createList(9, 9, 2);
    exp = createList(1, 0, 2, 1);
    assertEquals(testClass.sumLists(l1, l2), exp);
  }

  @Test(dataProvider = "linkedlists", dataProviderClass = CtciDataProviders.class)
  public void testIsPalindrome(LinkedLists testClass) {
    ListNode l1 = createList(1);
    assertTrue(testClass.isPalindrome(l1));
    l1 = createList(1, 1);
    assertTrue(testClass.isPalindrome(l1));
    l1 = createList(1, 2, 1);
    assertTrue(testClass.isPalindrome(l1));
    l1 = createList(1, 2, 2, 1);
    assertTrue(testClass.isPalindrome(l1));
    l1 = createList(1, 2, 3, 2, 1);
    assertTrue(testClass.isPalindrome(l1));
    l1 = createList(1, 2, 3, 3, 2, 1);
    assertTrue(testClass.isPalindrome(l1));

    l1 = createList(1, 2);
    assertFalse(testClass.isPalindrome(l1));
    l1 = createList(1, 2, 2);
    assertFalse(testClass.isPalindrome(l1));
    l1 = createList(1, 2, 1, 2);
    assertFalse(testClass.isPalindrome(l1));
    l1 = createList(1, 2, 3, 1, 2);
    assertFalse(testClass.isPalindrome(l1));
    l1 = createList(1, 2, 3, 3, 2, 0);
    assertFalse(testClass.isPalindrome(l1));
  }

  @Test(dataProvider = "linkedlists", dataProviderClass = CtciDataProviders.class)
  public void testFindIntersection(LinkedLists testClass) {
    ListNode intersection = createList(5, 6, 7);

    //Same size lists
    ListNode l1 = createList(1, 2, 3, 4);
    tail(l1).next = intersection;
    ListNode l2 = createList(1, 2, 3, 4);
    tail(l2).next = intersection;
    assertEquals(testClass.findIntersection(l1, l2), intersection);

    //first list smaller than second list
    l1 = createList(1);
    l1.next = intersection;
    l2 = createList(1, 2);
    tail(l2).next = intersection;
    assertEquals(testClass.findIntersection(l1, l2), intersection);
    assertEquals(testClass.findIntersection(l2, l1), intersection);//second list smaller than first list

    //Intersection at head
    assertEquals(testClass.findIntersection(intersection, intersection), intersection);

    //Intersection at tail
    intersection = createList(100);
    l1 = createList(1, 2, 3);
    tail(l1).next = intersection;
    l2 = createList(1, 2, 3);
    tail(l2).next = intersection;
    assertEquals(testClass.findIntersection(l1, l2), intersection);

    //No intersection with same lengths
    l1 = createList(1, 2, 3);
    l2 = createList(1, 2, 3);
    assertTrue(testClass.findIntersection(l1, l2) == null);

    //No Intersection with first list bigger than second list
    tail(l1).next = createList(4, 5, 6);
    assertTrue(testClass.findIntersection(l1, l2) == null);

    //No Intersection with second list bigger than first list
    assertTrue(testClass.findIntersection(l2, l1) == null);
  }

  @Test(dataProvider = "linkedlists", dataProviderClass = CtciDataProviders.class)
  public void testFindLoop(LinkedLists testClass) {
    //Loop at head
    ListNode l1 = createList(1, 2, 3);
    tail(l1).next = l1;
    assertEquals(testClass.findLoop(l1), l1, true);

    //Loop at 2nd node
    l1 = createList(1, 2, 3);
    tail(l1).next = l1.next;
    assertEquals(testClass.findLoop(l1), l1.next, true);

    //Loop at 3rd node
    l1 = createList(1, 2, 3);
    ListNode tail = tail(l1);
    tail.next = tail;
    assertEquals(testClass.findLoop(l1), tail, true);

    //Single node loop
    l1 = createList(1);
    l1.next = l1;
    assertEquals(testClass.findLoop(l1), l1, true);

    //No loop
    l1 = createList(1, 2, 3, 4);
    assertTrue(testClass.findLoop(l1) == null);
    l1 = createList(1, 2, 3);
    assertTrue(testClass.findLoop(l1) == null);
    l1 = createList(1);
    assertTrue(testClass.findLoop(l1) == null);
    assertTrue(testClass.findLoop(null) == null);
  }
}