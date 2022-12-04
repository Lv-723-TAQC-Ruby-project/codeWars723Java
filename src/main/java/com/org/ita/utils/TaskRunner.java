package com.org.ita.utils;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringJoiner;

public class TaskRunner {
    private Users user = Users.BRYL_ANDRII;
    private final ConsoleReader reader = new ConsoleReader();
    static final String data = "Rome:Jan 81.2,Feb 63.2,Mar 70.3,Apr 55.7,May 53.0,Jun 36.4,Jul 17.5,Aug 27.5,Sep 60.9,Oct 117.7,Nov 111.0,Dec 97.9\n"
            + "London:Jan 48.0,Feb 38.9,Mar 39.9,Apr 42.2,May 47.3,Jun 52.1,Jul 59.5,Aug 57.2,Sep 55.4,Oct 62.0,Nov 59.0,Dec 52.9\n"
            + "Paris:Jan 182.3,Feb 120.6,Mar 158.1,Apr 204.9,May 323.1,Jun 300.5,Jul 236.8,Aug 192.9,Sep 66.3,Oct 63.3,Nov 83.2,Dec 154.7\n"
            + "NY:Jan 108.7,Feb 101.8,Mar 131.9,Apr 93.5,May 98.8,Jun 93.6,Jul 102.2,Aug 131.8,Sep 92.0,Oct 82.3,Nov 107.8,Dec 94.2\n"
            + "Vancouver:Jan 145.7,Feb 121.4,Mar 102.3,Apr 69.2,May 55.8,Jun 47.1,Jul 31.3,Aug 37.0,Sep 59.6,Oct 116.3,Nov 154.6,Dec 171.5\n"
            + "Sydney:Jan 103.4,Feb 111.0,Mar 131.3,Apr 129.7,May 123.0,Jun 129.2,Jul 102.8,Aug 80.3,Sep 69.3,Oct 82.6,Nov 81.4,Dec 78.2\n"
            + "Bangkok:Jan 10.6,Feb 28.2,Mar 30.7,Apr 71.8,May 189.4,Jun 151.7,Jul 158.2,Aug 187.0,Sep 319.9,Oct 230.8,Nov 57.3,Dec 9.4\n"
            + "Tokyo:Jan 49.9,Feb 71.5,Mar 106.4,Apr 129.2,May 144.0,Jun 176.0,Jul 135.6,Aug 148.5,Sep 216.4,Oct 194.1,Nov 95.6,Dec 54.4\n"
            + "Beijing:Jan 3.9,Feb 4.7,Mar 8.2,Apr 18.4,May 33.0,Jun 78.1,Jul 224.3,Aug 170.0,Sep 58.4,Oct 18.0,Nov 9.3,Dec 2.7\n"
            + "Lima:Jan 1.2,Feb 0.9,Mar 0.7,Apr 0.4,May 0.6,Jun 1.8,Jul 4.4,Aug 3.1,Sep 3.3,Oct 1.7,Nov 0.5,Dec 0.7";

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

    public void runTask(int taskId) {
        switch (taskId) {
            case 0:
                runLiters();
                break;
            case 1:
                runGetVolumeOfCuboid();
                break;
            case 2:
                runMpgToKPM();
                break;
            case 3:
                runSquareOrSquareRoot();
                break;
            case 4:
                runCountPositivesSumNegatives();
                break;
            case 5:
                runStringToNumber();
                break;
            case 6:
                runAmIWilson();
                break;
            case 7:
                runTwoDecimalPlaces();
                break;
            case 8:
                runDivisibleBy();
                break;
            case 9:
                runNewAvg();
                break;
            case 10:
                runSeriesSum();
                break;
            case 11:
                runWhereIsHe();
                break;
            case 12:
                runFindNb();
                break;
            case 13:
                runBalance();
                break;
            case 14:
                runF();
                break;
            case 15:
                runMean();
                break;
            case 16:
                runVariance();
                break;
            case 17:
                runNbaCup();
                break;
            case 18:
                runStockSummary();
                break;
            case 19:
                runArtificialRain();
                break;
            case 20:
                runGap();
                break;
            case 21:
                runZeros();
                break;
            case 22:
                runPerimeter();
                break;
            case 23:
                runSolveSum();
                break;
            case 24:
                runSmallest();
        }
    }
    public void runLiters() {
        System.out.println("Run task liters");
        System.out.print("Please input time (hours): ");
        double hours = reader.readDouble();
        int result = user.getEight().liters(hours);
        System.out.println("Result - " + result + " hours.");
    }
    public void runGetVolumeOfCuboid() {
        System.out.println("Run task Volume of Cuboid");
        System.out.println("Please, input the length: ");
        double length = reader.readDouble();
        System.out.println("Please, input the width: ");
        double width = reader.readDouble();
        System.out.println("Please, input the height: ");
        double height = reader.readDouble();
        double result = user.getEight().getVolumeOfCuboid(length, width, height);
        System.out.println("The volume of cuboid is: " + result);
    }
    public void runMpgToKPM() {
        System.out.println("Run task Miles per gallon to kilometers per liter\n");
        System.out.println("Please, input float to check: ");
        float number = reader.readFloat();
        float result = user.getEight().mpgToKPM(number);
        System.out.println("The result of converting -> " + result);
    }
    public void runSquareOrSquareRoot() {
        // To do
    }
    public void runCountPositivesSumNegatives() {
        System.out.println("Run task to square root or no to square");
        System.out.println("Please, input number to check:  ");
        int[] i = reader.readIntArr();
        int[] result = user.getEight().squareOrSquareRoot(i);
        System.out.println("The result of operation  is: " + Arrays.toString(result));
    }
    public void runStringToNumber() {
        System.out.println("Run task convert a string to a number");
        System.out.println("Please enter string that equals a number");
        String string= reader.readString();
        int result = user.getEight().stringToNumber(string);
        System.out.println("------------------------------------");
        System.out.println("The result of converting => " + result);
        System.out.println("------------------------------------");
    }
    public void runAmIWilson() {
        System.out.println("Run task am I Wilson");
        System.out.println("Please, input number to check: ");
        int number = reader.readInteger();
        boolean result = user.getEight().amIWilson(number);
        System.out.println("Is this number wilson number? -> " + result);
    }
    public void runTwoDecimalPlaces() {
        System.out.println("Run task two decimal places");
        System.out.println("Please, input number to round: ");
        double number = reader.readDouble();
        double result = user.getEight().twoDecimalPlaces(number);
        System.out.println("You number is rounded to two decimal places -> " + result);
    }
    public void runDivisibleBy() {
        System.out.println("Run task 'Find numbers which are divisible by given number'");
        System.out.println("Please, input numbers");
        int[] numbers = reader.readIntArr();
        System.out.println("Please, input divisor");
        int divisor = reader.readInteger();
        int[] result = user.getEight().divisibleBy(numbers, divisor);
        System.out.println("Result: " + Arrays.toString(result));
    }
    public void runNewAvg() {
        // To do
    }
    public void runSeriesSum() {
        System.out.println("Run task Sum of the first nth term of Series");
        System.out.println("Please input the integer number: ");
        int n = reader.readInteger();
        String result = user.getSeven().seriesSum(n);
        System.out.println("The sum of following series is: " + result);
    }
    public void runWhereIsHe() {
        System.out.println("Run task Where is Vasya?\n");
        System.out.println("Please, input integers: 1. total amount of people in the line;\n");
        int p = reader.readInteger();
        System.out.println("2. number of people standing in front of him\n");
        int bef = reader.readInteger();
        System.out.println("3. number of people standing behind him");
        int aft = reader.readInteger();
        int result = user.getSeven().whereIsHe(p,bef,aft);
        System.out.println("Vasya's position  -> " + result);
    }
    public void runFindNb() {
        System.out.println("Run task Build a pile of Cubes");
        System.out.println("Please, input the long number for check: ");
        long m = reader.readLong();
        long result = user.getSix().findNb(m);
        System.out.println("The  Building a pile of Cubes is: " + result);
    }
    public void runBalance() {
        // To do
    }
    public void runF() {
        System.out.println("Run task Floating-point approximation");
        System.out.println("Please enter a number (example: 2.6e-08) to check the conversion");
        double data= reader.readDouble();
        double result = user.getSix().f(data);
        System.out.println("------------------------------------");
        System.out.println("The result of converting => " + result);
        System.out.println("------------------------------------");
    }


    public void runMean() {
        System.out.println("Run task Rainfall: mean (return average for city)");
        System.out.println("Please, enter city to check: ");
        String city = reader.readString();
        double result = user.getSix().mean(city, data);
        System.out.println("Average for " + city + " is " + result);
    }
    public void runVariance() {
        System.out.println("Run task Rainfall: variance (should return the variance of rainfall for the city)");
        System.out.println("Please, enter city to check: ");
        String city = reader.readString();
        System.out.println("Please enter data to deal with: ");
        double result = user.getSix().variance(city, data);
        System.out.println("Result is: " + result);
    }
    public void runNbaCup() {
        System.out.println("Run task Ranking NBA:\n");
        String resultSheet = "Los Angeles Clippers 104 Dallas Mavericks 88,New York Knicks 101 Atlanta Hawks 112,Indiana Pacers 103 Memphis Grizzlies 112,\n" +
                "            Los Angeles Lakers 111 Minnesota Timberwolves 112,Phoenix Suns 95 Dallas Mavericks 111,Portland Trail Blazers 112 New Orleans Pelicans 94,\n" +
                "            Sacramento Kings 104 Los Angeles Clippers 111,Houston Rockets 85 Denver Nuggets 105,Memphis Grizzlies 76 Cleveland Cavaliers 106,\n" +
                "            Milwaukee Bucks 97 New York Knicks 122,Oklahoma City Thunder 112 San Antonio Spurs 106,Boston Celtics 112 Philadelphia 76ers 95,\n" +
                "            Brooklyn Nets 100 Chicago Bulls 115,Detroit Pistons 92 Utah Jazz 87,Miami Heat 104 Charlotte Hornets 94,\n" +
                "            Toronto Raptors 106 Indiana Pacers 99,Orlando Magic 87 Washington Wizards 88,Golden State Warriors 111 New Orleans Pelicans 95,\n" +
                "            Atlanta Hawks 94 Detroit Pistons 106,Chicago Bulls 97 Cleveland Cavaliers 95,;\n" +
                "            San Antonio Spurs 111 Houston Rockets 86,Chicago Bulls 103 Dallas Mavericks 102,Minnesota Timberwolves 112 Milwaukee Bucks 108,  \n" +
                "            New Orleans Pelicans 93 Miami Heat 90,Boston Celtics 81 Philadelphia 76ers 65,Detroit Pistons 115 Atlanta Hawks 87,  \n" +
                "            Toronto Raptors 92 Washington Wizards 82,Orlando Magic 86 Memphis Grizzlies 76,Los Angeles Clippers 115 Portland Trail Blazers 109,  \n" +
                "            Los Angeles Lakers 97 Golden State Warriors 136,Utah Jazz 98 Denver Nuggets 78,Boston Celtics 99 New York Knicks 85,  \n" +
                "            Indiana Pacers 98 Charlotte Hornets 86,Dallas Mavericks 87 Phoenix Suns 99,Atlanta Hawks 81 Memphis Grizzlies 82,  \n" +
                "            Miami Heat 110 Washington Wizards 105,Detroit Pistons 94 Charlotte Hornets 99,Orlando Magic 110 New Orleans Pelicans 107,  \n" +
                "            Los Angeles Clippers 130 Golden State Warriors 95,Utah Jazz 102 Oklahoma City Thunder 113,San Antonio Spurs 84 Phoenix Suns 104, \n" +
                "            Chicago Bulls 103 Indiana Pacers 94,Milwaukee Bucks 106 Minnesota Timberwolves 88,Los Angeles Lakers 104 Portland Trail Blazers 102,  \n" +
                "            Houston Rockets 120 New Orleans Pelicans 100,Boston Celtics 111 Brooklyn Nets 105,Charlotte Hornets 94 Chicago Bulls 86,Cleveland Cavaliers 103 Dallas Mavericks 97";
        System.out.println("ResultSheet");
        System.out.println(resultSheet);
        System.out.println("Please, enter team's name to see the scores: ");
        String toFind = reader.readString();
        String result = user.getSix().nbaCup(resultSheet,toFind);
        System.out.println("Result: " + result);
    }
    public void runStockSummary() {
        System.out.println("Run task 'Help the bookseller'");
        String[] stocklist = {"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        System.out.println("Stocklist:");
        System.out.println(Arrays.toString(stocklist));
        System.out.println("Please input list of categories");
        String[] categories = reader.readStringArr();
        String result = user.getSix().stockSummary(stocklist, categories);
        System.out.println("Result: " + result);

    }
    public void runArtificialRain() {
        // To do
    }
    public void runGap() {
        System.out.println("Run task Gap in Primes");
        System.out.println("Please, input the integer number of the gap we are looking for: ");
        int g = reader.readInteger();
        System.out.println("Please, input the start of the search: ");
        long m = reader.readLong();
        System.out.println("Please, input the end of the search: ");
        long n = reader.readLong();
        long [] result = user.getFive().gap(g, m, n);
        System.out.println("The first pair of two prime numbers is: " + result);
    }
    public void runZeros() {
        System.out.println("Run task am Number of trailing zeros of N!");
        System.out.println("Please, input number to check of trailing zeros: ");
        int number = reader.readInteger();
        int result = user.getFive().zeros(number);
        System.out.println("The number of trailing zeros in a factorial of a given number is -> " + result);
    }
    public void runPerimeter() {
        System.out.println("Run task perimeter of squares in a rectangle");
        System.out.println("Please, input number to check : ");
        BigInteger n = reader.readBigInteger();
        BigInteger result = user.getFive().perimeter(n);
        System.out.println("The perimeter of squares in a rectangle is -> " + result);
    }
    public void runSolveSum() {
        // To do
    }
    public void runSmallest() {
        System.out.println("Run task find the smallest");
        System.out.println("Please enter a number to check");
        long data= reader.readLong();
        long [] result = user.getFive().smallest(data);
        System.out.println("------------------------------------");
        System.out.println("The result  => " + Arrays.toString(result));
        System.out.println("------------------------------------");
    }
}
