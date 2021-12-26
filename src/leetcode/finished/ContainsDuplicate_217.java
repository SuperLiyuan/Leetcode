package leetcode.finished;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate_217 {

    public static boolean run(int[] nums) {
        Map<Integer,Integer> map =  new HashMap<>();
        for (int num:nums){
            if(map.get(num)!=null) {
                return false;
            }else{
                map.put(num,1);
            }

        }
        return true;
    }


}
