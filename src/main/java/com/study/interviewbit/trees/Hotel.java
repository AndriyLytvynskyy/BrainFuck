package com.study.interviewbit.trees;

import java.util.*;

/**
 *
 * Given a set of reviews provided by the customers for different hotels and a string containing “Good Words”,
 * you need to sort the reviews in descending order according to their “Goodness Value” (Higher goodness value first).
 * We define the “Goodness Value” of a string as the number of “Good Words” in that string.
 * Note: Sorting should be stable.
 * If review i and review j have the same “Goodness Value” then their original order would be preserved.
 *
 *  You are expected to use Trie in an Interview for such problems
 *
 *  S : A string S containing "Good Words" separated by  "_" character. (See example below)
    R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.
 *
 */
public class Hotel {

    public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int ar=0, de=0, nos=0,satisfy=0;
        while(ar<arrive.size() && de<depart.size()){
            if(arrive.get(ar)<depart.get(de)){
                ar++;
                nos++;
                satisfy= Math.max(nos,satisfy);
            }else{
                de++;
                nos--;
            }
        }
        return (satisfy <= K);
    }
//    static class Interval implements Comparable<Interval> {
//        Integer start;
//        Integer end;
//
//        Interval() {
//            start = 0;
//            end = 0;
//        }
//
//        Interval(Integer s, Integer e) {
//            start = s;
//            end = e;
//        }
//
//        @Override
//        public int compareTo(Interval o) {
//            return this.start.compareTo(o.start);
//        }
//
//
//    }
//
//    public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
//
//        List<Interval> intervalList = new ArrayList<Interval>();
//        for (int i = 0; i < arrive.size(); i++) {
//            intervalList.add(new Interval(arrive.get(i), depart.get(i)));
//        }
//        Collections.sort(intervalList, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        int activeGuests = 1;
//        for (int i = 0; i < intervalList.size() - 1; i++) {
//            Interval interval = intervalList.get(i);
//            Interval nextInterval = intervalList.get(i + 1);
//            activeGuests++;
//            if (!notOverlap(interval, nextInterval)) {
//                if (activeGuests == (K + 1)) {
//                    return false;
//                }
//            } else {
//                activeGuests--;
//            }
//
//        }
//
//
//        return true;
//    }
//
//    public static boolean notOverlap(Interval interval1, Interval interval2) {
//        return (interval1.end.equals(interval2.start)) || (Math.max(interval1.start, interval2.start) > Math.min(interval1.end, interval2.end));
//    }
//
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 2, 3, 4);
        //List<Integer> ls = Arrays.asList(1, 2, 4);
        ArrayList<Integer> arrival = new ArrayList<Integer>();
        arrival.addAll(ls);
        System.out.println(arrival.size());
        ArrayList<Integer> depart = new ArrayList<Integer>();
        List<Integer> dp = Arrays.asList(10, 2, 6, 14);
        //List<Integer> dp = Arrays.asList( 2,4,9);
        depart.addAll(dp);
        System.out.println(depart.size());
        System.out.println(hotel(arrival, depart, 2));
    }
}
