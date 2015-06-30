package com.booking.linkedlist;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrii_Lytvynskyi on 6/30/2015.
 */
public class ReturnLinkedListNElements {
    static class LinkedListNode {
        LinkedListNode next;
        String data;

    }

//    public static LinkedListNode nToLastElement(LinkedListNode head, int k) {
//
//        LinkedListNode noderesult = head;
//        if (noderesult != null) {
//            LinkedListNode i = nToLastElement(head.next, k);
//
//
//        }
////        LinkedListNode i = nToLastElement(head.next, k) + 1;
////        if (head.next == null){
////            System.out.println(head.data);
////        }
////        if (i == k){
////            System.out.println(head.data);
////
////        }
////        return i;
//    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode();
        head.data = "head";
        LinkedListNode node1 = new LinkedListNode();
        node1.data = "node 1";
        LinkedListNode node2 = new LinkedListNode();
        node2.data = "node 2";
        LinkedListNode node3 = new LinkedListNode();
        node3.data = "node 3";

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        //nToLastElement(head, 1);
        LinkedListNode result = nthToLastR2(head, 1, new IntWrapper());
        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        // from 3d till last element
//         for (int i = 3; i< list.size();i++ ){
//            System.out.println(list.get(i));
//        }


    }


    static class IntWrapper {
        public int value = 0;
    }

    static LinkedListNode nthToLastR2(LinkedListNode head, int k,
                               IntWrapper i) {
        if (head == null) {
            return null;
        }
        LinkedListNode node = nthToLastR2(head.next, k, i);
        i.value = i.value + 1;
        if (i.value == k) { // We've found the kth element
            return head;
        }
        return node;
    }
}
