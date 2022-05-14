import model.ListNode;
import sword.finished.IsPalindrome_018;
import sword.finished.ongoing.GetIntersectionNode;
import utils.ListNodeInput;

public class
Runnder {

    public static void main(String[] args){

        ListNode a = ListNodeInput.run("4,1,8,4,5");
        ListNode b = ListNodeInput.run("5,6,1,8,4,5");
        GetIntersectionNode g = new GetIntersectionNode();
        g.run(a,b);
    }

}
