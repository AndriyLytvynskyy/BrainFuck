package com.booking.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all permutation of String both iterative and Recursive way
 * ab -> ab, ba
 * <p/>
 * abc -> abc, bac
 */
public class PrintAllPermutations {

    /**
     * Iterative permutation
     * @param inputList
     * @return
     *
     *  [1] = perms
     *  [2, 1]  perms
     *  [1, 2]
     *  [3, 2, 1] perms as a result
     *  [2, 3, 1]
     *  [2, 1, 3]
     *  [3, 1, 2]
     *  [1, 3, 2]
     *  [1, 2, 3]
     *
     *
     */
    public static ArrayList<ArrayList<Integer>> permuteIterativeIntegers(ArrayList<Integer> inputList) {
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
        permutations.add(new ArrayList<Integer>());

        for (int i = 0; i < inputList.size(); i++) {
            final Integer elementToBeAddedIntoDifferentPlaces = inputList.get(i);
            ArrayList<ArrayList<Integer>> current = new ArrayList<>();
            for (ArrayList<Integer> permsTemp : permutations) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < permsTemp.size() + 1; j++) {
                    // + add num[i] to different locations
                    permsTemp.add(j, elementToBeAddedIntoDifferentPlaces);

                    ArrayList<Integer> temp = new ArrayList<Integer>(permsTemp);
                    current.add(temp);

                    // - remove num[i] add
                    permsTemp.remove(j);
                }
            }
            permutations = new ArrayList<ArrayList<Integer>>(current);

        }

        return permutations;
    }

    /**
     * Recursive permutation
     * @param a
     * @return
     */

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
        if (a.size() == 0) {
            permutations.add(new ArrayList<Integer>());
            return permutations;
        }

        int firstElement = a.get(0);
        a.remove(0);
        ArrayList<ArrayList<Integer>> allPerms = permute(a);
        for (ArrayList<Integer> arr : allPerms) {
            for (int j = 0; j <= arr.size(); j++) {
                ArrayList<Integer> first = new ArrayList<Integer>(arr.subList(0, j));
                List<Integer> second = new ArrayList<Integer>(arr.subList(j, arr.size()));
                first.add(firstElement);
                first.addAll(second);
                permutations.add(first);
            }

        }
        return permutations;
    }


    public static List<String> permutationList(String word) {
        List<String> permutations = new ArrayList<String>();
        if (word.length() == 0) {
            permutations.add("");
            return permutations;
        }
        char ch = word.charAt(0);
        String substring = word.substring(1);
        List<String> allwords = permutationList(substring);
        for (String allword : allwords) {
            for (int j = 0; j <= allword.length(); j++) {
                String first = allword.substring(0, j);
                String second = allword.substring(j);
                permutations.add(first + ch + second);
            }
        }
        return permutations;
    }


    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0)
            System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        ArrayList<ArrayList<Integer>> perms = permuteIterativeIntegers(list);
        for (ArrayList<Integer> perm : perms) {
            System.out.println(perm);
        }
        //        System.out.println("ABC".substring(0,0));
//        List<String> perms = permutationList("ABC");
//        for (String perm : perms) {
//            System.out.println(perm);
//        }
//        String s = "ABC";
//        Set<String> perms1 = new HashSet();
//        for (int i = 0; i <= s.length() - 1;i++ ){
//            char ch = s.charAt(i);
//            String word = s.substring(0, i) + s.substring(i + 1);
//            for (int j = 0; j <= word.length(); j++ ){
//                String first = word.substring(0, j);
//                String second = word.substring(j);
//                String result = first + ch + second;
//                System.out.println(result);
//                perms1.add(result);
//            }
//        }
//        System.out.println();
//        for (String perm : perms1) {
//            System.out.println(perm);
//        }
    }

}
