package weekly.contest.week302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumSum {
    public int maximumSum(int[] nums) {
        //看这数量级感觉有什么trick但是又想不出来
        //1000000000 - 999999999 - 81 和只能从1-81
        List[] sums = new ArrayList[82]; // 3 代表： i j
        boolean[] paired = new boolean[82];
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            int tmp = nums[i];
            while(tmp > 0){
                sum += tmp % 10;
                tmp = tmp / 10;
            }
            List l = sums[sum];
            if(l == null){
                l = new ArrayList();
            }
            l.add(nums[i]);
            sums[sum] = l;
        }
        int max = -1;
        for(int i =0;i<sums.length;i++){
            List<Integer> l = sums[i];
            if(l != null){
                Collections.sort(l);
                if(l.size()>=2){
                    if(l.get(l.size()-1)+ l.get(l.size()-2)> max){
                        max = l.get(l.size()-1) + l.get(l.size()-2);
                    }
                }
            }
        }
        return max;
    }
}
