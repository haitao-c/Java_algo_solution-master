package io.haitaoc.leetcode.list;

import io.haitaoc.util.ListNode;
import io.haitaoc.util.ListNodeUtil;

public class Leet_82_RemoveDuplicatesII {

    public ListNode deleteDuplicates(ListNode head) {

       if(head==null||head.next==null)
           return head;

       // 创建虚节点头
       ListNode dummyHead = new ListNode(-1);
       dummyHead.next = head;

       ListNode prev = dummyHead;
       ListNode cur = head;

       while(cur.next!=null){
           if(cur.next.val!=cur.val)
           {
              if(prev.next==cur)
                  prev=cur;
              else
                  prev.next=cur.next;
           }
           cur = cur.next;
       }
       // 如果prev.next!=cur 说明cur在遍历过程中遇到很多相同值, 且以这个值结尾
       if(prev.next!=cur)
           prev.next = cur.next;

       return dummyHead.next;
    }

    public static void main(String[] args){
        int[] arr={1,1,1,2,3};
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        ListNode head = listNodeUtil.createLinkedList(arr,5);
        listNodeUtil.printLinkedList(new Leet_82_RemoveDuplicatesII().deleteDuplicates(head));

    }
}
