package com.org.ita.kata.implementation.FedykSvyatoslav;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Eight;
import java.util.stream.*;
import java.util.Arrays;

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
        float glt = 4.54609188f;
        float mtk = 1.609344f;
        return (float)Math.round(mpg * mtk / glt * 100) / 100;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        for(int i = 0; i < array.length; i++) {
            if (Math.sqrt(array[i]) % 1 == 0) array[i] = (int) Math.sqrt(array[i]);
            else array[i] = array[i] * array[i];
        }
        return array;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        return input == null || input.length == 0 ? new int[0] :
                new int[] { (int)IntStream.of(input).filter(i->i>0).count(), IntStream.of(input).filter(i->i<0).sum() };
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
        return Arrays.stream(numbers).filter(n -> n % divider == 0).toArray();
    }
}
