package com.org.ita.kata.implementation.BrylAndrii;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Seven;

public class SevenImpl extends BaseKata implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double sum = 0;
        for (double v : arr) {
            sum += v;
        }
        double result = Math.ceil(navg * (arr.length + 1) - sum);
        if (result < 0) {
            throw new IllegalArgumentException();
        }
        return (long) result;
    }

    @Override
    public String seriesSum(int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += 1.0 / (1 + 3 * i);
        }
        return String.format("%.2f", sum);
    }

    @Override
    public int whereIsHe(int p, int bef, int aft) {
        return Math.min((p - bef), (aft + 1));
    }
}
