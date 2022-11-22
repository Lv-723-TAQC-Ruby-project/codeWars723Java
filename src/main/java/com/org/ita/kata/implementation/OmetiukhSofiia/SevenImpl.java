package main.java.com.org.ita.kata.implementation.OmetiukhSofiia;

import main.java.com.org.ita.kata.Seven;

//import java.util.Arrays;
import java.util.stream.DoubleStream;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double don = navg * (arr.length + 1) - DoubleStream.of(arr).sum();
        if (don <= 0)
            throw new IllegalArgumentException("The sum of donation is too small");
        return (long) (Math.ceil(don));
    }

    @Override
    public String seriesSum(int n) {
        int num = 1;
        double result = 0.0;
        int t = 0;
        while (t < n) {
            result += 1.0 / num;
            num += 3;
            t += 1;
        }
        return String.format("%.2f", result);
    }

    @Override
    public int whereIsHe(int p, int bef, int aft) {
        return p - Math.max(bef + 1, p - aft) + 1;
    }
}
