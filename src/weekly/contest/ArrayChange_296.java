package weekly.contest;

import java.util.HashMap;
import java.util.Map;

public class ArrayChange_296 {
    public int[] run(int[] nums, int[][] operations) {
        //用一个hashmap放入<num,index>，遍历operations更新
        Map<Integer, Integer> numIndex = new HashMap<>();
        int n = nums.length;
        int m = operations.length;
        for(int i = 0;i<n;i++){
            numIndex.put(nums[i], i);
        }
        for(int i =0;i<m;i++){
            int index = numIndex.get(operations[i][0]);
            nums[index] = operations[i][1];
            numIndex.put(operations[i][1], index);
            numIndex.remove(operations[i][0]);
        }
        return nums;
    }
}
