package com.org.ita.kata.implementation.StanislavKovalov;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Eight;

import java.util.Locale;

public class EightImpl extends BaseKata implements Eight{
    @Override
    public int liters(double time) {
        return (int) (time*0.5);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        return (float) Math.round(100 * mpg * 1.609344 / 4.54609188) / 100;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        for(int i = 0; i < array.length; i++) {
            if (Math.sqrt(array[i]) % 1 == 0) {
                array[i] = (int) Math.sqrt(array[i]);
            }
            else{
                array[i] *= array[i];
            }
        }
        return array;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) return new int[]{};
        int count = 0, sum = 0;
        for (int i : input) {
            if (i > 0) count++;
            if (i < 0) sum = sum + i;
        }
        return new int[]{count, sum};
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
        return Double.parseDouble(String.format(Locale.US,"%.2f", number));
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        int count = 0;
        for (int number : numbers) {
            if (number % divider == 0) {
                count++;
            }
        }
        int[] arr = new int [count];
        int a = 0;
        for (int number : numbers) {
            if (number % divider == 0) {
                arr[a] = number;
                a++;
            }
        }
        return arr;
    }
}
