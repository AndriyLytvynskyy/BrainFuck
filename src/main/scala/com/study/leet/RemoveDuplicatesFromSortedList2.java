package com.study.leet;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 *
 */
public class RemoveDuplicatesFromSortedList2 {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode t = new ListNode(0);
        t.next = head;

        ListNode p = t;
        while(p.next!=null&&p.next.next!=null){
            if(p.next.val == p.next.next.val){
                int dup = p.next.val;
                while(p.next!=null&&p.next.val==dup){
                    p.next = p.next.next;
                }
            }else{
                p=p.next;
            }

        }

        return t.next;

    }

    public static void main(String[] args) {
        ListNode ls = new ListNode(1);
        ListNode ls1 = new ListNode(2);
        ListNode ls2 = new ListNode(3);
        ListNode ls3 = new ListNode(3);
        ls.next = ls1;
        ls1.next = ls2;
        ls2.next = ls3;
        System.out.println(deleteDuplicates(ls));
    }
}
