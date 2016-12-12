package com.webmihir.IntPlusPlus.dataproviders;

import com.webmihir.IntPlusPlus.impl.impl2016.ctci.ArraysAndStringImpl;
import com.webmihir.IntPlusPlus.impl.impl2016.ctci.LinkedListsImpl;
import com.webmihir.IntPlusPlus.interfaces.ctci.ArraysAndStrings;
import com.webmihir.IntPlusPlus.interfaces.ctci.LinkedLists;
import org.testng.annotations.DataProvider;


public class CtciDataProviders {
  private static final ArraysAndStrings arraysAndStrings = new ArraysAndStringImpl();
  private static final LinkedLists linkedLists = new LinkedListsImpl();

  @DataProvider(name = "arraysandstrings")
  public static Object[][] getCtciArraysAndString() {
    return new Object[][]{{arraysAndStrings}};
  }

  @DataProvider(name = "linkedlists")
  public static Object[][] getCtciLinkedLists() {
    return new Object[][]{{linkedLists}};
  }
}
