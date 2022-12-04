package com.org.ita.kata;

import org.testng.annotations.DataProvider;

public class SevenDataProvider extends BaseDataProvider {

    @DataProvider(name = "dataLookingForABenefactor")
    public Object[][] newAvg() {
        Object[][] testData = new Object[][]{

                {new double[]{14, 30, 5, 7, 9, 11, 15}, 92, 645},

                {new double[]{14.0, 30.0, 5.0, 7.0, 9.0, 11.0, 16.0}, 90, 628},
                {new double[]{14, 30, 5, 7, 9, 11, 15}, 92, 645}
        };
        return combineImplWithTests(SEVEN_IMPL, testData);
    }

    @DataProvider(name = "dataLookingForAIllegalArgumentException")
    public Object[][] newAvgException() {
        Object[][] testData = new Object[][]{

                {new double[]{14, 30, 5, 7, 9, 11, 15}, 2}
        };
        return combineImplWithTests(SEVEN_IMPL, testData);
    }

    @DataProvider(name = "Sum of the first nth term of Series")
    public Object[][] seriesSum() {
        Object[][] testData = new Object[][]{
                {5, "1.57"},
                {9, "1.77"},
                {15, "1.94"}
        };
        return combineImplWithTests(SEVEN_IMPL, testData);
    }

    @DataProvider(name = "dataWhereIsHe")
    public Object[][] whereIsHe() {
        Object[][] testData = new Object[][]{
                {3, 1, 1, 2},
                {5, 2, 3, 3}
        };
        return combineImplWithTests(SEVEN_IMPL, testData);
    }
}
