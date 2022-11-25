package com.org.ita.kata.implementation.KhudoBohdan;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Eight;

import java.util.ArrayList;

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
        double kpl = (mpg * 1.609344) / 4.54609188;
        return Float.parseFloat(String.format("%.2f", kpl));
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int sqrt = (int) Math.sqrt(array[i]);
            if (sqrt * sqrt == array[i]) {
                result[i] = sqrt;
            } else {
                result[i] = array[i] * array[i];
            }
        }

        return result;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) {
            return new int[]{};
        }
        int[] result = new int[]{0, 0};

        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0) {
                result[0]++;
            } else if (input[i] < 0) {
                result[1] += input[i];
            }

        }

        return result;
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
        return Double.parseDouble(String.format("%.2f", number));
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % divider == 0) {
                arr.add(numbers[i]);
            }
        }

        int[] result = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }

        return result;
    }
}
