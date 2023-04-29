package weekly.contest.week304;

import java.util.Arrays;

public class MinimumOperations {
    //我就老是想到桶排序
    public int minimumOperations(int[] nums) {
        int steps = 0;
        Arrays.sort(nums);

        //当最大值大于0
        while(nums[nums.length - 1] > 0){
            int[] bucket = new int[nums[nums.length-1]+1];
            for(int i =0;i<nums.length;i++){
                bucket[nums[i]] ++;
            }
            int startPos = 1;
            while(bucket[startPos] == 0){
                startPos ++;
            }
            int min = startPos;
            bucket[startPos] --;
            for(int i = 0;i<nums.length;i++){
                if(nums[i]>0) {
                    nums[i] = nums[i] - min;
                }
            }
            steps ++;
        }
        return steps;
    }
}
