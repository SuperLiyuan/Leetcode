package weekly.contest.week305;

public class ValidPartition {
    public boolean validPartition(int[] nums) {
        //fi 代表的是从0到i-1是否是有效划分
        boolean[] f = new boolean[nums.length+1];
        f[0] = true;
        //2 2 是f2 = f0 && nums[0]==nums[1]
        //2 2 2 是f3 = f0 && nums[0] == nums[1]==nums[2]
        for(int i = 1;i<nums.length;i++){
            if(( f[i-1] && nums[i-1] == nums[i]) || (i>1&&f[i-2] && nums[i-1] == nums[i-2] && nums[i] == nums[i-1])
        || (i>1&&f[i-2]&&nums[i-2]+1==nums[i-1]&&nums[i-2]+2==nums[i])){
                f[i+1] = true;
            }
        }
        return f[nums.length];
    }
}
