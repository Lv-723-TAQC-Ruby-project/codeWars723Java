package com.org.ita.kata;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SixTest extends SixDataProvider{

    @Test(dataProvider = "Rainfall -> mean")
    public void meanTest(Six impl, String data, String towns, double expected) {
        double actual = impl.mean(towns, data);
        Assert.assertEquals(actual, expected);
    }
    @Test(dataProvider = "Rainfall -> variance")
    public void varianceTest(Six impl, String data, String towns, double expected) {
        double actual = impl.variance(towns, data);
        Assert.assertEquals(actual, expected);
    }
    @Test(dataProvider = "dataBalanceCheck")
    public void balanceTest(Six impl, String data, String expected) {
        String actual = impl.balance(data);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "Build a pile of Cubes")
    public void findNbTest (Six impl, long data, long expected ){
        long actual = impl.findNb(data);
        Assert.assertEquals(actual, expected);
    }


}
