package weekly.contest.week307;

import java.util.Arrays;

public class MinNumberOfHours {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int maxExperience = 0;
        int maxXpPos = 0;
        for(int i = 0;i<experience.length;i++){
            if(experience[i]>maxExperience){
                maxExperience = experience[i];
                maxXpPos = i;
            }
        }

        //只要在达到maxxp的时候经验值大于最大值就可以了
        int prevSum = 0;
        for(int i=0;i<maxXpPos;i++){
            prevSum += experience[i];
        }
        //neededXp + initialExperience + prevSum[0,...,maxXpPos-1] = maxExperience+1
        int neededXp = maxExperience + 1 - initialExperience - prevSum ;
        ;
        //energy的话，需要保证全程都有energy。。
        //neededEnergy + initialEnergy = sumEnergy +1
        int sumEnergy = Arrays.stream(energy).sum();
        int ans = 0;
        if(neededXp >0){
            ans += neededXp;
        }
        if(sumEnergy+1-initialEnergy>0){
            ans += sumEnergy+1-initialEnergy;
        }
        return ans;
    }
}
/*
94
70
[58,47,100,71,47,6,92,82,35,16,50,15,42,5,2,45,22]
[77,83,99,76,75,66,58,84,44,98,70,41,48,7,10,61,28]
 */
