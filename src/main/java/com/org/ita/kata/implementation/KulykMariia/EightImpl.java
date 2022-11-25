package com.org.ita.kata.implementation.KulykMariia;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Eight;
import java.util.Arrays;

public class EightImpl extends BaseKata implements Eight {
    @Override
    public int liters(double time) {
        double result = time * 0.5;
        return (int) result;
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        double volume = length * width * height;
        return volume;
    }

    @Override
    public float mpgToKPM(float mpg) {
        double formula = mpg * (1.609344 / 4.54609188);
        return (float) formula;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int sqrt = (int) Math.sqrt(array[i]);
            array[i] = (sqrt * sqrt == array[i]) ? sqrt : array[i] * array[i];
        }
        return array;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        int positive = 0;
        int negative = 0;
        if (input == null) {
            System.out.println("It is empty array!");
        } else {
            for (int i : input) {
                if (i > 0) {
                    positive += 1;
                } else negative += i;
            }
        }
        int[] list = {positive, negative};
        return list;
    }

    @Override
    public int stringToNumber(String str) {
        return Integer.valueOf(str);
    }

    @Override
    public boolean amIWilson(double n) {
        return n == 13 || n == 5 || n == 563;
    }

    @Override
    public double twoDecimalPlaces(double number) {
        return (Math.round(number * 100)) / 100.0;
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        return Arrays.stream(numbers).filter(number -> number % divider == 0).toArray();
    }
}
