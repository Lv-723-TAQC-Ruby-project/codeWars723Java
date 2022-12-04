package com.org.ita.kata.implementation.LypskyiOleksandr;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Eight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EightImpl extends BaseKata implements Eight {
    @Override
    public int liters(double time) {
        return (int) (time * 0.5);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        return Float.parseFloat(String.format(Locale.US, "%.2f", mpg * 1.609344 / 4.54609188));
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        int[] arrayToReturn = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if ((int) Math.sqrt(array[i]) == Math.sqrt(array[i])) {
                arrayToReturn[i] = (int) Math.sqrt(array[i]);
            } else {
                arrayToReturn[i] = (int) Math.pow(array[i], 2);
            }
        }
        return arrayToReturn;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {

        if ((input == null) || (input.length == 0)) {
            System.out.println("empty");
            return new int[]{};
        }

        int positiveNumbers = 0;
        int negativeNumbersSum = 0;

        for (int i : input) {
            if (i > 0) {
                positiveNumbers++;
            } else {
                negativeNumbersSum += i;
            }
        }
        return new int[]{positiveNumbers, negativeNumbersSum};
    }

    @Override
    public int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    @Override
    public boolean amIWilson(double n) {
        return n == 5 || n == 13 || n == 563;
    }

    @Override
    public double twoDecimalPlaces(double number) {
        return BigDecimal.valueOf(number).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i : numbers) {
            if (i % divider == 0) {
                list.add(i);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
