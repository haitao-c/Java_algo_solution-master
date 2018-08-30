package io.haitaoc.leetcode.list;

import io.haitaoc.util.ListNode;

public class Leet_24_SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;
            ListNode next = node2.next;     // next一定存在 最多为空而已

            node2.next=node1;
            node1.next=next;
            p.next=node2;

            p = node1;      // node1是交换后的后一个节点
        }
        return dummyHead.next;
    }
}
