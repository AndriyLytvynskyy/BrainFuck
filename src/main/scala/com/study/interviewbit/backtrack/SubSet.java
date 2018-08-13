package com.study.interviewbit.backtrack;

import java.util.ArrayList;
import java.util.Collections;

public class SubSet {
    public ArrayList<ArrayList<Integer>> subsets1(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        Collections.sort(A);
        backtrack( subsets,  new ArrayList<Integer>(),  A,  0);
        return subsets;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> tempList, ArrayList<Integer> A, int start){
         list.add(tempList);
         for (int i = start;i < A.size();i++){
             tempList.add(A.get(i));
             backtrack( list, tempList, A, i + 1);
             tempList.remove(tempList.size() - 1);
         }
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> combinations = new  ArrayList<ArrayList<Integer>>();
        combinations.add(0, new ArrayList<>());
        Collections.sort(A);
        for (int i = 0; i<= A.size();i++){
            combinations.add(i + 1, new ArrayList<Integer>());
            for (int j = i; j < (A.size() - i);j++){
                combinations.get(i+1).add(A.get(j));
            }
        }
        return combinations;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(12);
        input.add(13);
        subsets(input);

    }

}
