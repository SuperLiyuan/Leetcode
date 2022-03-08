package daily.ongoing;

public class PlatesBetweenCandles_2055 {
    public static int[] run(String s, int[][] queries) {
        int len = s.length();
        int[] res = new int[queries.length];
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            if(s.charAt(i) == '|'){
                arr[i] = 1;
            }else{
                arr[i] = 0;
            }
        }
        for(int i=0;i<queries.length;i++){
            int[] query = queries[i];
            int cnt = 0;
            boolean hasCandle = false;
            for(int j=query[0];j<=query[1];j++){
                if(arr[j]==1){
                    //右边的蜡烛
                    if(hasCandle){
                        res[i] = cnt;
                    //左边的蜡烛
                    }else{
                        hasCandle = true;
                    }
                }else{
                    if(hasCandle){
                        cnt++;
                    }
                }
            }
        }
        return res;
    }
}
