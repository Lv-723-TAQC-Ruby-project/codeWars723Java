package com.org.ita.kata.implementation.KulykMariia;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Seven;
import java.util.Arrays;

public class SevenImpl extends BaseKata implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double result;
        result = (arr.length + 1) * navg - Arrays.stream(arr).sum();
        if (result < 0) {
            throw new IllegalArgumentException();
        }
        return (long) result;
    }

    @Override
    public String seriesSum(int n) {
        double start = 1.0;
        double value = 0.0;
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.println("0.00");
            } else {
                value += (1.0 / start);
                start += 3.0;
            }
        }
        double result = Math.round(value * 100.0) / 100.0;
        return String.valueOf(result);
    }

    @Override
    public int whereIsHe(int p, int bef, int aft) {
        return Math.min(p - bef, aft + 1);
    }
}
