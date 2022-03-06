package daily.ongoing.finished;

public class CanPlaceFlowers_605 {
    public static boolean run(int[] flowerbed,int n){
        //找与1两边不相邻的数
        int cnt = flowerbed.length;
        int[] mark = flowerbed.clone();
        int cntZeroInARow = 0;
        double ans = 0;
        int i;
        for(i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==1){
                //i不在最左
                if(i>0&&flowerbed[i-1]==0) {
                    mark[i-1] = -1;
                    cntZeroInARow--;
                }
                if(i<flowerbed.length-1&&flowerbed[i+1]==0)
                    mark[i+1] =-1;
                ans = ans + Math.ceil(cntZeroInARow/2.0);
                cntZeroInARow = 0;
                mark[i] = -1;
            }
            if(mark[i]==0) {
                cntZeroInARow ++;
            }
            }
        if(flowerbed[i-1]==0)ans = ans + Math.ceil(cntZeroInARow/2.0);

        return (int)ans>=n;

    }
}
