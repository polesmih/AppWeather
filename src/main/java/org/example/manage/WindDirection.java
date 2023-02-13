package org.example.manage;

public class WindDirection {

    public static String directionText(double degree) {
        String[] direct = {"С", "СВ",
                "В", "ЮВ",
                "Ю", "ЮЗ",
                "З", "СЗ", "С"};

        return direct[(int) Math.round((degree % 360) / 45)];
    }

    public static String directionSymb(double degree) {
        String[] direct = {"\u2193", "\u2199",
                "\u2190", "\u2196",
                "\u2191", "\u2197",
                "\u2192", "\u2198", "\u2193"};

        return direct[(int) Math.round((degree % 360) / 45)];
    }

}
