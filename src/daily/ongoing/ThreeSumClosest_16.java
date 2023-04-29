package daily.ongoing;

import java.util.Arrays;

public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 30000;
        for(int i = 0;i<nums.length-2;i++){
            int rest = target - nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                if(Math.abs(target - nums[i] - nums[left] - nums[right])
                        < Math.abs(target - closest)){
                    closest = nums[i] + nums[left] + nums[right];
                }
                if(nums[left] + nums[right] == rest){
                    return closest;
                }else if(nums[left] + nums[right] < rest){
                    left ++;
                }else if(nums[left] + nums[right] > rest){
                    right --;
                }
            }
        }
        return closest;
    }
}
