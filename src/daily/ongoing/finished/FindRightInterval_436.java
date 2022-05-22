package daily.ongoing.finished;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRightInterval_436 {
    public int[] findRightInterval(int[][] intervals) {

        //把每个区间的开始和结束单独拿出来排序
        int[] starts = new int[intervals.length];
        //map<end的坐标，对应的interval下标>
        Map<Integer, Integer> startIndex = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            startIndex.put(starts[i], i);
        }
        Arrays.sort(starts);
        int[] ans = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            //对每个区间，找出大于start的对应的最小ends，返回对应下标
            int target = intervals[i][1];
            int left = 0;
            int right = starts.length - 1;
            int mid = (left + right) / 2;
            if (target > starts[right]) {
                ans[i] = -1;
                continue;
            }
            while (left < right) {
                if (starts[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
                mid = left + (right - left) / 2;
            }
            ans[i] = left;
        }
        return ans;
    }



}
