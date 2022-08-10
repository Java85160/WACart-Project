package com.WACart.qa.testdata;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class HomePageTestData {
  @Test(dataProvider = "dp")
  public void f( String s) {
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {"a" },
      new Object[] {"b" },
      new Object[] {"b" },
      new Object[] {"b" },
      new Object[] {"b" },
    };
  }
}
