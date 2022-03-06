package daily.ongoing.finished;


import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainsNearbyDuplicate_219 {

    public boolean run(int[] nums, int k){
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(i>k){
                s.remove(nums[i-k-1]);
            }
            //有重复
            if(!s.add(nums[i])){
                return true;
            }
        }
        return false;
    }

}
