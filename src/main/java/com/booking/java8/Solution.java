package com.booking.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Andrii_Lytvynskyi on 7/29/2015.
 */
public class Solution {
    public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
        ArrayList<Integer> result;
        ArrayList<Integer> sub = new ArrayList<>();
        result = sub;
        long maxSumPrev = 0;
        long maxSumCurrent = 0;
        for (int i = 0;i < a.size();i++) {
            final Integer integer = a.get(i);
            if (integer >= 0){
                sub.add(integer);
                maxSumCurrent += integer;
            } else  {
                if (maxSumPrev < maxSumCurrent){
                    maxSumPrev = maxSumCurrent;
                    maxSumCurrent = 0;
                    result = sub;
                }
                sub = new ArrayList<>();
            }
            if (i == a.size()-1) {
                if (maxSumPrev < maxSumCurrent) {
                    maxSumPrev = maxSumCurrent;
                    maxSumCurrent = 0;
                    result = sub;
                }
            }
        }

        return result;
    }

    public static ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> pascalTriangle = new ArrayList<ArrayList<Integer>>();
        if (a != 0) {
            Integer[] previousRow;
            Integer[] currentRow = new Integer[]{1};
            ArrayList<Integer> firstArrayList = new ArrayList<Integer>();
            firstArrayList.add(1);
            pascalTriangle.add(firstArrayList);
            previousRow = currentRow;
            for (int i = 2; i <= a; i++) {
                currentRow = new Integer[i];

                currentRow[0] = 1;
                currentRow[i - 1] = 1;

                for (int j = 0; j <= i - 3; j++) {
                    currentRow[j + 1] = previousRow[j] + previousRow[j + 1];
                }
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (Integer integer : currentRow) {
                    list.add(integer);
                }
                pascalTriangle.add(list);
                previousRow = currentRow;
            }
        }
        return pascalTriangle;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ls = generate (5);
        System.out.println(ls);
        //final List<Integer> ts = Arrays.asList(24831, 53057, 19790, -10679, 77006, -36098, 75319, -45223, -56760, -86126, -29506, 76770, 29094, 87844, 40534, -15394, 18738, 59590, -45159, -64947, 7217, -55539, 42385, -94885, 82420, -31968, -99915, 63534, -96011, 24152, 77295);

        //System.out.println(maxset(new ArrayList<>(ts)));
    }
}
