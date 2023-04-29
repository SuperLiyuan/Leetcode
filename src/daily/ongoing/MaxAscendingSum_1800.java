package daily.ongoing;

public class MaxAscendingSum_1800 {
    public int maxAscendingSum(int[] nums) {

        int max = nums[0];
        int curr = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                curr += nums[i];
            }else{
                curr = nums[i];
            }
            if(curr > max){
                max = curr;
            }
        }
        return max;
    }
}
