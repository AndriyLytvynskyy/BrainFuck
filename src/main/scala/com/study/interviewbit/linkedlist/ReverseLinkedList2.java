package com.study.interviewbit.linkedlist;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,

    return 1->4->3->2->5->NULL.

 The idea is taken from here: https://www.geeksforgeeks.org/reverse-sublist-linked-list/
 *
 */
public class ReverseLinkedList2 {

    public static ListNode reverseList(ListNode A) {

        ListNode current = A;
        ListNode prev = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static  ListNode reverseBetween(ListNode A, int B, int C) {
       if (B == C){
           return A;
       }
        int count = 1;
        ListNode curr = A;
        ListNode revs = null;
        ListNode revend = null;
        ListNode revend_next = null;
        ListNode revs_prev = null;
        while (curr != null && count <= C) {
            if (count < B)
                revs_prev = curr;

            if (count == B) {
                revs = curr;
            }

            if (count == C) {
                revend = curr;
                revend_next = curr.next;
            }

            curr = curr.next;
            count++;
        }
        revend.next = null;

        // Reverse linked list starting with
        // revs.
        revend = reverseList(revs);

        // If starting position was not head
        if (revs_prev != null) {
            revs_prev.next = revend;
        }
        else {
            A = revend;
        }
        if (revs != null) {
            revs.next = revend_next;
        }
        return A;

    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node = reverseBetween(node1, 2 ,4);
        System.out.println(node);
    }
}
