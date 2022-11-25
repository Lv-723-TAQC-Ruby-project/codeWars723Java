package com.org.ita.kata;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EightTest extends EightDataProvider{

    @Test(dataProvider =  "dataLiters")
    public void litersTest(Eight impl, double data, int expected) {
        double actual = impl.liters(data);
        Assert.assertEquals(actual, expected);
    }

}
