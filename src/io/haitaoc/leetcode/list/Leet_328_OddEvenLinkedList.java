package io.haitaoc.leetcode.list;

import io.haitaoc.util.ListNode;
import io.haitaoc.util.ListNodeUtil;

public class Leet_328_OddEvenLinkedList {
    // 原地扩展两个链表再组合

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode oddP = odd;
        ListNode evenP = even;
        while (evenP != null && evenP.next != null) {
            oddP.next = evenP.next;
            oddP = evenP.next;
            evenP.next = oddP.next;
            evenP = oddP.next;
        }
        oddP.next = even;
        return odd;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        ListNode head = listNodeUtil.createLinkedList(arr, 5);
        listNodeUtil.printLinkedList(new Leet_328_OddEvenLinkedList().oddEvenList(head));

    }
}
