package daily.ongoing;

public class PlatesBetweenCandles_2055 {
    public static int[] run(String s, int[][] queries) {
        int len = s.length();
        int[] res = new int[queries.length];
        int[] arr = new int[len];
        int sum = 0;
        for(int i=0;i<len;i++){
            if(s.charAt(i) == '*'){
                sum++;
            }
            arr[i] = sum;
        }

        int[] theNearestCandleOnTheLeft = new int[len];
        int theNearestCandlePos = -1;
        for(int j=0;j<len;j++){
            if(s.charAt(j) == '|'){
                theNearestCandlePos = j;
            }
            theNearestCandleOnTheLeft[j] = theNearestCandlePos;
        }
        theNearestCandlePos = -1;
        int[] theNearestCandleOnTheRight = new int[len];
        for(int j=len-1;j>=0;j--){
            if(s.charAt(j) == '|'){
                theNearestCandlePos = j;
            }
            theNearestCandleOnTheRight[j] = theNearestCandlePos;
        }

        for(int i=0;i<queries.length;i++){
            int[] query = queries[i];

            int x = theNearestCandleOnTheRight[query[0]];
            int y = theNearestCandleOnTheLeft[query[1]];

            if(x>=0 &&y>=0&&y > x) {
                res[i] = arr[y] - arr[x];

            }
        }

        return res;
    }
}
