package com.booking.interviewbit.linkedlist;

/**
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes
 * greater than or equal to x.

   You should preserve the original relative order of the nodes in each of the two partitions.
 *
 *
 * Given 1->4->3->2->5->2 and x = 3,
   return 1->2->2->4->3->5.

 General approach is to separate two linked lists into partitions ane merge them, foudn solution discussion here:
 https://discuss.leetcode.com/topic/7005/very-concise-one-pass-solution/3

 */
public class PartitionList {
    public static ListNode partition(ListNode A, int B) {
        ListNode current = A;
        ListNode partition1 = new ListNode(0);
        ListNode hd1 = partition1;

        ListNode partition2 = new ListNode(0);
        ListNode hd2 = partition2;

        while (current != null) {
            if (current.val < B) {
                partition1.next = current;
                partition1 = partition1.next;
            } else {
                partition2.next = current;
                partition2 = partition2.next;
            }
            current = current.next;
        }
        partition2.next = null;
        partition1.next = hd2.next;
        return hd1.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        ListNode node5 = partition(node1, 3);
        System.out.println(node5);
    }

}
