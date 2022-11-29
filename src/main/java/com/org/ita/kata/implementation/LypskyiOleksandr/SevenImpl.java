package com.org.ita.kata.implementation.LypskyiOleksandr;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Seven;

public class SevenImpl extends BaseKata implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double sumOfArray = 0;
        for (double v : arr) {
            sumOfArray += v;
        }
        double expectedDonation = navg * (arr.length + 1) - sumOfArray;

        if (expectedDonation > 0) {
            return (long) Math.ceil(expectedDonation);
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
