package io.haitaoc.leetcode.list;

import io.haitaoc.util.ListNode;
import io.haitaoc.util.ListNodeUtil;

public class Leet_83_RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
        ListNode prev = head;
        ListNode cur = prev.next;
        while(cur!=null){
            if(prev.val!=cur.val){
                prev.next = cur;
                prev = cur;
            }                   // cur 与 prev值相同时只移动cur
            cur = cur.next;
        }
        if(prev!=cur)           // 如果prev!=cur说明cur到了最后且之前有重复数字
            prev.next = cur;
        return head;
    }

    public static void main(String[] args){
        int[] arr={1,1,2,3,3};
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        ListNode head = listNodeUtil.createLinkedList(arr,5);

        listNodeUtil.printLinkedList(new Leet_83_RemoveDuplicatesfromSortedList().deleteDuplicates(head));
    }
}
