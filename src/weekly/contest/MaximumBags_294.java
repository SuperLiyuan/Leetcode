package weekly.contest;

import java.util.Arrays;

public class MaximumBags_294 {
    public int run(int[] capacity, int[] rocks, int additionalRocks) {
        int[] diff = new int[capacity.length];
        for(int i =0;i<diff.length;i++){
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        int cnt = 0;
        //所有背包都装满，或者石头用完
        for(int i=0;i<diff.length;i++){
            //已经满了
            if(diff[i] == 0){
                cnt ++;
            }else{
                //拿出一些石头放满diff
                additionalRocks = additionalRocks - diff[i];
                //石头刚好用完或者还有剩
                if(additionalRocks >= 0){
                    cnt ++;
                }
            }
        }
        return cnt;
    }
}
