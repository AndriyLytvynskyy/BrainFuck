package com.booking;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;

/**
 * You have the file with word at a single line.
 * #input sample file
 * abactor
 * abaculus
 * abacus
 * Abadite
 * .
 * .
 * Zyrenian
 * <p/>
 * #Output
 * *****************************************************************a
 * ************b
 * *********************************c
 * *********************d
 * ******************************************************************************e
 * <p/>
 * a) you have to count the character and create a histogram in alphabetical order.
 * b) now you have to produce a histogram with max 80 character in line in reference to max count
 * c) now same out based histrogram based on the character count
 */
public class FileWithWords {


    public static void getCharsUsingJustSimpleJava(){

    }

    public static void main(String[] args) {
        getCharactersHistogram();

    }

    private static void getCharactersHistogram() {
        String[] input = new String[]{"abactor", "abaculus"};
        Map<String, Long> map = Arrays.asList(input).stream().map(s -> s.split("")).flatMap(Stream::of).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(map);
    }


}
