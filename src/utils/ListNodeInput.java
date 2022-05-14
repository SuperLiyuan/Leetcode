package utils;

import model.ListNode;

public class ListNodeInput {

    public static ListNode run(String input){

        String[] splitStr = input.split(",");

        ListNode root = new ListNode(0);
        ListNode rootHead = root;
        for(int i = 0;i<splitStr.length;i++){
            root.val = Integer.parseInt(splitStr[i]);
            if(i<splitStr.length-1) {
                root.next = new ListNode(0);
                root = root.next;
            }
        }
        return rootHead;


    }


}
