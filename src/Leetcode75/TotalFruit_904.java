package Leetcode75;

import java.util.HashMap;
import java.util.Map;

public class TotalFruit_904 {
    public int totalFruit(int[] fruits) {
        //就是贪心算法？还是啥
        //找数组中包含两个字母的最长连续子串
        //滑动窗口～
        int max = 0;
        int left = 0;
        //水果的种类
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap();
        for(int right = 0; right < fruits.length; right ++){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0)+1);
            while(map.size()>2){
                map.put(fruits[left], map.get(fruits[left]) -1);
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left ++;
            }
            max = Math.max(max, right - left + 1);


        }
        return max;
    }
}
