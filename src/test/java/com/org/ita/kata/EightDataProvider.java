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
}
