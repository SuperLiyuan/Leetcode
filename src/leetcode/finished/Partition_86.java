package leetcode.finished;

import model.ListNode;

public class Partition_86 {


    public static ListNode run(ListNode head, int x){
        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode currNode = head;
        small.next = head;
        large.next = head;
        smallHead = small;
        largeHead = large;

        if(head == null) return null;

        while(currNode !=null){

            if(currNode.val>=x){
                large.next = currNode;
                large=large.next;
            }
            else{
                small.next = currNode;
                small = small.next;
            }
            currNode = currNode.next;
        }

        large.next = null;

        small.next  = largeHead.next;

        return smallHead.next;


    }
}
