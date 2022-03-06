package daily.ongoing.finished;

public class IncreasingTriplet_334 {

    public static boolean run(int[] nums){
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){

            //first second nums[i]
            if(nums[i] > second){
                return true;
            //first num[i] second
            }else if(nums[i]> first){
                second = nums[i];
            //num[i] first second
            }else{
                first = nums[i];
            }

        }
        return false;
    }

}
