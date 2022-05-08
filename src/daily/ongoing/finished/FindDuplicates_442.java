package daily.ongoing.finished;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates_442 {
    public static List<Integer> run(int[] nums){
        //4,3,2,7,8,2,3,1
        for(int i=0;i<nums.length;i++){
            while(nums[i] != nums[nums[i]-1]){
                swap(nums, i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i< nums.length;i++){
            if(nums[i] != i+1){
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    private static void swap(int[] nums, int i){
        int tmp = nums[nums[i]-1];
        nums[nums[i]-1] = nums[i];
        nums[i] = tmp;
    }
}
