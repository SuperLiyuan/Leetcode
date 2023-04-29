package Leetcode75;

import model.TreeNode;

import java.util.Arrays;

public class SortedArrayToBST_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
//找出中间值，然后左右分别再递归？
        int cnt = nums.length;

        TreeNode n= new TreeNode(nums[cnt/2]);
        if(cnt == 1){
            return n;
        }
        int[] leftNums = Arrays.copyOfRange(nums, 0, cnt / 2);
        if(cnt/2 + 1 < cnt) {
            int[] rightNums = Arrays.copyOfRange(nums, cnt / 2 + 1, cnt);
            n.right = sortedArrayToBST(rightNums);
        }else{
            n.right = null;
        }
        n.left = sortedArrayToBST(leftNums);
        return n;

    }

}
