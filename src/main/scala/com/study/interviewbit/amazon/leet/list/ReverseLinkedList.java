package com.study.interviewbit.amazon.leet.list;

/**
 * @author andrii_lytvynskyi
 */

class A {
    int a = 10;
}

class B {

}
public class ReverseLinkedList {

    public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;

        }
        return prev;
    }

    public static ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode node = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;


        return node;
    }

    public static void main(String[] args) {
        A a = new A();
        A tmp = a;
        a.a = 20;
        a = null;

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
      //  l1.next.next = new ListNode(3);
        ListNode revertedList = reverseListRec(l1);
        System.out.println(revertedList);
    }
}
