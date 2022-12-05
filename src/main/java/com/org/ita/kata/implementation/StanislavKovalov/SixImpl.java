package com.org.ita.kata.implementation.StanislavKovalov;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Six;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SixImpl extends BaseKata implements Six {
    @Override
    public long findNb(long m) {
        long mm = 0, n = 0;
        while (mm < m) mm += ++n * n * n;
        return mm == m ? n : -1;
    }

    @Override
    public String balance(String book) {
        var lines = book.replaceAll("[^\\w\n. ]", "").split("\n");
        var newLine = "\\r\\n";
        var report = new StringBuilder("Original Balance: " + lines[0] + newLine);
        double balance = Double.parseDouble(lines[0]);
        double sum = 0;
        for (int i = 1; i < lines.length; i++) {
            sum += Double.parseDouble(lines[i].split("\\s+")[2]);
            report.append(lines[i].trim().replaceAll("\\s+", " ")).append(String.format(Locale.US," Balance %.2f", balance - sum)).append(newLine);
        }
        return report + String.format(Locale.US,"Total expense  %.2f%sAverage expense  %.2f", sum, newLine, sum / (lines.length - 1));
    }

    @Override
    public double f(double x) {
        return x / (1 + Math.sqrt(1 + x));
    }

    public static double[] arr(String town, String strng){
        String num = null;
        int town_s =strng.indexOf(town);
        if (town_s == -1.0) {
            return new double [0];
        }
        int town_e = strng.indexOf("\n",town_s);
        if (town_e == -1){
            num = strng.substring(town_s);
        } else {
            num = strng.substring(town_s,town_e);
        }
        String rejex = "\\d+\\.\\d";
        double [] array = new double [12];
        Pattern p = Pattern.compile(rejex);
        Matcher m = p.matcher(num);
        int i = 0;
        while (m.find()){
            array[i++] = Double.valueOf(m.group());
        }
        return array;
    }
    @Override
    public double mean(String town, String strng) {
        double [] array = arr(town,strng);
        if (array.length == 0){
            return -1;
        }
        double sum = 0.0;
        for (double x : array){
            sum+=x;
        }
        return (sum / 12);
    }

    @Override
    public double variance(String town, String strng) {
        double [] array = arr(town,strng);
        if (array.length == 0){
            return -1;
        }
        double mean = mean(town, strng);
        double sum = 0;
        for (double x : array){
            sum+=Math.pow(x-mean,2);
        }
        return sum/12;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if(toFind == "")
            return "";
        String res = toFind + ":";
        int w = 0;
        int d = 0;
        int l = 0;
        int s = 0;
        int c = 0;
        int p = 0;

        if(!resultSheet.contains(toFind + " "))
            return toFind + ":This team didn't play!";

        String[] mas = resultSheet.split(",");
        int score = 0;
        int concede = 0;
        for(int i = 0; i < mas.length; i++){
            if(mas[i].contains(toFind)){
                int j = mas[i].indexOf(toFind);
                try {
                    String[] splitStr = mas[i].split(" ");
                    if(j == 0){
                        score = Integer.parseInt(splitStr[toFind.split(" ").length]);
                        concede = Integer.parseInt(splitStr[splitStr.length - 1]);
                    }else{
                        concede = Integer.parseInt(splitStr[splitStr.length - toFind.split(" ").length - 2]);
                        score = Integer.parseInt(splitStr[splitStr.length - 1]);
                    }
                } catch (NumberFormatException e) {
                    return "Error(float number):" + mas[i];
                }
                s += score;
                c += concede;
                if(score > concede){
                    w++;
                    p += 3;
                }else if(score == concede){
                    d++;
                    p++;
                }else{
                    l++;
                }
            }
        }
        return res + "W=" + w + ";D=" + d + ";L=" + l
                + ";Scored=" + s + ";Conceded=" + c
                + ";Points=" + p;
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0)
            return "";
        String output="";

        for (String letter : lstOf1stLetter){
            int counter=0;
            for (String stock : lstOfArt){
                if (stock.charAt(0) == letter.charAt(0)){
                    String[] parts = stock.split(" ");
                    counter += Integer.parseInt(parts[1]);
                }
            }

            output += "(" + letter.charAt(0) + " : " + counter + ") - ";
        }
        output = output.replaceAll(" - $", "");
        return output;
    }
}
