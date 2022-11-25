package com.org.ita.kata.implementation.KhudoBohdan;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Seven;

import java.util.Arrays;

public class SevenImpl extends BaseKata implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double result = navg * (arr.length + 1) - Arrays.stream(arr).sum();
        if (result <= 0) {
            throw new IllegalArgumentException();
        }
        return (long)Math.ceil(result);
    }

    @Override
    public String seriesSum(int n) {
        double x = 1;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += 1 / x;
            x += 3;
        }

        return String.format("%.2f", sum);
    }

    @Override
    public int whereIsHe(int p, int bef, int aft) {
        int vasya = bef + 1;
        while (p - vasya > aft) {
            vasya++;
        }
        return p - vasya + 1;
    }
}
