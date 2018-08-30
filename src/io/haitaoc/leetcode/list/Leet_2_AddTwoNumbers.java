package io.haitaoc.leetcode.list;

import io.haitaoc.util.ListNode;
import io.haitaoc.util.ListNodeUtil;

public class Leet_2_AddTwoNumbers {
    // 与21题遍历大致相同
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln1 = l1, ln2 = l2, head = null, node = null;
        int carry = 0, remainder = 0, sum = 0;
        head = node = new ListNode(0);

        while(ln1 != null || ln2 != null || carry != 0) {
            sum = (ln1 != null ? ln1.val : 0) + (ln2 != null ? ln2.val : 0) + carry;
            carry = sum / 10;
            remainder = sum % 10;
            node = node.next = new ListNode(remainder);
            ln1 = (ln1 != null ? ln1.next : null);
            ln2 = (ln2 != null ? ln2.next : null);
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 8};
        int[] arr2 = {0};

        ListNodeUtil listNodeUtil = new ListNodeUtil();
        ListNode head1 = listNodeUtil.createLinkedList(arr1, 2);
        ListNode head2 = listNodeUtil.createLinkedList(arr2, 1);
        listNodeUtil.printLinkedList(new Leet_2_AddTwoNumbers().addTwoNumbers(head1, head2));

    }
}
