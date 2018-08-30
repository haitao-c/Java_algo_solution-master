package io.haitaoc.leetcode.list;

import io.haitaoc.util.ListNode;
import io.haitaoc.util.ListNodeUtil;

public class Leet_21_MergeTwoSortedLists {
    public ListNode mergeTwoListsImprov(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(-1);
        ListNode dummyCur = dummyHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while(cur1!=null&&cur2!=null){
            if(cur1.val<cur2.val){
                dummyCur.next = cur1;
                cur1 = cur1.next;
            }
            else{
                dummyCur.next = cur2;
                cur2 = cur2.next;
            }
            dummyCur = dummyCur.next;

        }
        if(cur1!=null)
            dummyCur.next=cur1;
        else
            dummyCur.next = cur2;
        return dummyHead.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode dummyCur = dummyHead;

        if(l1==null){
            dummyHead.next = l2;
            return dummyHead.next;
        }

        if(l2==null){
            dummyHead.next = l1;
            return dummyHead.next;
        }

        if(l1==null&&l2==null)
            return dummyHead.next;

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(true){
            if(cur1.val<=cur2.val){
                ListNode insert = cur1;
                dummyCur.next = insert;
                cur1 = cur1.next;
                dummyCur = dummyCur.next;
            }else{
                ListNode insert = cur2;
                dummyCur.next = insert;
                cur2 = cur2.next;
                dummyCur = dummyCur.next;
            }
            if(cur1==null){
                dummyCur.next = cur2;
                break;
            }
            if(cur2==null){
                dummyCur.next = cur1;
                break;
            }

        }
        return dummyHead.next;
    }

    public static void main(String[] args){
        int[] arr1={2};
        int[] arr2={1};
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        ListNode head1 = listNodeUtil.createLinkedList(arr1,1);
        ListNode head2 = listNodeUtil.createLinkedList(arr2,1);
        listNodeUtil.printLinkedList(new Leet_21_MergeTwoSortedLists().mergeTwoListsImprov(head1,head2));

    }

}
