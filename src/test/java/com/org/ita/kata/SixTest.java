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

    @Test(dataProvider = "Floating-point Approximation")
    public void floatingPointApproximationTest(Six impl, double data, double expected){
        double actualResult = impl.f(data);
        Assert.assertEquals(actualResult, expected);
    }
}
