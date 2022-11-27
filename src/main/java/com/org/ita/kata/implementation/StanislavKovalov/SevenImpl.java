package com.org.ita.kata.implementation.StanislavKovalov;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Seven;

public class SevenImpl extends BaseKata implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double sum = 0;
        for (double v : arr) {
            sum += v;
        }
        long j = (long) Math.ceil((arr.length + 1) * navg - sum);
        if (j < 0){
            throw new IllegalArgumentException();
        }
        return j;
    }

    @Override
    public String seriesSum(int n) {
        double sum = 0;
        for (int i = 1; i < n*3; i+=3) {
            sum += 1.0/i;
        }
        return String.format("%.2f", sum);
    }

    @Override
    public int whereIsHe(int p, int bef, int aft)  {
        int person = bef + 1;
        while (p - person > aft) { person++;}
        return p - person + 1;
    }
}
