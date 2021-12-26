package leetcode.finished;

import java.util.ArrayList;
import java.util.List;

public class MinCostClimbingStairs_70 {

    public static int run(int[] cost){

        List<Integer> everydayCost = new ArrayList<>(cost.length);
        for(int i =0;i<cost.length;i++){
            everydayCost.add(0);
        }
        //动态规划,第n步最小=min{第n-1步最小+1，第n-1步最小+2}
        int nextOneOrTwo = 0;
        int min = Math.min(cost[0],cost[1]);
        nextOneOrTwo = min == cost[0]?0:1;


        for(int i=nextOneOrTwo;i<cost.length;i = i+nextOneOrTwo){
            everydayCost.set(i, min);
            if(i+2<cost.length) {
                //如果相同怎么办？
                min = Math.min(everydayCost.get(i)+cost[i+1],everydayCost.get(i)+cost[i+2]);
                nextOneOrTwo = min == everydayCost.get(i)+cost[i+2]?2:1;

            }else{
                min=0;
                nextOneOrTwo = 9;
            }

        }
        return everydayCost.get(everydayCost.size()-1);

    }

}
