package io.haitaoc.leetcode.list;

import io.haitaoc.util.ListNode;

public class Leet_203_RemoveLinkedListElements {

    public ListNode removeElementsImprov(ListNode head, int val){
        // 设置虚拟头结点解决问题
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;

        while(cur.next !=null){
            if (cur.next.val == val) {      // 删除cur.next
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;    // 释放内存
            } else
                cur = cur.next;
        }

        ListNode retNode = dummyHead.next;
        dummyHead = null;

        return retNode;

    }
    public ListNode removeElements(ListNode head, int val) {
        // 单独处理要删除头结点的情况
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = delNode.next;
            delNode = null;
        }
        ListNode cur = head;

        if(head==null)
            return null;

        while (cur.next != null) {
            if (cur.next.val == val) {      // 删除cur.next
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;    // 释放内存
            } else
                cur = cur.next;
        }
        return head;
    }


}
