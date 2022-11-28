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
<<<<<<< HEAD
    @Test(dataProvider = "nbaCup")
    public void nbaCup(Six impl,String testData, String expected) {
        String actual = impl.nbaCup(resultSheet3,testData);
        Assert.assertEquals(actual,expected);
    }
=======
    @Test(dataProvider = "dataBalanceCheck")
    public void balanceTest(Six impl, String data, String expected) {
        String actual = impl.balance(data);
        Assert.assertEquals(actual, expected);
    }

>>>>>>> ebe75a2a70bafed249171ebae612d43bfae50c06
}
