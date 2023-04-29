package daily.ongoing.finished;

import model.TreeNode;

public class DeepestLeavesSum {

    int maxTreeDepth;
    int res = 0;
    public int deepestLeavesSum(TreeNode root) {
        maxTreeDepth = findDepth(root, 0);
        findSum(root, 0);
        return res;
    }


    public int findDepth(TreeNode root, int currDepth){
        if(root == null){
            return 0;
        }
        if(root.left != null || root.right != null){
            currDepth ++;
            return Math.max(findDepth(root.left, currDepth), findDepth(root.right, currDepth));
        }
        return currDepth;
    }

    public int findSum(TreeNode root, int currDepth){
        if(root == null){
            return 0;
        }
        if(root.left != null || root.right != null){
            currDepth ++;
            return  Math.max(findSum(root.left, currDepth), findSum(root.right, currDepth));
        }
        if(currDepth == maxTreeDepth){
            res += root.val;
        }
        return currDepth;
    }

}
