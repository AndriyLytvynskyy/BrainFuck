package com.study.interviewbit.amazon.leet.list

/**
 *
 * @author andrii_lytvynskyi
 */
class ReverseLinkedListScala {
  def reverseList(head: ListNode): ListNode = {
    def reverseListHelper(head: ListNode, acc: ListNode): ListNode = {
        if (head.next == null) {
          acc.`val` = head.`val`
        } else {
          reverseListHelper(head.next, acc)
        }
      acc
    }
    reverseListHelper(head, new ListNode(0))

  }



}
