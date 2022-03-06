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


        for(int i=time;i<totalDay-time-1;i++){
          int j;
          for( j=0;j<time;j++){
              //increase
              if(security[i-time+j] < security[i-time+j+1]){
                  break;
              }
          }
          if(j<time){
              continue;
          }

          int k;
          for(k=0;k<time;k++){
              //decrease
              if(security[i+k] > security[i+k+1]){
                  break;
              }
          }

          if(k==time){
              resList.add(i);
          }
        }
        return resList;



    }

}
