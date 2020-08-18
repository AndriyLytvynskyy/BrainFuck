package com.study.interviewbit.amazon.leet.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author andrii_lytvynskyi
 */
public class RomanToInt {
    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);
    }

    public static int romanToInt(String s) {
        int number = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1) {
                String romNumber2 = s.substring(i, i + 2);
                if (values.containsKey(romNumber2)) {
                    number = number + values.get(romNumber2);
                    i += 1;
                    continue;
                }
            }
            String rowNumber1 = s.substring(i, i + 1);
            number += values.get(rowNumber1);

        }

        return number;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

}
