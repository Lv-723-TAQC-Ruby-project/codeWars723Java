package com.org.ita.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ConsoleReader {
    public static BufferedReader reader;

    public ConsoleReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Input should be double");
            }
        }
    }

    public int readInteger() {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Input should be integer");
            return readInteger();
        }

    }

    public int readIntegerMinMax(int min, int max) {
        try {
            int value = Integer.parseInt(reader.readLine());
            if (min <= value && value <= max) {
                return value;
            }
            System.out.println("Enter a value between " + min + "-" + max);
            return readIntegerMinMax(min, max);

        } catch (IOException | NumberFormatException e) {
            System.out.println("Input should be integer");
            return readIntegerMinMax(min, max);
        }

    }

    public Long readLong() {
        try {
            return Long.parseLong(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Input should be long");
            return readLong();
        }
    }

    public BigInteger readBigInteger() {
        try {
            return new BigInteger(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Input should be long");
            return readBigInteger();
        }
    }

    public Float readFloat() {
        try {
            return Float.parseFloat(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Input should be long");
            return readFloat();
        }
    }

    public String readString() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Input should be String");
            return readString();
        }
    }

    public String[] readStringArr() {
        try {
            return reader.readLine().trim().split("\\s+");
        } catch (IOException e) {
            System.out.println("Input should be String array");
            return readStringArr();
        }
    }

    public int[] readIntArr() {
        try {

            String[] in = reader.readLine().trim().split("\\s+");
            int[] arr = new int[in.length];
            for (int i = 0; i < in.length; i++) {
                arr[i] = Integer.parseInt(in[i]);
            }
            return arr;
        } catch (IOException e) {
            System.out.println("Input should be int array");
            return readIntArr();
        }
    }

    public double[] readDoubleArr() {
        try {

            String[] in = reader.readLine().trim().split("\\s+");
            double[] arr = new double[in.length];
            for (int i = 0; i < in.length; i++) {
                arr[i] = Double.parseDouble(in[i]);
            }
            return arr;
        } catch (IOException e) {
            System.out.println("Input should be double array");
            return readDoubleArr();
        }
    }

}
