package com.study.interviewbit.heap;

import java.util.*;

/**
 *
 Given two arrays A & B of size N each.
 Find the maximum n elements from the sum combinations (Ai + Bj) formed from elements in array A and B.

 For example if A = [1,2], B = [3,4], then possible pair sums can be 1+3 = 4 , 1+4=5 , 2+3=5 , 2+4=6
 and maximum 2 elements are 6, 5
 *
 * N = 4
   a[]={1,4,2,3}
   b[]={2,5,1,6}
 */
class Pair<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<Pair<K, V>>{
    final K i;
    final V j;

    Pair(K i, V j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int compareTo(Pair<K, V> that) {
        int cmp = this.i.compareTo(that.i);
        if (cmp == 0)
            cmp = this.j.compareTo(that.j);
        return cmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(i, pair.i) &&
                Objects.equals(j, pair.j);
    }

    @Override
    public int hashCode() {

        return Objects.hash(i, j);
    }
}
public class NMaxPairCombination {
    class ArrayOffset {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ArrayOffset that = (ArrayOffset) o;

            if (i != that.i) return false;
            if (j != that.j) return false;
            return val == that.val;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            result = 31 * result + val;
            return result;
        }

        public ArrayOffset(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

        int i;
        int j;
        int val;
    }

    public ArrayList<Integer> solveCorrect(ArrayList<Integer> list1, ArrayList<Integer> list2) {

        Collections.sort(list1);
        Collections.sort(list2);
        ArrayList<Integer> res = new ArrayList<>();
        int size = list1.size();

        PriorityQueue<ArrayOffset> heap = new PriorityQueue<>(new Comparator<ArrayOffset>() {
            @Override
            public int compare(ArrayOffset o1, ArrayOffset o2) {
                return Integer.compare(o2.val, o1.val);
            }
        });

        HashSet<ArrayOffset> set = new HashSet<>();

        ArrayOffset e = new ArrayOffset(list1.size() - 1, list2.size() - 1, list1.get(list1.size() - 1) + list2.get(list2.size() - 1));
        heap.add(e);
        set.add(e);

        for (int i = 1; i <= size; i++) {

            ArrayOffset poll = heap.poll();
            res.add(poll.val);

            if (poll.j >= 1) {
                ArrayOffset e1 = new ArrayOffset(poll.i, poll.j - 1, list1.get(poll.i) + list2.get(poll.j - 1));

                if (!set.contains(e1)) {
                    heap.add(e1);
                    set.add(e1);
                }
            }

            if (poll.i >= 1) {
                ArrayOffset e2 = new ArrayOffset(poll.i - 1, poll.j, list1.get(poll.i - 1) + list2.get(poll.j));

                if (!set.contains(e2)) {
                    heap.add(e2);
                    set.add(e2);
                }
            }

        }
        return res;
    }


    public static ArrayList<Integer> solveWithHeap(ArrayList<Integer> A, ArrayList<Integer> B) {
        int N = A.size();
        Collections.sort(A);
        Collections.sort(B);
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        // my_set is used to store the indices of
        // the  pair(i, j) we use my_set to make sure
        // the indices doe not repeat inside max heap.
        LinkedList<Pair<Integer, Integer> > my_set = new LinkedList<>();
        pq.offer(new Pair<Integer, Pair<Integer,Integer>>(
                A.get(N - 1) + B.get(N - 1),
                new Pair<Integer, Integer>(N - 1, N - 1)));

        my_set.add(new Pair<Integer, Integer>(N - 1, N - 1));
        ArrayList<Integer> list = new ArrayList<>();
        for (int count=0; count< N; count++) {

            // tuple format (sum, i, j).
            Pair<Integer, Pair<Integer,Integer>> temp = pq.poll();
            //cout << temp.first << endl;
            list.add(temp.i);
            int i = temp.j.i;
            int j = temp.j.j;
            if (i != 0) {
                int sum = A.get(i - 1) + B.get(j);

                // insert (A[i - 1] + B[j], (i - 1, j))
                // into max heap.
                Pair<Integer, Integer> temp1 = new Pair<Integer, Integer>(i - 1, j);

                // insert only if the pair (i - 1, j) is
                // not already present inside the map i.e.
                // no repeating pair should be present inside
                // the heap.
                if (!my_set.contains(temp1)) {
                    pq.offer(new Pair<Integer, Pair<Integer, Integer>>(sum, temp1));
                    my_set.add(temp1);
                }

                // insert (A[i] + B[j - 1], (i, j - 1))
                // into max heap.
                if (j != 0) {
                    sum = A.get(i) + B.get(j - 1);
                    temp1 = new Pair<Integer, Integer>(i, j - 1);

                    // insert only if the pair (i, j - 1)
                    // is not present inside the heap.
                    if (!my_set.contains(temp1)) {
                        pq.offer(new Pair<Integer, Pair<Integer, Integer>>(sum, temp1));
                        my_set.add(temp1);
                    }
                }
            }
        }
        return list;
    }

    public static ArrayList<Integer> solvewithQueue(ArrayList<Integer> A, ArrayList<Integer> B) {
        // max heap.
        PriorityQueue<Integer> pq =
                new PriorityQueue<Integer>(Collections.reverseOrder());

        // insert all the possible
        // combinations in max heap.
        int N = A.size();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                pq.add(A.get(i) + B.get(j));

        // pop first N elements
        // from max heap and
        // display them.
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (count < N)
        {
            list.add(pq.peek());
            pq.remove();
            count++;
        }
        return list;
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.size();j++){
                treeSet.add(A.get(i) + B.get(j));
            }

        }

        ArrayList<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator = treeSet.descendingIterator();

        int n = A.size();
        while(iterator.hasNext() && n != 0 ){
            list.add(iterator.next());
            n--;
        }

        return list;
    }

    public static void main(String[] args) {
        //List<Integer> A =Arrays.asList(1,4,2,3);
        List<Integer> A =Arrays.asList(1);
        List<Integer> B =Arrays.asList(1);
        solveWithHeap(new ArrayList<>(A), new ArrayList<>(B));
        System.out.println();
    }
}
