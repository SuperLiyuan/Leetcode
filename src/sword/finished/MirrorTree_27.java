package sword.finished;

import model.TreeNode;

public class MirrorTree_27 {

    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

}
