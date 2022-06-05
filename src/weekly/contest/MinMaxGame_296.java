package weekly.contest;

public class MinMaxGame_296 {

    public int run(int[] nums) {
        int len = nums.length;
        while(len > 1){
            int[] newNums = new int[len/2];
            for(int i = 0;i<len/2;i++){
                if(i%2 == 0){
                    newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                }else{
                    newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = newNums;
            len = nums.length;
        }
        return len;
    }

}
