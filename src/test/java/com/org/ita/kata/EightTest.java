package com.org.ita.kata;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EightTest extends EightDataProvider {

    @Test(dataProvider = "dataLiters")
    public void litersTest(Eight impl, double data, int expected) {
        double actual = impl.liters(data);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "Volume of a Cuboid")
    public void getVolumeOfCuboid(Eight impl, double length, double width, double height, int expected) {
        double actual = impl.getVolumeOfCuboid(length, width, height);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataAmIWilson")
    public void amIWilsonTest(Eight impl, double data, boolean expected) {
        boolean actual = impl.amIWilson(data);
        Assert.assertEquals(actual, expected);
    }
    @Test(dataProvider = "twoDecimalPlaces")
    public void twoDecimalPlacesTest(Eight impl, double data, double expected) {
        double actual = impl.twoDecimalPlaces(data);
        Assert.assertEquals(actual, expected);
    }
    @Test(dataProvider = "squareOrSquareRoot" )
    public void squareOrSquareRoot(Eight impl, int [] data, int[] expected){
        int [] actual = impl.squareOrSquareRoot(data);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataStringToNumber")
    public void stringToNumber(Eight impl, String data, int expected) {
        int actual = impl.stringToNumber(data);
        Assert.assertEquals(actual, expected);
    }
    @Test(dataProvider = "dataMpgToKPM")
    public void mpgToKPM(Eight impl, float mpg, float expected) {
        float actual = impl.mpgToKPM(mpg);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataCountPositivesSumNegatives")
    public void countPositivesSumNegatives(Eight impl, int[] input, int[] expected) {
        int[] actual = impl.countPositivesSumNegatives(input);
        Assert.assertEquals(actual, expected);
    }
}
