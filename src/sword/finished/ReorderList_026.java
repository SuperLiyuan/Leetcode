package sword.finished;

import model.ListNode;

public class ReorderList_026 {
    public void run(ListNode head) {

        ListNode cnt = head;
        int len = 0;
        while(cnt!=null){
            len++;
            cnt = cnt.next;
        }
        ListNode h1 = head;
        ListNode h2 = head;
        ListNode pre = null;
        for(int i=0;i<Math.ceil(len/2.0);i++){
            pre = h2;
            h2 = h2.next;
        }
        //隔开两个链表
        pre.next = null;

        h2 = reverseNode(h2);
        ListNode next1;
        ListNode next2;
        while(h1!=null){
            if(h2 == null){
                break;
            }
            next1 = h1.next;
            next2 = h2.next;
            h2.next = next1;
            h1.next = h2;
            h1 = next1;
            h2 = next2;
        }


    }
    public ListNode reverseNode(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
