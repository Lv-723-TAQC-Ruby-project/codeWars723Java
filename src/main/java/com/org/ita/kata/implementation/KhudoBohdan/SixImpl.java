package com.org.ita.kata.implementation.KhudoBohdan;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Six;

import java.util.ArrayList;
import java.util.Locale;


public class SixImpl extends BaseKata implements Six {
    @Override
    public long findNb(long m) {
        long n = 0;
        while (m > n) {
            n++;
            m -= n * n * n;
        }
        if (m == 0) {
            return n;
        }
        return -1;
    }

    @Override
    public String balance(String book) {
        String s = book.replaceAll("([^\\n. \\da-zA-Z])", "");
        String[] array = s.split("[\\n]+");
        double current = Double.parseDouble(array[0]);
        double ttl = 0;
        int counter = 0;
        StringBuilder result = new StringBuilder();
        result.append("Original Balance: ").append(array[0]);

        for (int i = 1; i < array.length; i++) {
            counter++;
            String[] line = array[i].split("[ ]+");
            current -= Double.parseDouble(line[2]);
            ttl += Double.parseDouble(line[2]);
            String res = String.format(Locale.US,"\\r\\n%s %s %s Balance %.2f", line[0], line[1], line[2], current);
            result.append(res);
        }

        result.append(String.format(Locale.US,"\\r\\nTotal expense  %.2f\\r\\nAverage expense  %.2f", ttl, ttl / counter));
        return result.toString();
    }

    @Override
    public double f(double x) {
        return x / (1 + Math.sqrt(x + 1));
    }

    public ArrayList<String> getTowns(String strng) {
        String[] words = strng.replaceAll("([^a-zA-Z \\n:]+)", "").replaceAll(":", "\n").split("\n");
        ArrayList<String> towns = new ArrayList<>();

        for (int i = 0; i < words.length; i += 2) {
            towns.add(words[i]);
        }
        return towns;
    }
    @Override
    public double mean(String town, String strng) {
        ArrayList<String> towns = getTowns(strng);

        String[] numbers = strng.replaceAll("([^0-9 \\n.]+)", "").split("\n");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i].trim();
        }
        ArrayList<Double> avrg = new ArrayList<>();
        for (String number : numbers) {
            String[] n_arr = number.split(" +");
            double sum = 0;
            for (String n : n_arr) {
                sum += Double.parseDouble(n);
            }
            avrg.add(sum / n_arr.length);
        }

        int index = -1;
        for (int i = 0; i < towns.size(); i++) {
            if (town.equals(towns.get(i))) {
                index = i;
            }
        }
        if (index == -1) {

        }

        return  avrg.get(index);
    }

    @Override
    public double variance(String town, String strng) {
        ArrayList<String> towns = getTowns(strng);

        String[] numbers = strng.replaceAll("([^0-9 \\n.]+)", "").split("\n");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i].trim();
        }
        ArrayList<Double> variance_arr = new ArrayList<>();
        for (String number : numbers) {
            String[] n_arr = number.split(" +");
            double total_sum = 0;
            for (String n : n_arr) {
                total_sum += Double.parseDouble(n);
            }
            double average = total_sum / n_arr.length;

            double sum = 0;
            for (String n : n_arr) {
                sum += (Double.parseDouble(n) - average) * (Double.parseDouble(n) - average);
            }
            variance_arr.add(sum / n_arr.length);
        }

        int index = -1;
        for (int i = 0; i < towns.size(); i++) {
            if (town.equals(towns.get(i))) {
                index = i;
            }
        }
        if (index == -1) {

        }

        return  variance_arr.get(index);
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.isEmpty()) {

        }

        if (!resultSheet.matches(String.format("(.*)%s\\s(.*)", toFind))) {
            return toFind + ":This team didn't play!";
        }

        String[] resultArr = resultSheet.split(",");
        int win = 0;
        int draws = 0;
        int lost = 0;
        int scored = 0;
        int conceded = 0;

        for (String result : resultArr) {
            if (result.contains(toFind)) {
                String[] arr = result.replaceAll(toFind, "team").split(" ");

                String point1Str;
                String point2Str;
                if (arr[0].equals("team")) {
                    point1Str = arr[1];
                    point2Str = arr[arr.length - 1];
                }
                else {
                    point1Str = arr[arr.length - 1];
                    point2Str = arr[arr.length - 3];
                }

                int point1, point2;
                try {
                    point1 = Integer.parseInt(point1Str);
                    point2 = Integer.parseInt(point2Str);
                }
                catch (Exception e) {
                    return  "Error(float number):" + result;
                }

                if (point1 > point2) {
                    win++;
                }
                else if (point1 < point2) {
                    lost++;
                }
                else if (point1 == point2) {
                    draws++;
                }

                scored += point1;
                conceded += point2;
            }
        }
        int points = win * 3 + draws;

        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d", toFind, win, draws, lost, scored, conceded, points);
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }

        int[] sum = new int[lstOf1stLetter.length];
        for (int i = 0; i < lstOf1stLetter.length; i++) {
            sum[i] = 0;
        }

        String[] books;
        for (String b : lstOfArt) {
            books = b.split(" ");
            for (int i = 0; i < lstOf1stLetter.length; i++) {
                if (books[0].charAt(0) == lstOf1stLetter[i].charAt(0)) {
                    sum[i] += Integer.parseInt(books[1]);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lstOf1stLetter.length - 1; i++) {
            result.append(String.format("(%s : %d) - ", lstOf1stLetter[i], sum[i]));
        }
        result.append(String.format("(%s : %d)", lstOf1stLetter[lstOf1stLetter.length - 1], sum[lstOf1stLetter.length - 1]));

        return result.toString();
    }
}
