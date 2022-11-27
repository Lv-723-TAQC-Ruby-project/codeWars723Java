package com.org.ita.kata;

import org.apache.commons.lang3.SerializationUtils;

public class BaseDataProvider {


    public static final Eight[] EIGHTS_IMPL = new Eight[]{
            new com.org.ita.kata.implementation.BrylAndrii.EightImpl(),
            new com.org.ita.kata.implementation.FedykSvyatoslav.EightImpl(),
            new com.org.ita.kata.implementation.KhudoBohdan.EightImpl(),
            new com.org.ita.kata.implementation.KmytiukNatalyia.EightImpl(),
            new com.org.ita.kata.implementation.KovalyovVladyslav.EightImpl(),
            new com.org.ita.kata.implementation.KulykMariia.EightImpl(),
            new com.org.ita.kata.implementation.LypskyiOleksandr.EightImpl(),
            new com.org.ita.kata.implementation.OmetiukhSofiia.EightImpl(),
            new com.org.ita.kata.implementation.StanislavKovalov.EightImpl(),
    };

    public static final Seven[] SEVEN_IMPL = new Seven[]{
            new com.org.ita.kata.implementation.BrylAndrii.SevenImpl(),
            new com.org.ita.kata.implementation.FedykSvyatoslav.SevenImpl(),
            new com.org.ita.kata.implementation.KhudoBohdan.SevenImpl(),
            new com.org.ita.kata.implementation.KmytiukNatalyia.SevenImpl(),
            new com.org.ita.kata.implementation.KovalyovVladyslav.SevenImpl(),
            new com.org.ita.kata.implementation.KulykMariia.SevenImpl(),
            new com.org.ita.kata.implementation.LypskyiOleksandr.SevenImpl(),
            new com.org.ita.kata.implementation.OmetiukhSofiia.SevenImpl(),
            new com.org.ita.kata.implementation.StanislavKovalov.SevenImpl(),
    };

    public static final Six[] SIX_IMPL = new Six[]{
            new com.org.ita.kata.implementation.BrylAndrii.SixImpl(),
            new com.org.ita.kata.implementation.FedykSvyatoslav.SixImpl(),
            new com.org.ita.kata.implementation.KhudoBohdan.SixImpl(),
            new com.org.ita.kata.implementation.KmytiukNatalyia.SixImpl(),
            new com.org.ita.kata.implementation.KovalyovVladyslav.SixImpl(),
            new com.org.ita.kata.implementation.KulykMariia.SixImpl(),
            new com.org.ita.kata.implementation.LypskyiOleksandr.SixImpl(),
            new com.org.ita.kata.implementation.OmetiukhSofiia.SixImpl(),
            new com.org.ita.kata.implementation.StanislavKovalov.SixImpl(),
    };

    public static final Five[] FIVE_IMPL = new Five[]{
            new com.org.ita.kata.implementation.BrylAndrii.FiveImpl(),
            new com.org.ita.kata.implementation.FedykSvyatoslav.FiveImpl(),
            new com.org.ita.kata.implementation.KhudoBohdan.FiveImpl(),
            new com.org.ita.kata.implementation.KmytiukNatalyia.FiveImpl(),
            new com.org.ita.kata.implementation.KovalyovVladyslav.FiveImpl(),
            new com.org.ita.kata.implementation.KulykMariia.FiveImpl(),
            new com.org.ita.kata.implementation.LypskyiOleksandr.FiveImpl(),
            new com.org.ita.kata.implementation.OmetiukhSofiia.FiveImpl(),
            new com.org.ita.kata.implementation.StanislavKovalov.FiveImpl(),
    };

    public static Object[][] combineImplWithTests(Object[] implementations, Object[][] baseTestData) {
        int fullTestDataLength = implementations.length * baseTestData.length;
        Object[][] fullTestData = new Object[fullTestDataLength][baseTestData[0].length + 1];
        int count = 0;
        for (Object impl : implementations) {
            Object[][] baseTestDataCopy = SerializationUtils.clone(baseTestData);
            for (Object[] baseTest : baseTestDataCopy) {
                for (int i = 0; i < baseTest.length + 1; i++) {
                    fullTestData[count][i] = i == 0 ? impl : baseTest[i - 1];
                }
                count++;
            }
        }

        return fullTestData;
    }


}
