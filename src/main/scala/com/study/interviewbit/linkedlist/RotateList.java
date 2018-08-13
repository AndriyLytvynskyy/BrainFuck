package com.study.interviewbit.linkedlist;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:

 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 * Found solution here: http://java-questions.com/rotate-linked-list-by-k.html
 * - Traverse the list till the end. Keep the counter for length n
   - Connect the end of list to the start. Continue traversing from last element
   - Continue traversing till n-k
   - the n-k element will be the last element of new list , n-k+1 will be the first element of the list
   - traverse to n-k+1 and set the next of n-k element to NULL
 */
public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        int count = 0;
        ListNode start = head;
        //traverse till the end of the list and keep incrementing
        //count
        while (head.next != null) {
            head = head.next;
            count++;
        }
        count++;
        // if k > count, do k%count, its an optimization. 2%5 == 12%5
        k = k % count;
        //find the new k
        k = Math.abs(count - k);
        if (k == 0) {
            return start;
        }
        //connect last element to start
        head.next = start;
        //traverse for new k value
        while (k-- > 0) {
            head = head.next;
        }
        // note: head is not the last element, so set the start.
        start = head.next;
        head.next = null;
        return start;

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
        rotateRight(node1, 2);
    }
}
