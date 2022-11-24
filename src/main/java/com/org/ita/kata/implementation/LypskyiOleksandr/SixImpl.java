import java.util.regex.Matcher;
import java.util.regex.Pattern;

package com.org.ita.kata.implementation.LypskyiOleksandr;

import com.org.ita.kata.Six;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        long volume = 1L;
        long number_of_rows = 1L;
        while (volume < m) {
            number_of_rows += 1;
            volume += Math.pow(number_of_rows, 3);
        }
        return volume == m ? number_of_rows : -1;
    }

    @Override
    public String balance(String book) {
        String[] array_of_strings = book.split("\n");
        Pattern decimalNumPattern = Pattern.compile("\\d+(\\.\\d+)?");
        Pattern wordPattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = decimalNumPattern.matcher(array_of_strings[0]);
        matcher.find();
        double balance = Double.parseDouble(matcher.group(0));
        String string_to_return = "Original Balance: " + String.format("%.2f", balance);
        double total_expense = 0;
        double total_items = 0;
        for (int i = 1; i < array_of_strings.length; i++) {
            if (array_of_strings[i].isEmpty())
                continue;
            String prepared_string = array_of_strings[i].replaceAll("\\s+", "");
            Matcher matcher_name = wordPattern.matcher(prepared_string);
            matcher_name.find();
            String name_of_item = matcher_name.group(0);
            String[] temp_array = array_of_strings[i].split(name_of_item);
            Matcher matcher_price = decimalNumPattern.matcher(temp_array[1]);
            matcher_price.find();
            double price_of_item = Double.parseDouble(matcher_price.group(0));
            total_expense += price_of_item;
            total_items += 1;
            balance -= price_of_item;
            string_to_return += "\\r\\n" + temp_array[0] + name_of_item + " " + String.format("%.2f", price_of_item) + " Balance " + String.format("%.2f", balance);
        }
        string_to_return += "\\r\\nTotal expense  " + String.format("%.2f", total_expense) + "\\r\\nAverage expense  " + String.format("%.2f", (total_expense / total_items));
        return string_to_return;
    }

    @Override
    public double f(double x) {
        return 0;
    }

    @Override
    public double mean(String town, String strng) {
        return 0;
    }

    @Override
    public double variance(String town, String strng) {
        return 0;
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
