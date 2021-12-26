import Utils.ListNodeInput;
import leetcode.finished.FindCircleNum_547;
import leetcode.finished.LevelOrder_102;
import leetcode.finished.Partition_86;
import model.TreeNode;

public class
Runnder {

    public static void main(String[] args){


        TreeNode t =new TreeNode(3);
        t.left =new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        LevelOrder_102.levelOrder(t);

        String nodeInput = "1->4->3->2->5->2";
        Partition_86.run(ListNodeInput.run(nodeInput),3);


        int[][] i= {{1,1,0},{1,1,0},{0,0,1}};
        FindCircleNum_547.run(i);
    }

}
