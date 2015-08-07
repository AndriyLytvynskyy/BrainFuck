package com.booking.interviewbit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.
 */
public class SetZero {
    public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        Set<Integer> zeroRowIndexes = new HashSet<Integer>();
        Set<Integer> zeroColIndexes = new HashSet<Integer>();

        for (int i = 0; i< a.size();i++){
            ArrayList<Integer> columns = a.get(i);
            for (int j = 0; j < columns.size();j++){
                 if ((columns.get(j) == 0) && (!zeroRowIndexes.contains(i)) && (!zeroColIndexes.contains(j))){
                     //set zero for row
                     for (int c = 0;c < columns.size();c++){
                        a.get(i).set(c, 0);
                    }
                     //set zero for each column
                     for (int r = 0;r < a.size();r++){
                         a.get(r).set(j, 0);
                     }
                     zeroRowIndexes.add(i);
                     zeroColIndexes.add(j);

                 }
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<Integer>(){{
            add(0);
            add(0);
        }});
        a.add(new ArrayList<Integer>(){{
            add(1);
            add(1);
        }});
        setZeroes(a);
    }

}
