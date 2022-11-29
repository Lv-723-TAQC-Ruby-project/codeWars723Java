package com.org.ita.kata;

import org.testng.annotations.DataProvider;

import java.math.BigInteger;

public class FiveDataProvider extends BaseDataProvider{

    @DataProvider(name = "Gap in Primes")
    public Object[][] gap(){
        Object[][] testData = new Object[][] {
                {2,100,110, new long[]{101, 103}},
                {4,100,110, new long[]{103, 107}},
                {6,100,110, null},
                {8,300,400, new long[]{359, 367}},
                {10,300,400, new long[]{337, 347}}
        };
    return combineImplWithTests(FIVE_IMPL, testData);
    }

    @DataProvider(name = "dataZeros")
    public Object[][] zeros(){
        Object[][] testData = new Object[][] {
                {0, 0},
                {6, 1},
                {14, 2}
        };
        return combineImplWithTests(FIVE_IMPL, testData);
    }

    @DataProvider(name = "dataSolveSum")
    public Object[][] solveSumData(){
        Object[][] testData = new Object[][] {
                {2.00, 5.000000000000e-01},
                {4.00, 6.096117967978e-01},
                {5.00, 6.417424305044e-01}
        };
        return combineImplWithTests(FIVE_IMPL, testData);
    }

    @DataProvider(name = "dataBigIntegerPerimeter")
    public Object[][] perimeterData(){
        BigInteger[][] testData = new BigInteger[][]{
                {BigInteger.valueOf(5), BigInteger.valueOf(80)},
                {BigInteger.valueOf(7), BigInteger.valueOf(216)},
                {BigInteger.valueOf(30), BigInteger.valueOf(14098308)}
        };
        return combineImplWithTests(FIVE_IMPL,testData);
    }

}
