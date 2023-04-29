package daily.ongoing;

import model.TreeNode;

import java.util.Arrays;

public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {


        return construct(nums);
    }
    public TreeNode construct(int[] nums){
        if(nums.length == 0){
            return null;
        }
        int max = Arrays.stream(nums).max().getAsInt();
        int[] numPos = new int[max + 1];
        //numPos[2] = 3 说明数字2在nums里面下标是3
        for (int i = 0; i < nums.length; i++) {
            numPos[nums[i]] = i;
        }
        TreeNode root = new TreeNode(max);
        int pos = numPos[max];
        int[] leftArr = Arrays.copyOfRange(nums, 0, pos);
        root.left = construct(leftArr);
        root.right = construct(Arrays.copyOfRange(nums, pos+1, nums.length));
        return root;
    }
}
