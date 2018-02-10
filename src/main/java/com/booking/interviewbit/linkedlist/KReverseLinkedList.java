package com.booking.interviewbit.linkedlist;

/**
 * Given a singly linked list and an integer K, reverses the nodes of the

 list K at a time and returns modified linked list.
 *
 *
 * Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,

    You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5
    Try to solve the problem using constant extra space.

    Break the list into buckets, then reverse each bucket:
 *
 */
public class KReverseLinkedList {
    public static ListNode revertDamnNode(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
    }
    public ListNode reverseList(ListNode A, int B) {

        int count = 0;
        ListNode current = A;
        ListNode prev = null;
        ListNode next = null;
           while (count < B && current != null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count ++;
            }
          if (next != null){
               A.next = reverseList(next, B);
          }
          return prev;
    }
     static void a(ListNode node, int x){
           node.val = 15;
           x = 25;
     }
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        int x = 5;

        a (a, x);
        System.out.println(x);
        System.out.println(a.val);
    }
}
