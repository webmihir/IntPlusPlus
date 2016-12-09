package com.webmihir.IntPlusPlus.dataproviders;

import com.webmihir.IntPlusPlus.impl.impl2016.ctci.ArraysAndStringImpl;
import org.testng.annotations.DataProvider;


public class CtciDataProviders {
  @DataProvider(name = "arraysandstrings")
  public static Object[][] getCtciArraysAndString() {
    return new Object[][]{{new ArraysAndStringImpl()}};
  }
}
