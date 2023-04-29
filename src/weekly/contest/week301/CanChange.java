package weekly.contest.week301;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CanChange {

    public boolean canChange(String start, String target) {

        List<Integer> startL = new ArrayList<>();
        List<Integer> startR = new ArrayList<>();
        List<Integer> targetL = new ArrayList<>();
        List<Integer> targetR = new ArrayList<>();
        int len = start.length();
        StringBuilder startOrder = new StringBuilder();
        StringBuilder targerOrder = new StringBuilder();
        for(int i=0;i<len;i++){
            if(start.charAt(i) == 'L'){
                startL.add(i);
                startOrder.append('L');
            }else if(start.charAt(i) == 'R'){
                startR.add(i);
                startOrder.append('R');
            }
            if(target.charAt(i) == 'L'){
                targetL.add(i);
                targerOrder.append('L');
            }else if(target.charAt(i) == 'R'){
                targetR.add(i);
                targerOrder.append('R');
            }

        }
        if(!targerOrder.toString().equals(startOrder.toString())){
            return false;
        }

        for(int i=0;i<startL.size();i++){
            if(startL.get(i) < targetL.get(i)){
                return false;
            }
        }
        for(int i=0;i<targetR.size();i++){
            if(startR.get(i) > targetR.get(i)){
                return false;
            }
        }

        return true;





    }

}
