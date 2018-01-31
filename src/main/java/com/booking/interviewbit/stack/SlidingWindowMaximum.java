package com.booking.interviewbit.stack;

import java.util.*;

/**
 * A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right.
 * You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position.
 * You have to find the maximum for each window. The following example will give you more clarity.
 * <p>
 * The array is [1 3 -1 -3 5 3 6 7], and w is 3.
 *
 * Optimal solution with DeQueue is taken from here:
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k
 *
 */
public class SlidingWindowMaximum {

    public static ArrayList<Integer> slidingMaximumDeQueue(final List<Integer> A, int B) {
        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> Qi = new LinkedList<Integer>();

        /* Process first k (or first window) elements of array */
        int i;
        int n = A.size();
        for (i = 0; i < B; ++i) {
            // For very element, the previous smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && A.get(i) >= A.get(Qi.peekLast()))
                Qi.removeLast();   // Remove from rear

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            result.add(A.get(Qi.peek()));

            // Remove the elements which are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <= i - B) {
                Qi.removeFirst();
            }

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while ((!Qi.isEmpty()) && A.get(i) >= A.get(Qi.peekLast())) {
                Qi.removeLast();
            }
            // Add current element at the rear of Qi
            Qi.addLast(i);

        }
        result.add(A.get(Qi.peek()));
        return result;
    }

    public static ArrayList<Integer> slidingMaximumIterative(final List<Integer> A, int B) {
        int j, max;
        int n= A.size();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= n - B; i++) {

            max = A.get(i);

            for (j = 1; j < B; j++) {
                if (A.get(i + j) > max)
                    max = A.get(i + j);
            }
            result.add(max);
        }
        return result;

    }
    public static ArrayList<Integer> slidingMaximumMyMethod(final List<Integer> A, int B) {
        Stack<Integer> result = new Stack<>();
        if (B > A.size()) {
            result.push(Collections.max(A));
        } else {
            Queue<Integer> window = new LinkedList<>();
            int windowIndex = 0;
            while(window.size() != B) {
                window.add(A.get(windowIndex++));
            }
            result.add(Collections.max(window));
            for (int i = windowIndex; i < A.size(); i++) {
                Integer removedFromWindow = window.poll();

                final Integer nextWindowElement = A.get(i);
                window.add(nextWindowElement);
                final Integer lastMaxElement = result.peek();
                if ((nextWindowElement < lastMaxElement) && (removedFromWindow <= nextWindowElement)){
                   result.push(nextWindowElement);
                } else {
                    result.add(Collections.max(window));
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
//        Integer [] array =  {1, 3, -1, -3, 5, 3, 6, 7};
//        int B = 3;
        Integer [] array =  {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int B = 2;
        ArrayList<Integer> result = slidingMaximumDeQueue(Arrays.asList(array), B);
        System.out.println(result);
    }
}
