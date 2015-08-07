package com.booking.interviewbit;

import java.util.*;

/**
 * Created by Andrii_Lytvynskyi on 8/5/2015.
 */
public class LargestNum {
    static Map<Integer, List<Integer>> cacheOfNumbers = new HashMap<>();
    // DO NOT MODIFY THE LIST
    public static String largestNumber(final List<Integer> a) {
        Collections.sort(a, (o1, o2) -> {
            String val1 = o1.toString().concat(o2.toString());
            String val2 = o2.toString().concat(o1.toString());
            return (Long.valueOf(val2).compareTo(Long.valueOf(val1)));
        });
        return concat(a);
    }

    static String concat(List<Integer> list) {
        boolean allZeros = list.stream().allMatch(s -> s.equals(0));
        StringBuilder result = new StringBuilder();
        if (allZeros) {
            result.append(list.get(0));
        }
        else {
            for (Integer i : list) {
                result.append(i);
            }
            list.stream().allMatch(s -> s.equals(0));
        }
        return result.toString();
    }

    static List<Integer> getAllInts(int number) {
        return cacheOfNumbers.computeIfAbsent(number, (key) -> {
            LinkedList<Integer> stack = new LinkedList<Integer>();
            while (key > 0) {
                stack.push(key % 10);
                key = key / 10;
            }
            return stack;
        });

    }

    public static void main(String[] args) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        res.add(0);
        res.add(0);
        res.add(0);
        res.add(0);

        System.out.println(largestNumber(res));

    }
}
