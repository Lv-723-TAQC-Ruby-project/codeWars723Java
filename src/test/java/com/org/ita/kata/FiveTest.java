package com.org.ita.kata;

import com.org.ita.kata.implementation.OmetiukhSofiia.FiveImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigInteger;

public class FiveTest extends FiveDataProvider {

    @Test(dataProvider = "dataArtificialRain")
    public void artificialRain(Five impl, int[] input, int expected) {
        int actual = impl.artificialRain(input);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "Gap in Primes")
    public void gap(Five impl, int g, long m, long n, long[] expected) {
        long[] actual = impl.gap(g, m, n);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataZeros")
    public void zeros(Five impl, int n, int expected) {
        int actual = impl.zeros(n);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataSolveSum")
    public void solveSumTest(Five impl, double m, double expected) {
        double actual = impl.solveSum(m);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataBigIntegerPerimeter")
    public void BigIntegerPerimeterTest(Five impl, BigInteger data, BigInteger expected) {
        BigInteger actual = impl.perimeter(data);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "Find the smallest")
    public void smallestTest(Five impl, long data, long[] expected) {
        long[] actual = impl.smallest(data);
        Assert.assertEquals(actual, expected);
    }


}
