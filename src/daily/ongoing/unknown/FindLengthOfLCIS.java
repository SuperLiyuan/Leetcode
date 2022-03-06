package daily.ongoing.unknown;

public class FindLengthOfLCIS {
    public static int run(int[] nums){
        int curr = 1;
        int len = nums.length;
        if(len==0) return 0;
        int start = 0;
        int end = 0;
        int maxCnt = 0;
        int currCnt = 1;
        while(curr<len){
            if(nums[curr-1]<nums[curr]){
                curr++;
                currCnt++;
            }else{
                end = curr-1;
                if(currCnt>=maxCnt) maxCnt = currCnt;
                currCnt = 0;
                start = curr;
                curr++;
            }

        }
        if(currCnt>=maxCnt) maxCnt = currCnt;
        return maxCnt;
    }
}
