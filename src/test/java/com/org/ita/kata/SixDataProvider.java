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

    @DataProvider(name = "Build a pile of Cubes")
    public Object[][] findNbData(){
        Object[][] testData = new Object[][]{
                {4183059834009L,2022 },
                {24723578342962L,-1},
                {135440716410000L,4824},
                {40539911473216L, 3568}
        };
        return combineImplWithTests(SIX_IMPL, testData);
    }
}
