package com.booking.java8;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;



/**
 * Created by Andrii_Lytvynskyi on 7/13/2015.
 */
public class WordCountJava {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("say", "damn", "brain", "damn");

        Map<String, Long> listMapped =  list.stream().collect(Collectors.groupingBy(s->s , counting()));

        System.out.println(listMapped);


    }
}
