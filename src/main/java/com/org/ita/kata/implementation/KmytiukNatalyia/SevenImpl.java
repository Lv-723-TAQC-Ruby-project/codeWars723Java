package com.org.ita.kata.implementation.KmytiukNatalyia;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Seven;

public class SevenImpl extends BaseKata implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double sum = 0;
        for (double i : arr) {
            sum = sum + i;
        }
        long res = (long) Math.ceil(navg * (arr.length + 1) - sum);
        if (res <= 0)
            throw new IllegalArgumentException();
        else
            return res;
    }

    @Override
    public String seriesSum(int n) {
        double sum = 0.0;
        for (int i = 0; i < n; i++)
            sum += 1.0 / (1 + 3 * i);
        return String.format("%.2f", sum);
    }

    @Override
    public int whereIsHe(int p, int bef, int aft) {
        return (p - bef);
    }
}
