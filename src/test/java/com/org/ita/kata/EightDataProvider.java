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
                {5.5, 2}
        };
        return combineImplWithTests(EIGHTS_IMPL, testData);

    }


    @DataProvider(name = "Volume of a Cuboid")
    public Object[][] getVolumeOfCuboid() {
        Object[][] testData = new Object[][]{
                {1, 2, 2, 4},
                {6.3, 2, 5, 63}
        };
        return combineImplWithTests(EIGHTS_IMPL, testData);
    }


    @DataProvider(name = "dataAmIWilson")
    public Object[][] amIWilsonData() {
        Object[][] testData = new Object[][]{
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

    @DataProvider(name = "twoDecimalPlaces")
    public Object[][] twoDecimalPlaces() {
        Object[][] testData = new Object[][]{
                {4.659725356, 4.66},
                {173735326.3783732637948948, 173735326.38},
        };
        return combineImplWithTests(EIGHTS_IMPL, testData);
    }


    @DataProvider(name = "dataSquareOrSquareRoot")
    public Object[][] squareOrSquareRootTest() {
        int[][][] testData = new int[][][]{
                {{4, 3, 9, 7, 2, 1}, {2, 9, 3, 49, 4, 1}},
                {{100, 101, 5, 5, 1, 1}, {10, 10201, 25, 25, 1, 1}},
                {{1, 2, 3, 4, 5, 6}, {1, 4, 9, 2, 25, 36}},
        };
        return combineImplWithTests(EIGHTS_IMPL, testData);
    }

    @DataProvider(name = "dataStringToNumber")
    public Object[][] StringToNumberData() {
        Object[][] test = new Object[][]{
                {"2022", 2022},
                {"11", 11},
                {"-5", -5}
        };
        return combineImplWithTests(EIGHTS_IMPL, test);
    }


    @DataProvider(name = "dataMpgToKPM")
    public Object[][] mpgToKPM() {
        Object[][] testData = new Object[][]{
                {10, 3.54f},
                {20, 7.08f},
                {30, 10.62f},
        };
        return combineImplWithTests(EIGHTS_IMPL, testData);
    }

    @DataProvider(name = "dataCountPositivesSumNegatives")
    public Object[][] countPositivesSumNegatives() {
        Object[][] testData = new Object[][]{
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15}, new int[]{10, -65}},
                {new int[]{0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14}, new int[]{8, -50}}
        };
        return combineImplWithTests(EIGHTS_IMPL, testData);
    }

    @DataProvider(name = "dataDivisibleBy")
    public Object[][] divisibleByData() {
        Object[][] testData = new Object[][]{
                {new int[]{1, 2, 3, 4, 5, 6}, 2, new int[]{2, 4, 6}},
                {new int[]{1, 2, 3, 4, 5, 6}, 3, new int[]{3, 6}},
                {new int[]{0, 1, 2, 3, 4, 5, 6}, 4, new int[]{0, 4}},
                {new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}},
                {new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 17, new int[]{0}}
        };
        return combineImplWithTests(EIGHTS_IMPL, testData);
    }

}
