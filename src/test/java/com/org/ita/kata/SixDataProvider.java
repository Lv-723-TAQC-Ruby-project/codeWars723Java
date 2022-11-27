package com.org.ita.kata;

import org.testng.annotations.DataProvider;

public class SixDataProvider extends BaseDataProvider{
    @DataProvider(name = "Rainfall -> mean")
    public Object[][] meanRainfallData() {
        Object[][] testData = new Object[][]{
                {"London", 51.199999999999996},
                {"Beijing", 52.416666666666664}
        };
        return combineImplWithTests(SIX_IMPL, testData);
    }
    @DataProvider(name = "Rainfall -> variance")
    public Object[][] varianceRainfallData() {
        Object[][] testData = new Object[][]{
                {"London", 57.42833333333374},
                {"Beijing", 4808.37138888889}
        };
        return combineImplWithTests(SIX_IMPL, testData);
    }

    @DataProvider(name = "Floating-point Approximation")
    public Object [][] testFloatingPointApproximation(){
        Object [][] dataTest = new Object[][]{
                {2.6e-08, 1.29999999155e-08},
                {1.4e-09, 6.999999997549999e-10},
                {5.0e-06, 2.499996875007812e-06},
                {2.4e-07, 1.1999999280000085e-07}
        };
        return combineImplWithTests(SIX_IMPL, dataTest);
    }
}
