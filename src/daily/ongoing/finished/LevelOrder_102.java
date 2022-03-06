package daily.ongoing.finished;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root ==null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> thisLevelList = new ArrayList<>();
            int n=q.size();
            for(int i = 0;i<n;i++){
                TreeNode currNode = q.poll();
                thisLevelList.add(currNode.val);
                if(currNode.left!=null){
                    q.offer(currNode.left);
                }
                if(currNode.right!=null)q.offer(currNode.right);

            }
            ans.add(thisLevelList);

        }
        return ans;

    }

}
