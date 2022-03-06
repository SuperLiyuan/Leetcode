package sword.finished.ongoing;


import java.util.ArrayList;
import java.util.List;

public class MinStack_30 {

    /** initialize your data structure here. */
    List<Integer> eleList;
    List<Integer> minPosList;
    int min;
    int secondMin;
    public MinStack_30() {
        eleList = new ArrayList<>();
        minPosList = new ArrayList<>();
        min=Integer.MAX_VALUE;
    }

    public void push(int x) {
        eleList.add(x);
        if(x<=min) {
            //记录最小值的下标
            minPosList.add(eleList.size()-1);
            min = x;
        }
    }

    public void pop() {
        if(eleList.size()-1 == minPosList.get(minPosList.size()-1)){
            minPosList.remove(minPosList.size()-1);
            if(minPosList.size()==0) min = Integer.MAX_VALUE;
            else min = eleList.get(minPosList.size()-1);
        }
        eleList.remove(eleList.size()-1);
    }

    public int top() {
        return eleList.get(eleList.size()-1);
    }

    public int min() {
        if(eleList.size()==1) return eleList.get(0);
        return eleList.get(minPosList.get(minPosList.size()-1));
    }

}
