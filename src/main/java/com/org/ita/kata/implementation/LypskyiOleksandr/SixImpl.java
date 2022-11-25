import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        MathContext mc = new MathContext(30);
        BigDecimal one = new BigDecimal(1);
        BigDecimal result = (one.add(BigDecimal.valueOf(x))).sqrt(mc).subtract(one);
        return result.doubleValue();
    }

    
    public static List<Double> data_to_list(String town, String strng) {
        String[] all_towns = strng.split("\n");


        List<Double> town_data = new ArrayList<>();
        for (String town_string : all_towns) {
            String[] town_split = town_string.split(":");
            String town_name = town_split[0];
            if (town_name.equals(town)) {
                String[] town_values = town_split[1].split(",");
                List<Double> list_of_values = new ArrayList<>();
                for (String town_value : town_values) {
                    list_of_values.add(Double.parseDouble(town_value.split(" ")[1]));
                }
                double mean = (double) list_of_values.stream().collect(Collectors.summingDouble(Double::doubleValue)) / town_values.length;
                List<Double> list_of_variance = new ArrayList<>();
                for (Object value : list_of_values) {
                    list_of_variance.add((mean - (double) value) * (mean - (double) value));
                }
                double variance = (double) list_of_variance.stream().collect(Collectors.summingDouble(Double::doubleValue)) / list_of_variance.size();
                town_data.addAll(Arrays.asList(mean, variance));
            }

        }
        if (town_data.size() == 0) {
            town_data.addAll(Arrays.asList(-1.0, -1.0));
        }
        return town_data;
    }
    
    
    @Override
    public double mean(String town, String strng) {
        List<Double> data = data_to_list(town, strng);
        return data.get(0);

    }

    @Override
    public double variance(String town, String strng) {
         List<Double> data = data_to_list(town, strng);
        return data.get(1);
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
