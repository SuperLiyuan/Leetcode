package Leetcode75;

import model.ListNode;

public class SortList_148 {
    public ListNode sortList(ListNode head) {
        //看完题解感觉救命啊……
        if(head == null) return null;
        int len = 0;
        ListNode n = head;
        while(n!=null){
            len ++;
            n = n.next;
        }
        ListNode dummy = new ListNode(0, head);

        for(int interval = 1;interval < len;interval = interval * 2){
            ListNode prev = dummy;
            ListNode curr = dummy.next;
            //curr 遍历整个链表 分成很多个小链表
            while(curr !=null){
                ListNode head1 = curr;

                for(int i = 1;i<interval && curr!=null && curr.next!=null; i++){
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                //断开第一个链表，待会merge会连起来的
                curr.next = null;
                curr = head2;
                //有可能i还没到interval 就到末尾了
                for(int i = 1;i<interval && curr!=null && curr.next!=null;i++){
                    curr = curr.next;
                }
                ListNode next = null;
                if(curr != null){
                    next = curr.next;
                    //断开第二个链表
                    curr.next = null;
                }

                ListNode mergedList = merge(head1, head2);
                prev.next = mergedList;
                while(prev.next!=null){
                    prev = prev.next;
                }
                curr = next;

            }
        }
        return dummy.next;
    }

    public ListNode merge(ListNode l1, ListNode l2){

        //合并两个有序链表
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1!=null && p2!=null){
            if(p1.val < p2.val){
                curr.next = p1;
                p1 = p1.next;
            }else {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;

        }
        if(p1!=null){
            curr.next = p1;
        }else if(p2!=null){
            curr.next = p2;
        }
        return dummy.next;


    }
}
