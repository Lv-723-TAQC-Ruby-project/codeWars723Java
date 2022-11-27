package com.org.ita.kata.implementation.OmetiukhSofiia;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Seven;

import java.util.stream.DoubleStream;

public class SevenImpl extends BaseKata implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double don = navg * (arr.length + 1) - DoubleStream.of(arr).sum();
        if (don <= 0)
            throw new IllegalArgumentException("The sum of donation is too small");
        return (long) (Math.ceil(don));
    }

    @Override
    public String seriesSum(int n) {
        double num = 1.0;
        double value = 0.0;
        double t = 0.0;
        while (t < n) {
            value += 1.0 / num;
            num += 3;
            t += 1;
        }
        double result = Math.round(value*100.0)/100.0;
        return String.valueOf(result);
    }

    @Override
    public int whereIsHe(int p, int bef, int aft) {
        return p - Math.max(bef + 1, p - aft) + 1;
    }
}
