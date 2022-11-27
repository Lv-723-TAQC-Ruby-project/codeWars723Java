package com.org.ita.kata.implementation.LypskyiOleksandr;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Six;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SixImpl extends BaseKata implements Six {
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
                double mean = list_of_values.stream().collect(Collectors.summingDouble(Double::doubleValue)) / town_values.length;
                List<Double> list_of_variance = new ArrayList<>();
                for (Object value : list_of_values) {
                    list_of_variance.add((mean - (double) value) * (mean - (double) value));
                }
                double variance = list_of_variance.stream().collect(Collectors.summingDouble(Double::doubleValue)) / list_of_variance.size();
                town_data.addAll(Arrays.asList(mean, variance));
            }

        }
        if (town_data.size() == 0) {
            town_data.addAll(Arrays.asList(-1.0, -1.0));
        }
        return town_data;
    }

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
         if (resultSheet == null || resultSheet.isEmpty() || toFind == null || toFind.isEmpty()) return "";
        HashMap<String, int[]> team_results = new HashMap<>();
        String[] raw_data = resultSheet.split(",");
        Pattern firstDigitRegex = Pattern.compile("\\d{2,3}");
        Pattern lastDigitRegex = Pattern.compile("\\d{2,3}$");
        for (String res : raw_data) {
            if (res.contains(".")) return "Error(float number):" + res;
            res = res.replaceAll(",$", "");
            Matcher firstScoreMatcher = firstDigitRegex.matcher(res);
            Matcher secondScoreMatcher = lastDigitRegex.matcher(res);
            firstScoreMatcher.find();
            int first_team_score = Integer.parseInt(firstScoreMatcher.group(0));
            secondScoreMatcher.find();
            int second_team_score = Integer.parseInt(secondScoreMatcher.group(0));
            String[] team_names = res.split(String.valueOf(first_team_score));
            String first_team_name = team_names[0].strip();
            String[] second_team_name_array = team_names[1].split(" ");
            second_team_name_array = Arrays.copyOfRange(second_team_name_array, 1, second_team_name_array.length - 1);
            String second_team_name = String.join(" ", second_team_name_array).strip();
            team_results.putIfAbsent(first_team_name, new int[]{0, 0, 0, 0, 0, 0});
            team_results.putIfAbsent(second_team_name, new int[]{0, 0, 0, 0, 0, 0});
            int[] first_team_stats = team_results.get(first_team_name);
            int[] second_team_stats = team_results.get(second_team_name);
            if (first_team_score > second_team_score) {
                first_team_stats[0] += 1;
                first_team_stats[3] += first_team_score;
                first_team_stats[4] += second_team_score;
                first_team_stats[5] += 3;
                second_team_stats[2] += 1;
                second_team_stats[3] += second_team_score;
                second_team_stats[4] += first_team_score;
            } else {
                second_team_stats[0] += 1;
                second_team_stats[3] += second_team_score;
                second_team_stats[4] += first_team_score;
                second_team_stats[5] += 3;
                first_team_stats[2] += 1;
                first_team_stats[3] += first_team_score;
                first_team_stats[4] += second_team_score;
            }
        }
        if (team_results.containsKey(toFind)) {
            int[] team_stats = team_results.get(toFind);
            return toFind + ":W=" + team_stats[0] + ";D=" + team_stats[1] + ";L=" + team_stats[2] + ";Scored=" + team_stats[3] + ";Conceded=" + team_stats[4] + ";Points=" + team_stats[5];
        } else {
            return toFind + ":This team didn't play!";
        }
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
         String toReturn = "";
        if (lstOfArt.length != 0 && lstOf1stLetter.length != 0) {
            for (int i = 0; i < lstOf1stLetter.length; i++) {
                String category = lstOf1stLetter[i];
                int count = 0;
                for (String Artstr : lstOfArt) {
                    if (Artstr.substring(0, 1).equals(category)) {
                        String[] book = Artstr.split(" ");
                        count += Integer.parseInt(book[1]);
                    }
                }
                String stock = "(" + category + " : " + count + ")";
                if (i != (lstOf1stLetter.length - 1)) {
                    toReturn += stock + " - ";
                } else {
                    toReturn += stock;
                }
            }
        }
        return toReturn;
    }
}
