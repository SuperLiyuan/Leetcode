package daily.ongoing.finished;

public class MyCircularDeque_641 {

//链表呗。。。

    class ListNode{
        int val;
        ListNode next;
    }

    int maxLen;
    int currLen;
    //空的指针头
    ListNode head;
    //倒数第二个节点 其实我感觉不用要
    //ListNode prev;
    ListNode rear;


    public MyCircularDeque_641(int k) {
        maxLen = k;
        currLen = 0;
        head = new ListNode();
        rear = head;
        //prev = head;

    }

    public boolean insertFront(int value) {
        if(currLen == maxLen){
            return false;
        }
        ListNode newHead = new ListNode();
        newHead.val = value;
        newHead.next = head.next;
        head.next = newHead;
        currLen ++;
        if(rear == head){
            rear = head.next;
        }
        return true;
    }

    public boolean insertLast(int value) {
        if(currLen == maxLen){
            return false;
        }
        ListNode newRear = new ListNode();
        newRear.val = value;
        rear.next = newRear;
//        prev = rear;
        rear = newRear;
        currLen ++;
        return true;
    }

    public boolean deleteFront() {
        if(currLen == 0){
            return false;
        }
        //只有1个节点
        if(head.next == rear){
            rear = head;
        }
        head.next = head.next.next;
        currLen --;
        return true;
    }

    public boolean deleteLast() {
        if(currLen == 0){
            return false;
        }
        //我靠 这个怎么维护prev啊，要从head走下去吗。。。
        ListNode tempHead = head;
        while(tempHead.next.next != null && tempHead.next.next != rear){
            tempHead = tempHead.next;
        }
        if(tempHead.next.next == rear) {
            rear = tempHead.next;
            tempHead.next.next = null;
        //tempHead.next.next == null 也就是说此时只有一个节点
        }else{
            rear = head;
            head.next = null;
        }
        currLen --;
        return true;

    }

    public int getFront() {
        if(head.next == null ){
            return -1;
        }
        return head.next.val;
    }

    public int getRear() {
        if(currLen == 0){
            return -1;
        }
        return rear.val;
    }

    public boolean isEmpty() {
        if(currLen == 0){
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if(currLen == maxLen){
            return true;
        }
        return false;
    }
}
