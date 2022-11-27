package com.org.ita.kata.implementation.BrylAndrii;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Six;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SixImpl extends BaseKata implements Six {
    @Override
    public long findNb(long m) {
        long output = 1;
        long check = 0;
        while (check <= m) {
            check += Math.pow(output, 3);
            if (check == m) {
                return output;
            }
            output++;
        }
        return -1;
    }

    @Override
    public String balance(String book) {
        String t = book.replaceAll("([^\\n. \\da-zA-Z])", "");
        String[] arr = t.split("\\n+");
        double current = Double.parseDouble(arr[0]);
        double total = 0;
        int count = 0;
        StringBuilder result = new StringBuilder();
        result.append("Original Balance: ").append(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            count++;
            String[] line = arr[i].split(" +");
            current -= Double.parseDouble(line[2]);
            total += Double.parseDouble(line[2]);
            String u = String.format("\\r\\n%s %s %s Balance %.2f", line[0], line[1], line[2], current);
            result.append(u);
        }
        result.append(String.format("\\r\\nTotal expense  %.2f\\r\\nAverage expense  %.2f", total, total / count));
        return result.toString();
    }

    @Override
    public double f(double x) {
        return x / (1 + Math.sqrt(1 + x));
    }

    @Override
    public double mean(String town, String strng) {
        String[] arr = strng.split("\\n+");
        for (String s : arr) {
            String[] line = s.split(":");
            if (line[0].equals(town)) {
                String[] data = line[1].split(",");
                double sum = 0;
                for (String datum : data) {
                    sum += Double.parseDouble(datum.split(" ")[1]);
                }
                return sum / data.length;
            }
        }
        return -1;
    }

    @Override
    public double variance(String town, String strng) {
        String[] arr = strng.split("\\n+");
        for (String s : arr) {
            String[] line = s.split(":");
            if (line[0].equals(town)) {
                String[] data = line[1].split(",");
                double sum = 0;
                for (String datum : data) {
                    sum += Double.parseDouble(datum.split(" ")[1]);
                }
                double mean = sum / data.length;
                double variance = 0;
                for (String datum : data) {
                    variance += Math.pow(Double.parseDouble(datum.split(" ")[1]) - mean, 2);
                }
                return variance / data.length;
            }
        }
        return -1;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (String s : lstOf1stLetter) {
            int sum = 0;
            for (String value : lstOfArt) {
                if (value.startsWith(s)) {
                    sum += Integer.parseInt(value.split(" ")[1]);
                }
            }
            result.append("(").append(s).append(" : ").append(sum).append(") - ");
        }
        return result.substring(0, result.length() - 3);
    }
}
