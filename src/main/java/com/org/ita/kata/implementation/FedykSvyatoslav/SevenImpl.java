package com.org.ita.kata.implementation.FedykSvyatoslav;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Seven;

import java.util.Locale;

public class SevenImpl extends BaseKata implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        int n = arr.length + 1;
        double mul = n * navg;

        double sum = 0;
        for (double d : arr) sum += d;

        if (sum >= mul) throw new IllegalArgumentException();

        return (long) Math.ceil(mul - sum);
    }

    @Override
    public String seriesSum(int n) {
        double sum = 0;
        for (int i = 1; i < n*3; i+=3) {
            sum += 1.0/i;
        }
        return String.format(Locale.US,"%.2f", sum);
    }

    @Override
    public int whereIsHe(int p, int bef, int aft) {
        return Math.min(p - bef, ++aft);
    }
}
