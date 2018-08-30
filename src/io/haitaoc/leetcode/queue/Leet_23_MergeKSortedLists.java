package io.haitaoc.leetcode.queue;

import java.util.PriorityQueue;
import java.util.Queue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Leet_23_MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
            if(lists==null||lists.length==0)
                return null;
            Queue<ListNode> pq = new PriorityQueue<>((ListNode node1, ListNode node2)->(Integer.compare(node1.val,node2.val)));
            for (ListNode node : lists){
                if(node!=null)
                    pq.offer(node);
            }
            ListNode res = new ListNode(0);
            // pointer指向res的同一块内存 pointer.next 就是res.next
            ListNode pointer = res;
            //System.out.println(res==pointer);
            while(!pq.isEmpty()){
                pointer.next = pq.poll();
                // pointer后移
                pointer = pointer.next;
                if(pointer.next!=null)
                    pq.offer(pointer.next);
            }

            return res.next;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        ListNode node3 = new ListNode(2);
        node3.next= new ListNode(6);
        ListNode[] lists = {node1,node2,node3};
        System.out.println(new Leet_23_MergeKSortedLists().mergeKLists(lists).val);
    }
}
