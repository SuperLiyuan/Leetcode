package daily.ongoing.finished;

import model.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode_382 {

        List<Integer> allValue = new ArrayList<>();
        public LinkedListRandomNode_382(ListNode head) {
            while (head.next != null) {
                allValue.add(head.val);
                head = head.next;
            }
        }

        public int getRandom(){
            int arrSize = allValue.size();
            //从0.0到1随机生成一个数 把它当成百分比
            Random random = new Random();
            int randomInt = random.nextInt(arrSize);
            return allValue.get(randomInt);

        }
    }





