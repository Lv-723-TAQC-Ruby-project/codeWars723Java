package com.org.ita.kata;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SixTest extends SixDataProvider{

    @Test(dataProvider = "Rainfall -> mean")
    public void meanTest(Six impl, String testData, double expected) {
        double actual = impl.mean(testData,data);
        Assert.assertEquals(actual, expected);
    }
    @Test(dataProvider = "Rainfall -> variance")
    public void varianceTest(Six impl, String testData, double expected) {
        double actual = impl.variance(testData, data);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "nbaCup")
    public void nbaCup(Six impl,String nbaData, String expected) {
        String actual = impl.nbaCup(resultSheet3,nbaData);
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "dataBalanceCheck")
    public void balanceTest(Six impl, String data, String expected) {
        String actual = impl.balance(data);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "Build a pile of Cubes")
    public void findNbTest (Six impl, long data, long expected) {
        long actual = impl.findNb(data);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataStockSummary")
    public void stockSummary(Six impl, String[] lstOfArt, String[] lstOf1stLetter, String expected) {
        String actual = impl.stockSummary(lstOfArt, lstOf1stLetter);
        Assert.assertEquals(actual, expected);
    }


}
