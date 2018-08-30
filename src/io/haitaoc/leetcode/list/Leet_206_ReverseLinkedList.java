package io.haitaoc.leetcode.list;

import io.haitaoc.util.ListNode;
import io.haitaoc.util.ListNodeUtil;

public class Leet_206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;

            cur.next = pre;     // 做翻转
            pre = cur;          // 更新指针
            cur = next;
        }
        return pre;

    }

    public static void main(String[] args){
        int[] arr={1,2,3,4,5};
        ListNodeUtil l = new ListNodeUtil();
        ListNode head = l.createLinkedList(arr,5);
        l.printLinkedList( new Leet_206_ReverseLinkedList().reverseList(head));
    }

}
