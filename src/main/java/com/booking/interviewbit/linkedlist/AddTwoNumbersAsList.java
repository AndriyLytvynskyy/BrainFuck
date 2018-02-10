package com.booking.interviewbit.linkedlist;


import java.util.Queue;
import java.util.Stack;

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Add 2 numbers represnted by linked lists
 * https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists
 *
 *
 */
public class AddTwoNumbersAsList {

    public ListNode addTwoNumbers_less_memory(ListNode first, ListNode second){
        ListNode res = null; // res is head node of the resultant list
        ListNode prev = null;
        ListNode temp = null;
        int carry = 0, sum;

        while (first != null || second != null) //while both lists exist
        {
            // Calculate value of next digit in resultant list.
            // The next digit is sum of following things
            // (i)  Carry
            // (ii) Next digit of first list (if there is a next digit)
            // (ii) Next digit of second list (if there is a next digit)
            sum = carry + (first != null ? first.val : 0)
                    + (second != null ? second.val : 0);

            // update carry for next calulation
            carry = (sum >= 10) ? 1 : 0;

            // update sum if it is greater than 10
            sum = sum % 10;

            // Create a new node with sum as data
            temp = new ListNode(sum);

            // if this is the first node then set it as head of
            // the resultant list
            if (res == null) {
                res = temp;
            } else // If this is not the first node then connect it to the rest.
            {
                prev.next = temp;
            }

            // Set prev for next insertion
            prev = temp;

            // Move first and second pointers to next nodes
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        // return head of the resultant list
        return res;

    }

    public static int revertDamnNode(ListNode head){
        if (head.next == null){
            return head.val;
        }
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        Stack<String> stack = new Stack<>();

        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            stack.push(String.valueOf(prev.val));
            current = next;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return Integer.valueOf(sb.toString());
    }
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
            int result = Integer.reverse(revertDamnNode(A) + revertDamnNode(B));
            String str = String.valueOf(result).replaceAll("0*$", "");
            Integer number = Integer.parseInt(str);

            ListNode head = new ListNode(0);
            ListNode current = head;
            while (number > 0) {
                int digit = ( number % 10);
                if (head.val == 0 && (digit != 0)){
                    head.val = digit;
                } else {
                    current.next = new ListNode(digit);
                    current = current.next;
                }
            }


            return head;
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
        System.out.println(revertDamnNode(node1));
        String s = "8070";
        String k = s.replaceAll("0*$", "");
        System.out.println(k);
    }

}
