package weekly.contest.week301;

import java.util.Arrays;

public class FillCups {

    public int run(int[] amount) {
        Arrays.sort(amount);
        int cnt = 0;
        while(amount[2]>0){
            amount[2] --;
            amount[1] --;
            cnt ++;
            Arrays.sort(amount);
        }
        return cnt;
    }

}
