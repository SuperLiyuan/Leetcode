package weekly.contest;

import java.util.Arrays;

public class MinimumLines_294 {
    public int run(int[][] stockPrices) {
        Arrays.sort(stockPrices, (a,b)->a[0]-b[0]);
        int len = stockPrices.length;
        if(len <=1) return 0;
        if(len ==2) return 1;
        int preXDiff = stockPrices[1][0] - stockPrices[0][0];
        int preYDiff = stockPrices[1][1] - stockPrices[0][1];
        int cnt = 1;
        for(int i=2;i<stockPrices.length;i++){
            int currXDiff = stockPrices[i][0] - stockPrices[i-1][0];
            int currYDiff = stockPrices[i][1] - stockPrices[i-1][1];
            //要考虑到倍率
            if(currXDiff * preYDiff  != preXDiff * currYDiff){
                cnt ++;
            }
            preXDiff = currXDiff;
            preYDiff = currYDiff;
        }
        return cnt;
    }
}
