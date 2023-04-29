package sword.finished;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage_041 {


    Queue<Integer> queue;
    double sum =0;
    int capacity;

//我记得当时没想到有什么好的不lousy的还没填满数组时候的解决办法 没想到第二次做的时候还是不记得～
//还是没想到用队列！
    /** Initialize your data structure here. */
    public MovingAverage_041(int size) {
        queue = new ArrayDeque();
        capacity = size;
    }

    public double next(int val) {
        queue.add(val);
        sum += val;
        if(queue.size() > capacity){
            int top = queue.poll();
            sum -= top;
        }
        return sum / queue.size();
    }

}
