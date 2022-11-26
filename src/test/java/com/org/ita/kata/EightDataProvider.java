package com.org.ita.kata;

import org.testng.annotations.DataProvider;

public class EightDataProvider extends BaseDataProvider {
    @DataProvider(name = "dataLiters")
    public Object[][] litersData() {
        Object[][] testData = new Object[][]{
                {2, 1},
                {1, 0},
                {10, 5},
                {1.4, 0},
                {12.3, 6},
                {0.82, 0},
                {11.8, 5},
                {1787, 893},
                {0, 0},
                {5.5, 2},
                {-500.00, 0},
                {-1, 0}
        };
        return combineImplWithTests(EIGHTS_IMPL, testData);

    }
    @DataProvider(name = "dataAmIWilson")
    public Object[][] amIWilsonData() {
        Object[][] testData = new Object[][] {
                {5, true},
                {13, true},
                {563, true},
                {45, false},
                {-89, false},
                {568, false},
                {0, false}
        };
        return combineImplWithTests(EIGHTS_IMPL, testData);
    }
    @DataProvider (name = "dataStringToNumber")
    public Object [][] StringToNumberData() {
        Object [][] test = new Object[][] {
                {"2022", 2022},
                {"11", 11},
                {"-5", -5}
        };
        return combineImplWithTests(EIGHTS_IMPL, test);
    }

}
