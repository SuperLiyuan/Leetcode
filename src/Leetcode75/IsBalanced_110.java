package Leetcode75;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsBalanced_110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(depth(root.left) - depth(root.right))>1){
            return false;
        }
        return true;
    }

    public int depth(TreeNode n){
        Queue<TreeNode> q = new LinkedList();
        q.offer(n);
        int res = 0;
        while(q.size()>0){
            int size = q.size();
            while(size>0){
                TreeNode node = q.poll();
                size--;
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
        }
        return res;

    }
}
