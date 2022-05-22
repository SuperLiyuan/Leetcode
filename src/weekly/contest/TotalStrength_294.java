package weekly.contest;

public class TotalStrength_294 {
    public int run(int[] strength) {
        //先每个节点算作一个子集合，然后以这个节点为起点往后加长度
        int[] currSum= new int[strength.length];
        int[] currMin = new int[strength.length];
        int sum = 0;
        //初始化，每个节点算一个子集合
        for(int i=0;i<strength.length;i++){
            currSum[i] = strength[i]*strength[i];
            currMin[i] = strength[i];
            sum += (strength[i] * currSum[i])%(Math.pow(10, 9) + 7);
        }
        for(int winLen = 2;winLen <= strength.length;winLen++){
            for(int i=0;i+winLen <= strength.length;i++){
                //更新最小值，重新计算sum
                if(strength[i+winLen-1]< currMin[i]){
                    currMin[i] = strength[i+winLen-1];
                    currSum[i] = (currSum[i] + strength[i+winLen-1]) * currMin[i];
                    sum += currSum[i]%(Math.pow(10, 9) + 7);
                }else {
                    //最小值不变，多了一个元素，那就gengxin sum
                    currSum[i] = currSum[i] + currMin[i] * strength[i+winLen-1];
                    sum += (currSum[i])%(Math.pow(10, 9) + 7);
                }

            }
        }
        return sum;
    }
}
