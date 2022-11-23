//package com.org.ita.kata.implementation.OmetiukhSofiia;
package com.org.ita.kata.implementation.OmetiukhSofiia;

import com.org.ita.kata.Eight;

import java.util.Arrays;
//import java.util.stream.*;
//import java.util.List;


public class EightImpl implements Eight {
    @Override
    public int liters(double time) {
        double litres = Math.floor(time * 0.5);
        return (int) litres;
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        float gallon = 4.54609188F;
        float litres = 1.609344F;
        return Math.round((mpg * (litres / gallon)) * 100.0F) / 100.0F;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (Math.sqrt(array[i]) % 1 == 0) {
                array[i] = (int) Math.sqrt(array[i]);
            } else {
                array[i] *= array[i];
            }
        }
        return array;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) {
            int[] emptyArray = {};
            return emptyArray;
        }
        int pos = 0;
        int neg = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0) {
                pos++;
            } else if (input[i] < 0) {
                neg += input[i];
            }
        }
        int[] returnValues = new int[]{pos, neg};
        return returnValues;
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
        return Math.round(number * 100.0) / 100.0;
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        return Arrays
                .stream(numbers)
                .filter(x -> (x % divider) == 0)
                .toArray();
    }
}
