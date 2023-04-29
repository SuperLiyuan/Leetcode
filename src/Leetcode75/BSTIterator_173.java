package Leetcode75;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTIterator_173 {

    Stack<TreeNode> s;
    public BSTIterator_173(TreeNode root) {
        s = new Stack();
        while(root!=null){
            s.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode n = s.pop();
        TreeNode right = n.right;
        while(right !=null){
            s.push(right);
            right = right.left;
        }
        return n.val;
    }

    public boolean hasNext() {
        if(!s.empty()){
            return true;
        }
        return false;
    }

}