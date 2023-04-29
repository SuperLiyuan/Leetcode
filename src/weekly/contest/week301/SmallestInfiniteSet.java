package weekly.contest.week301;

import java.util.HashSet;
import java.util.Set;

public class SmallestInfiniteSet {

    int minInt;
    Set<Integer> excludedInt;

    public SmallestInfiniteSet() {

        minInt = 1;
        excludedInt = new HashSet<>();
    }

    public int popSmallest() {
        int smallest = minInt;
        excludedInt.add(minInt);
        while(excludedInt.contains(minInt)){
            minInt ++;
        }
        return smallest;
    }

    public void addBack(int num) {
        excludedInt.remove(num);
        if(num < minInt){
            minInt = num;
        }
    }
}