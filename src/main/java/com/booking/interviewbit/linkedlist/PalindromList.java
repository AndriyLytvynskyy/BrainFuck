package com.booking.interviewbit.linkedlist;

public class PalindromList {
    public void exchange2Numbers (int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }
    public static ListNode revertDamnNode12(ListNode head){
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

    public static ListNode revertDamnNode(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode h = head;
        ListNode nextNode = head.next;
        ListNode tmpNode;
        head.next= null;
        while (nextNode != null){
            tmpNode = nextNode.next;
            nextNode.next = h;
            h = nextNode;
            nextNode = tmpNode;
        }
        return h;
    }
    public int lPalin(ListNode head) {
        if (head == null ||
                head.next == null) {
            return 1;
        }
        ListNode s, f;
        s = head;
        f = head;
        while (f != null &&
                f.next != null) {
            f = f.next.next;
            s = s.next;
        }

        if (f != null) {
            s = s.next;
        }

        ListNode l = head;
        ListNode r = reverse(s);

        while (r != null) {
            if (l.val != r.val) {
                return 0;
            }
            l = l.next;
            r = r.next;
        }

        return 1;
    }

    private static ListNode reverse(ListNode l) {
        if (l == null ||
                l.next == null) {
            return l;
        }

        ListNode p1 = l,
                p2 = l.next,
                p3;
        l.next = null;
        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }

        return p1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = null;

        ListNode node4 = revertDamnNode12(node1);
        ListNode node5 = reverse(node1);
        System.out.println(node4);
    }
}
