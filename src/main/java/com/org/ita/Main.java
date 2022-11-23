package com.org.ita;


import com.org.ita.utils.Users;

public class Main {
    public static void main(String[] args) {
        Users user = Users.OMETIUKH_SOFIIA;
        user.getEight().amIWilson(10);
        user = Users.getStudentById(1);
        user.getEight().amIWilson(10);
        System.out.println("Hello World!");
    }
}
