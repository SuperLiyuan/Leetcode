package weekly.contest.week302;

import java.util.Arrays;

public class SmallestTrimmedNumbers {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++){

            //int digits = (int) Math.pow(10,queries[i][0]);
            Integer[] tmpNums = new Integer[nums.length];
            for(int j=0;j<tmpNums.length;j++){
                tmpNums[j] = Integer.parseInt(nums[j].substring(queries[i][1]>nums[j].length()?0:nums[j].length() - queries[i][1]));
            }
            ;
            res[i] = findNthSmallest(tmpNums, queries[i][0]);
        }
        return res;
    }


    private int findNthSmallest(Integer[] arr, int n){
        Integer[] tmpArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(tmpArr);
        int res = tmpArr[n-1];
        for(int i=0;i<arr.length;i++){
            if(arr[i] == res){
                return i;
            }
        }
        return -1;
    }
}
