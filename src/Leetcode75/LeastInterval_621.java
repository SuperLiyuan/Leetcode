package Leetcode75;

import java.util.Arrays;

public class LeastInterval_621 {
    public int leastInterval(char[] tasks, int n) {
        int[] times = new int[26];
        for(int i = 0;i<tasks.length;i++){
            times[tasks[i] - 'A'] ++;
        }
        Arrays.sort(times);
        int maxTask = times[25];
        int countMax = 0;
        for(int i = 25;i>0;i--){
            if(times[i] == maxTask){
                countMax++;
            }
        }

        return Math.max((maxTask - 1) * (n + 1) + countMax, tasks.length);



    }
}
