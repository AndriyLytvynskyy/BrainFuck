package com.booking.interviewbit.hash;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 *
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
  The solution set must not contain duplicate quadruplets.
 *
 *
 *  Given array S = {1 0 -1 0 -2 2}, and target = 0
    A solution set is:
                     (-2, -1, 1, 2)
                     (-2,  0, 0, 2)
                     (-1,  0, 0, 1)
 */

class Tuple {
    final int index1, index2;

    Tuple(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return index1 == tuple.index1 &&
                index2 == tuple.index2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index1, index2);
    }
}
public class FourSum {

    public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();

        ArrayList<Tuple> twoSum = twoSum(A, B);
        for (int index = 0; index < twoSum.size(); index++) {
            Tuple first = twoSum.get(index);
            for (int j = index + 1; j < twoSum.size(); j++){
                if (first != twoSum.get(j)) {
                    ArrayList<Integer> tempArray = new ArrayList<>();
                    tempArray.add(first.index1);
                    tempArray.add(first.index2);
                    Tuple tuple = twoSum.get(j);
                    tempArray.add(tuple.index1);
                    tempArray.add(tuple.index2);
                    Collections.sort(tempArray);
                    set.add(tempArray);
                }
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(set);
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                List<Integer> copy1 = new ArrayList<>(o1);
                List<Integer> copy2 = new ArrayList<>(o2);

                Collections.sort(copy1);
                Collections.sort(copy2);
                Iterator<Integer> it1 = o1.iterator();
                Iterator<Integer> it2 = o2.iterator();
                while (it1.hasNext()) {
                    Integer t1 = it1.next();
                    Integer t2 = it2.next();
                    int i = Integer.compare(t1, t2);
                    if (i !=0 ) return i;
                }
                return 0;
            }


        });
        return result;
    }

    public ArrayList<ArrayList<Integer>> fourSum_1(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Integer[] numbers = A.toArray(new Integer[A.size()]);

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 3; i++) {
            for (int j = i + 1; j < numbers.length - 2; j++) {
                int left = j + 1;
                int right = numbers.length - 1;

                while (left < right) {
                    int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
                    if (sum == B) {
                        ArrayList<Integer> tuple = new ArrayList<>();
                        tuple.add(numbers[i]);
                        tuple.add(numbers[j]);
                        tuple.add(numbers[left]);
                        tuple.add(numbers[right]);
                        if (!result.contains(tuple)) {
                            result.add(tuple);
                        }
                        left++;
                        right--;
                    } else if (sum < B) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static ArrayList<Tuple> twoSum(final List<Integer> A, int B) {
        Set<Integer> set = new HashSet<Integer>(A);
        Set<Tuple> set2Sum = new HashSet<Tuple>();
        for (int index = 0; index < A.size(); index++) {
            if (set.contains(B - A.get(index))) {
                int comb1 = Math.min(A.get(index), A.get(A.indexOf(B - A.get(index))));
                int comb2 = Math.max(A.get(index), A.get(A.indexOf(B - A.get(index))));
                set2Sum.add(new Tuple(comb1, comb2));

            }
        }
        return new ArrayList<Tuple>(set2Sum);
    }

    public static void main(String[] args) {
        //Integer[] array = {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8 };
        //Integer[] array = {9, -8, -10, -7, 7, -8, 2, -7, 4, 7, 0, -3, -4, -5, -1, -4, 5, 8, 1, 9, -2, 5, 10, -5, -7, -1, -6, 4, 1, -5, 3, 8, -4, -10, -9, -3, 10, 0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7, 6, -4, 2, 0, 10, 1, -2, 5, -2};
        Integer[] array = {1, 0, -1, 0, -2, 2};
        final List<Integer> list = Arrays.asList(array);
        ArrayList<ArrayList<Integer>> ls = fourSum(new ArrayList(list), 0);
        System.out.println(ls);
//        for (Integer l : ls) {
//            System.out.println(l);
//        }
    }
}
