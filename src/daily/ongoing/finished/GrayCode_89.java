package daily.ongoing.finished;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_89 {

    public static List<Integer> run(int n) {

        List<Integer> res = new ArrayList<>();
        if(n==0){
            res.add(0);
            return res;
        }else{
            List<Integer> formerHalfRes = run(n-1);
            List<Integer> latterHalfRes = new ArrayList<>();
            for(int i= formerHalfRes.size()-1;i>=0;i--){
                latterHalfRes.add(formerHalfRes.get(i) +(1<<n-1));
            }
            res.addAll(formerHalfRes);
            res.addAll(latterHalfRes);
        }
        return res;


    }

}
