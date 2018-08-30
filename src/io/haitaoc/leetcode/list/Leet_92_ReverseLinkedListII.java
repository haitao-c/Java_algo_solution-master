package io.haitaoc.leetcode.list;

import io.haitaoc.util.ListNode;
import io.haitaoc.util.ListNodeUtil;

public class Leet_92_ReverseLinkedListII {

    // 按照206题的思路  对局部进行翻转再拼接
    public ListNode reverseBetween2(ListNode head, int m, int n){
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i <m-1 ; i++)
            prev = prev.next;       // 标记到第m位之前
        ListNode before = prev;     // 存下这个标记值
        prev = prev.next;           // 第m个位置
        ListNode end = prev;        // 翻转的最后一个数就这个第m位置上的数
        int count =0;
        ListNode cur = prev.next;
        while(count!=n-m){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur=next;
            count++;
        }
        before.next = prev;
        end.next = cur;
        return dummy.next;

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;



    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int m = 2, n = 4;
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        ListNode head = listNodeUtil.createLinkedList(arr, 5);
        listNodeUtil.printLinkedList(new Leet_92_ReverseLinkedListII().reverseBetween2(head, m, n));

    }

}
