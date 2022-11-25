package com.org.ita.kata.implementation.LypskyiOleksandr;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Seven;

public class SevenImpl extends BaseKata implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double sum_of_array = 0;
        for (double v : arr) {
            sum_of_array += v;
        }
        double expected_donation = navg * (arr.length + 1) - sum_of_array;

        if (expected_donation > 0) {
            return (long) Math.ceil(expected_donation);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String seriesSum(int n) {
        double value = 0;
        double number = 1.0;
        for (int i = 0; i < n; i++) {
            value += 1 / number;
            number += 3;
        }
        return String.format("%.2f", value);
    }

    @Override
    public int whereIsHe(int p, int bef, int aft) {
        return Math.min((p - bef), (aft + 1));
    }
}
