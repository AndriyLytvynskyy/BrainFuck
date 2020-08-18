package com.study.leet;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 *
 * Input: 1->1->2
 * Output: 1->2
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 */
public class RemoveDuplicatesFromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode ls = new ListNode(1);
        ListNode ls1 = new ListNode(1);
        ListNode ls2 = new ListNode(2);
        ListNode ls3 = new ListNode(3);
        ls.next = ls1;
        ls1.next = ls2;
        ls2.next = ls3;
        deleteDuplicates(ls);
    }
}
