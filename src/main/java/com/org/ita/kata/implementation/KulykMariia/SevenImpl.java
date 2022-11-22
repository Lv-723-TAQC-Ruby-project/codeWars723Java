package main.java.com.org.ita.kata.implementation.KulykMariia;

import main.java.com.org.ita.kata.Seven;

import java.util.Arrays;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double result = 0;
        try {
            result = (arr.length + 1) * navg - Arrays.stream(arr).sum();
            return (long) result;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return (long) result;
    }

    @Override
    public String seriesSum(int n) {
        return null;
    }

    @Override
    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}
