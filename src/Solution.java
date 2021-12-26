import model.ListNode;

import java.util.*;

import static java.util.Objects.isNull;

class Solution {
    private static String[] letterMap = {
            "",//0
            "",//1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    public static List<String> letterCombinations(String digits) {

        LinkedList<String> resList = new LinkedList<String>();

        StringBuilder combination = new StringBuilder();

        if(!"".equals(digits))
            traceback(0, digits, combination, resList);

        return resList;

    }

    public static void traceback(int pos, String input, StringBuilder currCombination, LinkedList<String> resList){

        //最后一位了
        if(pos == input.length()){
            System.out.println(currCombination.toString());
            resList.add(currCombination.toString());
            currCombination = new StringBuilder();
            return;
        }

        //数字对应的字母
        String lettersForCurrPos = letterMap[input.charAt(pos)-'0'];
        for(int i=0;i<lettersForCurrPos.length();i++){
            currCombination.append(lettersForCurrPos.charAt(i));
            traceback(pos+1,input,currCombination,resList);
            currCombination.deleteCharAt(currCombination.length()-1);
        }



    }


    public static List<String> generateParenthesis(int n) {

        StringBuilder combination = new StringBuilder();
        List<String> resList = new ArrayList<String>();
        int left = n;
        int right = n;
        if(n == 0) return null;
        else trace(left, right, combination, resList);
        System.out.println(resList);
        return resList;
    }

    public static void trace(int left, int right, StringBuilder combination, List<String> resList){

        if(left == right && right==0){
            resList.add(combination.toString());
            combination = new StringBuilder();
            return;
        }

        else if(left>right) return;
        else if(left<0) return;

        else{
                //左括号
                combination.append('(');
                trace( left-1, right,combination, resList);
                //删掉左括号
                combination.deleteCharAt(combination.length()-1);
                //右括号
                combination.append(')');
                trace(left,right-1,combination,resList);
                //删掉右括号
                combination.deleteCharAt(combination.length()-1);


        }

    }



    public static String longestPalindrome(String s) {

        if(s.equals(""))
            return s;
        int len = s.length();
        boolean[][] isPd = new boolean[len][len];
        //奇数
        for(int i=0;i<len;i++){
            isPd[i][i]=true;
            if(i<len-1&&s.charAt(i)==s.charAt(i+1)){

                isPd[i][i+1]=true;

            }
        }
        int start = 0;
        int end = 0;
        String subStr = new String();
        //从第2个元素开始
        for(int right=1;right<len;right++){
            for(int left=right-1;left>=0;left--) {
                if((isPd[left+1][right-1]||right-left<3)&&s.charAt(right)==s.charAt(left)){
                    isPd[left][right]=true;
                    if(right-left>end-start) {
                        start = left;
                        end = right;
                    }
//                    subStr = s.substring(start, end);
                }
            }
        }

        return s.substring(start, end+1);


    }

    public static int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;
        if(needle.length()>haystack.length()) return -1;
        for(int pos=0;pos<haystack.length();pos++){
            if(haystack.charAt(pos)==needle.charAt(0)){
                int needlePos;
                for(needlePos = 0;needlePos<needle.length();needlePos++){
                    if(haystack.charAt(pos+needlePos)!=needle.charAt(needlePos))
                        break;
                }
                if(needlePos == needle.length())
                    return pos;
            }
        }
        return -1;
    }


    public static int removeElement(int[] nums, int val) {

        Arrays.sort(nums);
        int len = nums.length;

        for(int pos = 0;pos<len;){
            if(nums[pos]==val){
                System.arraycopy(nums, pos + 1, nums, pos, nums.length - pos-1);
                len--;
                if(pos>0) pos--;
            }
            else pos++;

        }

        return len;

    }

    //TODO
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }
        else if(l1==null){
            return l2;
        }
        else if(l2==null){
            return l1;
        }

        ListNode tempL1 = new ListNode(0);
        ListNode tempL2 = new ListNode(0);
        ListNode prevNode = l2;
        tempL2 = l2;
        if(l2.next!=null)
            l2 = l2.next;
        else l2 = null;

        while(l1!=null && l2!=null){


            if(l1.val> prevNode.val){
                prevNode = l2;
                l2 = l2.next;
            }

            else{

                prevNode.next = l1;
                prevNode = l1;
                tempL1 = l1.next;
                l1.next = l2;
                l1 = tempL1;

            }


        }

        if(l1!=null){
            prevNode.next = l1;
        }

        return tempL2;


    }


    public String countAndSay(int n) {
        String prev = "1";
        StringBuilder currBuilder = new StringBuilder();
        String curr = "";
        int cnt=0;
        char currNum;

        //n次
        for(int i=0;i<n;i++){

            for(int pos = 0;pos<prev.length();){
                currNum = prev.charAt(pos);
                cnt=1;
                //字符串长度为1或到达字符串结尾
                if(pos+1==prev.length()){

                }
                else{
                    while(prev.charAt(pos)==prev.charAt(pos+1)){
                        pos++;
                        cnt++;
                    }
                    if(cnt==1) pos++;
                }

            }

        }

        return curr;
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] newArr = new int[length1+length2];
        boolean isOdd = false;
        int mid;
        //数组排序后为奇数,则取最中间一位数
        if((length1+length2)%2 == 1) {

            isOdd = true;
            mid = (length1+length2-1)/2 ;
        }else{
            isOdd = false;
            mid = (length1+length2)/2;
        }
        int pos1 = 0;
        int pos2 = 0;
        int newArrPos = 0;
        while(pos1<length1&&pos2<length2) {

                if (nums1[pos1] < nums2[pos2]) {
                    newArr[newArrPos++] = nums1[pos1++];
                } else if (nums1[pos1] > nums2[pos2]) {
                    newArr[newArrPos++] = nums2[pos2++];
                } else if (nums1[pos1] == nums2[pos2]) {
                    newArr[newArrPos++] = nums1[pos1++];
                    newArr[newArrPos++] = nums2[pos2++];
                }

        }
        while(pos1<length1){

            newArr[newArrPos++] = nums1[pos1++];

        }
        while(pos2<length2){

            newArr[newArrPos++] = nums2[pos2++];

        }

        if(isOdd){
            return newArr[mid];
        }else
            return (newArr[mid] + newArr[mid - 1]) / 2.000;

    }



    public ListNode removeNthFromEnd(ListNode head, int n) {
        //看了题解写的，快慢指针，我自己肯定是没想到
        ListNode back = head;
        ListNode forward = head;
        for(int i=0;i<n;i++){
            forward = forward.next;
        }
        while(forward.next!=null){
            back = back.next;
            forward = forward.next;

        }

        back.next = back.next.next;

        return head;

    }


    public static int lengthOfLongestSubstring(String s) {

        int pos=0;
        int count = 0;
        int maxCount = 0;
        Map<Character, Integer> letterPos = new HashMap<>();

        while(pos<s.length()){

            char curr = s.charAt(pos);

            //存在重复字符
            if(letterPos.containsKey(curr)){

                //从第一次重复的字符的后一个重新开始数
                pos = letterPos.get(curr)+1;
                letterPos.clear();
                letterPos.put(s.charAt(pos), pos);

                count = 1;
                pos++;
            }

            else {

                letterPos.put(curr, pos);

                pos += 1;
                count +=1;
                if(count>maxCount) maxCount=count;
            }


        }

        return maxCount;

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int l1Val = 0;
        int l2Val = 0;
        int currNum = 0;
        boolean carry = false;
        ListNode res = new ListNode(0);
        ListNode resNode = res;
        //最后一个有值的node
        ListNode rearNode = resNode;
        while(l1!=null&& l2!=null){

            if(carry) {
                currNum = l1.val + l2.val + 1;
                carry = false;
            }
            else{
                currNum = l1.val + l2.val;
            }

            if(currNum>=10){
                carry = true;
                currNum = currNum - 10;
            }

            resNode.val = currNum;
            ListNode nextNode = new ListNode(0);
            resNode.next = nextNode;
            rearNode = resNode;
            resNode = nextNode;

            l1 = l1.next;
            l2 = l2.next;


        }
        if(l1!=null){
            rearNode.next = l1;
            while(carry){
                l1.val=l1.val+1;
                //不会有大于10的情况
                //考虑一直进位的情况。。。
                if(l1.val==10){
                    l1.val = 0;
                    carry = true;
                    if(l1.next!=null)
                        l1 = l1.next;
                    else{
                        l1.next = new ListNode(1);
                        carry = false;
                    }
                }else{
                    carry = false;
                }
            }



        }
        else if(l2!=null){
            rearNode.next = l2;
            while(carry){
                l2.val=l2.val+1;
                //不会有大于10的情况
                //考虑一直进位的情况。。。
                if(l2.val==10){
                    l2.val = 0;
                    carry = true;
                    if(l2.next!=null)
                        l2 = l2.next;
                    else{
                        l2.next = new ListNode(1);
                        carry = false;
                    }
                }else{
                    carry = false;
                }
            }

        }
        else{
            if(carry){
                rearNode.next = new ListNode(1);
            }
            else rearNode.next = null;
        }





        return res;



    }



}