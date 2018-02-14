package com.booking.interviewbit.linkedlist;

import java.util.HashSet;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

   Try solving it using constant additional space.

    https://leetcode.com/problems/linked-list-cycle/solution/
 *
 */
public class ListCycle {

    public ListNode detectCycleTwoRunners(ListNode a) {
        ListNode fast = a;
        ListNode slow = a;

        boolean hasCycle = false;
        while(fast != null && fast.next != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return null;
        } else {
            fast = a;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return fast;
    }

    public ListNode detectCycleHashSet(ListNode a) {

        HashSet<ListNode> h = new HashSet<ListNode>();

        while(a!=null) {
            if(h.contains(a)){
                return a;
            }
            h.add(a);
            a=a.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;
        while(fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }

}
