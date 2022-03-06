package daily.ongoing;

import java.util.ArrayList;
import java.util.List;

public class GoodDaysToRobBank_2100 {

    public static List<Integer> run(int[] security, int time) {

        int totalDay = security.length;
        List<Integer> resList = new ArrayList<>();
        if(totalDay < time*2){
            return resList;
        }

        int[] left = new int[totalDay];
        int[] right = new int[totalDay];
        for(int i=1;i<totalDay;i++){
            if(security[i-1]>=security[i]){
                left[i]=left[i-1]+1;
            }
            if(security[totalDay-i]>=security[totalDay-i-1]){
                right[totalDay-i-1] = right[totalDay-i]+1;
            }
        }
        for(int i=0;i<totalDay;i++){
            if(left[i]>=time && right[i]>=time){
                resList.add(i);
            }
        }

        return resList;



    }

}
