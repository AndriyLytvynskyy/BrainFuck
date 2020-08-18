package com.study.leet;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/sorting.html
 * https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
 * https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/EG-922
 */

public class MergeKSortedLists {
    static ListNode head;
    //    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ////        if (head == null){
    ////            head
    ////        }
    ////        ListNode result = null;
    ////        ListNode temp = null;
    ////        ListNode curr = null;
    ////        while (l1 != null && l2 != null) {
    ////
    ////            result = new ListNode(l1.val);
    ////            result.next = new ListNode(l2.val);
    ////
    ////            l1 = l1.next;
    ////            l2 = l2.next;
    ////            temp = result;
    ////
    ////        }
    ////
    ////
    ////        return result;
    //    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        //    mergeTwoLists(node1, node2);
    }

    public static ListNode sortedMerge(ListNode a, ListNode b) {
        ListNode result = null;
        /* Base cases */
        if (a == null)
            return b;
        else if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }

        return result;
    }

    public static ListNode mergeKLists(ListNode[] arr) {
        // repeat until only one list is left

        int last = arr.length - 1;
        while (last != 0) {

            int i = 0, j = last;
            // (i, j) forms a pair
            while (i < j) {
                // merge List i with List j and store
                // merged list in List i
                arr[i] = sortedMerge(arr[i], arr[j]);

                // consider next pair
                i++;
                j--;

                // If all pairs are merged, update last
                if (i >= j)
                    last = j;
            }
        }
        return arr[0];
    }
}
