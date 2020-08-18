package com.study.leet;

/**
 * @author andrii_lytvynskyi
 *
 * https://www.geeksforgeeks.org/reverse-a-linked-list/
 */

public class AddTwoNumbers {
    public static ListNode reverseList(ListNode l) {
       ListNode newHead;
        if (l.next == null) {
            return l;
        }
        newHead = reverseList(l.next);
        newHead.next.next = l;
        newHead.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;

        ListNode newNode = reverseList(node1);
        System.out.println(newNode);
    }
}
