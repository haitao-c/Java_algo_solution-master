package io.haitaoc.util;


import java.util.LinkedList;

public class ListNodeUtil {

    // 1.counts the number of  times a given int occurs in a list
    private int count(ListNode head, int searchFor){
        int count = 0;
        ListNode cur = head;            // 遍历时需要一个指针向链表后方移动
        while(cur.next!=null){
            ListNode node = cur.next;
            if(node.val==searchFor){
                count++;
            }
            cur = node;
        }
        return count;
    }

    public void countTest(){
        ListNode head = createLinkedList(new int[]{1,2,3},3);
        int count = count(head,2);
        System.out.println(count);
    }

    // 2 GetNth(): take a linked list and an integer value index returns the data value stored there
    private int getNth(ListNode head, int index){
        int count= 0;       // 计数当前访问链表中第几个元素
        ListNode cur = head;
        while(cur!=null){
            if(count==index)
                return cur.val;
            count++;
            cur = cur.next;
        }

        return 0;
    }

    public void getNthTest(){
        ListNode head = createLinkedList(new int[]{1,2,3},3);
        int lastNode = getNth(head,2);
        System.out.println(lastNode);
    }

    // 3. takes a list, deallocates all its memory and sets its head pointer to NULL
    private void deleteList(ListNode head){
        ListNode cur = head;
        ListNode next;
        while(cur!=null){
            next = cur.next;
            cur.next=null;
            cur = next;
        }
        head = null;
    }

    public void deleteTest(){
        ListNode head = createLinkedList(new int[]{1,2,3},3);
        deleteList(head);
    }



    public ListNode createLinkedList(int[] arr, int n){
        if(n==0)
            return null;
        ListNode head = new ListNode(arr[0]);

        ListNode curNode = head;
        for (int i = 1; i <n ; i++) {
            curNode.next=new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }

    public void printLinkedList(ListNode head){
        ListNode curNode = head;
        while(curNode!=null){
            System.out.print(curNode.val+" -> ");
            curNode=curNode.next;
        }

        System.out.print("NULL");
    }

    public static void main(String[] args) {
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        listNodeUtil.countTest();
        listNodeUtil.getNthTest();
    }
}
