package com.org.ita.kata.implementation.FedykSvyatoslav;

import static java.util.stream.Collectors.averagingDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Six;

public class SixImpl extends BaseKata implements Six {
    @Override
    public long findNb(long m) {
        long n = 0;
        long cubeSize = 0;
        for (; cubeSize < m; n++)
            cubeSize += n * n * n;
        return (cubeSize == m) ? n - 1 : -1;
    }

    @Override
    public String balance(String book) {
        StringBuilder result = new StringBuilder();
        String[] splittedBook = book.replaceAll("[^a-zA-Z0-9 \\n.]","").replaceAll(" {2,}", " ").split("\n");
        double balance = Double.parseDouble(splittedBook[0]);
        double expense = 0;
        result.append("Original Balance: ").append(String.format(Locale.US,"%1$.2f", balance)).append("\\r\\n");
        for(int i = 1; i < splittedBook.length; i++) {
            String[] splittedItem = splittedBook[i].split(" ");
            double itemExpense = Double.parseDouble(splittedItem[splittedItem.length - 1]);
            balance -= itemExpense;
            expense += itemExpense;
            result.append(splittedBook[i].trim()).append(" Balance ").append(String.format(Locale.US,"%1$.2f", balance)).append("\\r\\n");
        }
        result.append("Total expense  ").append(String.format(Locale.US,"%1$.2f", expense)).append("\\r\\n");
        result.append("Average expense  ").append(String.format(Locale.US,"%1$.2f", expense / (splittedBook.length - 1)));

        return result.toString();
    }

    @Override
    public double f(double x) {
        return x / (1 + Math.sqrt(1 + x));
    }

    @Override
    public double mean(String town, String strng) {
        return temp(town, strng).stream()
                .collect(averagingDouble(n -> n));
    }

    @Override
    public double variance(String town, String strng) {
        double mean = mean(town, strng);
        if (mean == -1.0) return -1.0;

        return temp(town, strng).stream()
                .collect(averagingDouble(n -> (n - mean) * (n - mean)));
    }

    private static List<Double> temp(String town, String strng) {
        List<Double> temps = new ArrayList<>();
        for (String line : strng.split("\\n")) {
            String[] data = line.split(":");
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
    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
}
