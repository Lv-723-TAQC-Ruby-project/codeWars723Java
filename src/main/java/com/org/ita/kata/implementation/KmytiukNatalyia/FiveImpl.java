package com.org.ita.kata.implementation.KmytiukNatalyia;

import com.org.ita.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    @Override
    public int artificialRain(int[] v) {
        int res =0;
        int numbers = v.length;
        int [] left = new int[numbers];
        int [] leftR = new int[numbers];
        int [] right = new int[numbers];
        int [] rightL = new int[numbers];

        left[0] = 1;
        for (int i = 1;i < numbers;i++) {
            if (v[i] <= v[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        right[numbers - 1] = 1;
        for (int i = numbers - 2;i >= 0;i--) {
            if  (v[i] <= v[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else{
                right[i] = 1;
            }
        }

        leftR[numbers - 1] = 1;
        for (int i =numbers-2;i >=0;i--){
            if (left[i]<left[i+1]) {
                leftR[i]=leftR[i+1] + 1;
            } else {
                leftR[i] = 1;
            }
        }

        rightL[0] = 1;
        for ( int i = 1;i < numbers;i++){
            if (right[i]<right[i-1]) {
                rightL[i]=rightL[i-1] + 1;
            } else {
                rightL[i] = 1;
            }
        }

        for (int i = 0; i<numbers; i++) {
            res = Math.max(res,leftR[i] + rightL[i]-1);
        }
        return res;
    }

    private static boolean isPrime( int num){
        if(num == 2) return true;
        if(num % 2 == 1) {
            for (int i =2; i<= num/2; i++){
                if(num % i ==0) {
                    return false;
                }
            }return true;
        }
        return false;
    }
    public long[] gap(int g, long m, long n) {
        long prime = 0;
        long [] res =new long[2];

        for (int i = (int) m; i <n ; i++){
            if(isPrime(i)) {
                if(prime == 0){
                    prime =i;
                }else if (i -prime == g){
                    res[0]=prime;
                    res[1]=i;
                    return res;
                }else {
                    prime =i;
                }
            }
        }return null;
    }
    
    @Override
    public int zeros(int n) {
        int num = 0;
        if (n==0)
            return 0;
        while (n > 5) {
            n /= 5;
            num += n;
        }
        return (num);
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(1);
        BigInteger sum = BigInteger.valueOf(0);
        for(int i =0; i <= n.intValue(); i++) {
            a = b;
            b = c;
            c = a.add(b);
            sum = sum.add(a);
        }
        return sum.multiply(BigInteger.valueOf(4));
    }

    @Override
    public double solveSum(double m) {
        return (1 - Math.sqrt(4 * m + 1)) / (2.0 * m) + 1;
    }

    @Override
    public long[] smallest(long n) {
        int n1 = 0;
        int n2 = 0;
        long res = n;
        String temp = String.valueOf(n);
        for(int i =0; i<temp.length(); i++ ){
            for(int j =0; j<temp.length(); j++){
                if (i!=j && making(temp, i, j) < res) {
                    res = making(temp,i,j);
                    n1 = i;
                    n2 = j;
                }
            }
        }

        return new long[]{res, n1, n2};
    }
    public static long making(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        char c = sb.charAt(i);
        sb.deleteCharAt(i);
        sb.insert(j, c);

        return Long.valueOf(sb.toString());
    }
}
