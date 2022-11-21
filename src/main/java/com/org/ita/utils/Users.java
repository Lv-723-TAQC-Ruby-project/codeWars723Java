package main.java.com.org.ita.utils;

import main.java.com.org.ita.kata.Eight;
import main.java.com.org.ita.kata.Five;
import main.java.com.org.ita.kata.Seven;
import main.java.com.org.ita.kata.Six;


import java.util.ArrayList;
import java.util.List;

public enum Users {
    BRYL_ANDRII(1, "Bryl Andrii", "AndrewEdgers",
            new main.java.com.org.ita.kata.implementation.BrylAndrii.EightImpl(),
            new main.java.com.org.ita.kata.implementation.BrylAndrii.SevenImpl(),
            new main.java.com.org.ita.kata.implementation.BrylAndrii.SixImpl(),
            new main.java.com.org.ita.kata.implementation.BrylAndrii.FiveImpl()),
    OMETIUKH_SOFIIA(2, "Ometiukh Sofiia", "Sofiia44",
            new main.java.com.org.ita.kata.implementation.OmetiukhSofiia.EightImpl(),
            new main.java.com.org.ita.kata.implementation.OmetiukhSofiia.SevenImpl(),
            new main.java.com.org.ita.kata.implementation.OmetiukhSofiia.SixImpl(),
            new main.java.com.org.ita.kata.implementation.OmetiukhSofiia.FiveImpl()),
    ;

    private final int id;
    private final String name;
    private final String gitHubNikname;
    private final Eight eight;
    private final Seven seven;
    private final Six six;
    private final Five five;

    Users(int id, String name, String gitHubNikname, Eight eight, Seven seven, Six six, Five five) {
        this.id = id;
        this.name = name;
        this.gitHubNikname = gitHubNikname;
        this.eight = eight;
        this.seven = seven;
        this.six = six;
        this.five = five;
    }


    public static Users getStudentById(int id) {
        for (Users student : values()) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGitHubNikname() {
        return gitHubNikname;
    }

    public Seven getSeven() {
        return seven;
    }

    public Six getSix() {
        return six;
    }

    public Five getFive() {
        return five;
    }

    public Eight getEight() {
        return eight;
    }
}
