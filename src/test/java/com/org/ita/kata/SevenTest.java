package com.org.ita.kata;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SevenTest extends SevenDataProvider {

    @Test(dataProvider = "Sum of the first nth term of Series")
    public void seriesSum(Seven impl, int number, String expected) {
        String actual = impl.seriesSum(number);
        Assert.assertEquals(actual, expected);
    }
    @Test(dataProvider = "dataWhereIsHe")
    public void whereIsHe(Seven impl, int p, int bef, int aft, int expected) {
        int actual = impl.whereIsHe(p, bef, aft);
        Assert.assertEquals(actual, expected);
    }


}
