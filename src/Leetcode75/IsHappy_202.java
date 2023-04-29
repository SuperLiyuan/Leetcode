package Leetcode75;

import java.util.HashSet;
import java.util.Set;

public class IsHappy_202 {
    public boolean isHappy(int n) {

        int tempN = n;
        Set<Integer> set = new HashSet<Integer>();
        while(tempN !=1){
            int sum =0;
            while(tempN >0){
                int tmp = tempN % 10;
                sum += tmp * tmp;
                tempN = tempN/10;
            }
            if(sum == n){
                return false;
            }
            if(set.contains(sum)){
                return false;
            }
            set.add(sum);
            tempN = sum;
            n = tempN;
        }
        return true;
    }
}
