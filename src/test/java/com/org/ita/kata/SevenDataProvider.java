package com.org.ita.kata;

import org.testng.annotations.DataProvider;

public class SevenDataProvider extends BaseDataProvider{

    @DataProvider(name = "Sum of the first nth term of Series")
    public Object[][] seriesSum(){
        Object[][]testData = new Object[][]{
                {5, "1.57"},
                {9, "1.77"},
                {15, "1.94"}
        };
        return combineImplWithTests(SEVEN_IMPL, testData);
    }

    @DataProvider(name = "dataWhereIsHe")
    public Object[][] whereIsHe(){
        Object[][]testData = new Object[][]{
                {3, 1, 1, 2},
                {5, 2, 3, 3}
        };
        return combineImplWithTests(SEVEN_IMPL, testData);
    }
}
