package io.haitaoc.leetcode.list;

import io.haitaoc.util.ListNode;
import io.haitaoc.util.ListNodeUtil;

public class Leet_86_PartitionList {

    public ListNode partition(ListNode head, int x) {
        if(head==null)
            return head;
        // 借助两个额外的链表  比x大的放greater 小的放smaller
        ListNode greater = new ListNode(-1);
        ListNode smaller = new ListNode(-1);
        ListNode great= greater;
        ListNode small = smaller;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val<x){
                small.next = cur;
                small = cur;
            }else
            {
                great.next = cur;
                great = cur;
            }
            cur = cur.next;
        }
        great.next = null;
        small.next = greater.next;
        return smaller.next;
    }


    public static void main(String[] args){
        int[] arr={1,4,3,2,5,2};
        int x = 3;
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        ListNode head = listNodeUtil.createLinkedList(arr,6);
        listNodeUtil.printLinkedList(new Leet_86_PartitionList().partition(head,x));

    }
}
