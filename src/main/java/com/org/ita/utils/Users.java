package com.org.ita.utils;

import com.org.ita.kata.Eight;
import com.org.ita.kata.Five;
import com.org.ita.kata.Seven;
import com.org.ita.kata.Six;

public enum Users {
    BRYL_ANDRII(1, "Bryl Andrii", "AndrewEdgers",
            new com.org.ita.kata.implementation.BrylAndrii.EightImpl(),
            new com.org.ita.kata.implementation.BrylAndrii.SevenImpl(),
            new com.org.ita.kata.implementation.BrylAndrii.SixImpl(),
            new com.org.ita.kata.implementation.BrylAndrii.FiveImpl()),
    OMETIUKH_SOFIIA(2, "Ometiukh Sofiia", "Sofiia44",
            new com.org.ita.kata.implementation.OmetiukhSofiia.EightImpl(),
            new com.org.ita.kata.implementation.OmetiukhSofiia.SevenImpl(),
            new com.org.ita.kata.implementation.OmetiukhSofiia.SixImpl(),
            new com.org.ita.kata.implementation.OmetiukhSofiia.FiveImpl()),
    KMYTIUK_NATALYIA(3, "Kmytiuk Natalyia", "natayarov",
            new com.org.ita.kata.implementation.KmytiukNatalyia.EightImpl(),
            new com.org.ita.kata.implementation.KmytiukNatalyia.SevenImpl(),
            new com.org.ita.kata.implementation.KmytiukNatalyia.SixImpl(),
            new com.org.ita.kata.implementation.KmytiukNatalyia.FiveImpl()),
    KULYK_MARIIA(4, "Kulyk Mariia", "merykul",
            new com.org.ita.kata.implementation.KulykMariia.EightImpl(),
            new com.org.ita.kata.implementation.KulykMariia.SevenImpl(),
            new com.org.ita.kata.implementation.KulykMariia.SixImpl(),
            new com.org.ita.kata.implementation.KulykMariia.FiveImpl()),
    KHUDO_BOHDAN(5, "Khudo Bohdan", "bohdan-khudio",
            new com.org.ita.kata.implementation.KhudoBohdan.EightImpl(),
            new com.org.ita.kata.implementation.KhudoBohdan.SevenImpl(),
            new com.org.ita.kata.implementation.KhudoBohdan.SixImpl(),
            new com.org.ita.kata.implementation.KhudoBohdan.FiveImpl()),
    FEDYK_SVYATOSLAV(6, "Fedyk Svyatoslav", "coffezka",
            new com.org.ita.kata.implementation.FedykSvyatoslav.EightImpl(),
            new com.org.ita.kata.implementation.FedykSvyatoslav.SevenImpl(),
            new com.org.ita.kata.implementation.FedykSvyatoslav.SixImpl(),
            new com.org.ita.kata.implementation.FedykSvyatoslav.FiveImpl()),
    STANISLAV_KOVALOV(9, "Kovalov Stanislav", "stas-kov7",
            new com.org.ita.kata.implementation.StanislavKovalov.EightImpl(),
            new com.org.ita.kata.implementation.StanislavKovalov.SevenImpl(),
            new com.org.ita.kata.implementation.StanislavKovalov.SixImpl(),
            new com.org.ita.kata.implementation.StanislavKovalov.FiveImpl());

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
