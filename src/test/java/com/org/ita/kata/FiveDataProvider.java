package com.org.ita.kata;

import org.testng.annotations.DataProvider;

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
}
