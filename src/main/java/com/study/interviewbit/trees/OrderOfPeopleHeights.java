package com.study.interviewbit.trees;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * You are given the following :

    A positive number N
    Heights : A list of heights of N persons standing in a queue
    Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P and standing in front of P
    You need to return list of actual order of persons’s height

 Input :
 Heights:  5 3 2 6 1 4
 InFronts: 0 1 2 0 3 2

 Output :
 actual order is: 5 3 2 1 6 4

 So, you can see that for the person with height 5, there is no one taller than him who is in front of him, and hence Infronts has 0 for him.

 For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.

 You can do similar inference for other people in the list.

 Solution is found here: http://qa.geeksforgeeks.org/3974/determine-the-actual-order-heights-google
 *
 *
 */
public class OrderOfPeopleHeights {
    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for (int i=0; i<heights.size(); i++) {
            map.put(heights.get(i), infronts.get(i));
        }

        boolean sorted = false;
        while(!sorted) {
            int height = map.lastKey();
            int taller = map.get(height);
            map.remove(height);


            if (result.isEmpty()){
                result.add(height);
            } else if (taller == 0) {
                result.add(0,height);
            } else {
                result.add(taller,height);
            }
            if (map.isEmpty()) sorted = true;
        }
        return result;
    }
}
