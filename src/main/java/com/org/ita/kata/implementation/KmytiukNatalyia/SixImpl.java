package com.org.ita.kata.implementation.KmytiukNatalyia;
import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Six;
import java.util.regex.Matcher;
import java.util.regex.Pattern;import static java.util.stream.Stream.of;
public class SixImpl extends BaseKata implements Six {
    @Override
    public long findNb(long m) {
        long num = 0;
        long n = 0;
        for (n = 1; num < m; n++) {
            num += (long) Math.pow(n, 3);
        }
        return num == m ? n - 1 : -1;
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
            report.append(lines[i].trim().replaceAll("\\s+", " ")).append(String.format(" Balance %.2f", balance - sum)).append(newLine);
        }
        return report + String.format("Total expense  %.2f%sAverage expense  %.2f", sum, newLine, sum / (lines.length - 1));
    }

    @Override
    public double f(double x) {
        return  x / (1 + Math.sqrt(1 + x));
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
        if (toFind.isEmpty()) {
            return "";
        }

        var stats = new int[5];
        for (var match : of(resultSheet.split(",")).filter(s -> s.contains(toFind)).toArray(String[]::new)) {
            if (match.contains(".")) {
                return "Error(float number):" + match;
            }
            var teams = match.substring(0, match.lastIndexOf(' ')).replaceAll(" \\d+ ", "@").split("@");
            if (teams[0].equals(toFind) || teams[1].equals(toFind)) {
                var pointsA = Integer.parseInt(match.substring(match.lastIndexOf(' ') + 1));
                var pointsB = Integer.parseInt(match.substring(teams[0].length() + 1, match.indexOf(teams[1]) - 1));
                updateMatchStatistics(pointsA, pointsB, match.startsWith(toFind), stats);
            }
        }
        return toFind + (stats[3] + stats[4] > 0 ? ":W=" + stats[0] + ";D=" + stats[2] + ";L=" + stats[1] + ";Scored=" + stats[3] + ";Conceded=" + stats[4] + ";Points=" + (3 * stats[0] + stats[2]) : ":This team didn't play!");
    }

    private static void updateMatchStatistics(int pointsA, int pointsB, boolean home, int[] stats) {
        if (home) {
            var temp = pointsA;
            pointsA = pointsB;
            pointsB = temp;
        }

        stats[3] += pointsA;
        stats[4] += pointsB;

        if (pointsA > pointsB) {
            stats[0]++;
        } else if (pointsA < pointsB) {
            stats[1]++;
        } else {
            stats[2]++;
        }
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        String res ="";
        if(lstOfArt.length != 0 && lstOf1stLetter.length != 0)
        {
            for(int i = 0; i < lstOf1stLetter.length; i++)
            {
                String L = lstOf1stLetter[i];
                int count =0;

                for(int j = 0; j < lstOfArt.length; j++)
                {
                    String cur = lstOfArt[j];
                    if( cur.substring(0,1).equals(L) )
                    {
                        String[] val = cur.split(" ");
                        count += Integer.parseInt(val[1]);
                    }
                }

                String stock = "(" + L + " : " + count + ")";
                if(i != lstOf1stLetter.length - 1)
                {
                    res += stock + " - ";
                }
                else
                {
                    res += stock;
                }
            }
        }
        return res;
    }
}
