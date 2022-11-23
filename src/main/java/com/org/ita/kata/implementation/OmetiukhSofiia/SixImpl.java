package com.org.ita.kata.implementation.OmetiukhSofiia;

import com.org.ita.kata.Six;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.averagingDouble;

public class SixImpl implements Six {
    public static List<Double> parseTemp(String town, String strng) {
        List<Double> temps = new ArrayList<>();
        for (String l : strng.split("\\n")) {
            String[] data = l.split(":");
            if (town.equals(data[0])) {
                for (String weather : data[1].split(",")) {
                    String[] temp = weather.split("\\s");
                    temps.add(Double.parseDouble(temp[1]));
                }
                break;
            }
        }
        if (temps.isEmpty()) temps.add(-1.0);
        return temps;
    }

    @Override
    public long findNb(long m) {
        long total = 1L;
        long n = 1L;
        while (total < m) {
            n += 1;
            total += n * n * n;
        }
        return total == m ? n : -1;
    }

    @Override
    public String balance(String book) {
        return null;
    }

    @Override
    public double f(double x) {
        return x / (1 + Math.sqrt(1 + x));
    }

    @Override
    public double mean(String town, String strng) {
        return parseTemp(town, strng)
                .stream()
                .collect(averagingDouble(x -> x));
    }

    @Override
    public double variance(String town, String strng) {
        double mean = mean(town, strng);
        if (mean == -1.0)
            return -1.0;
        return parseTemp(town, strng)
                .stream()
                .collect(averagingDouble(x -> (x - mean) * (x - mean)));
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
}
