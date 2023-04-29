package weekly.contest.week304;

import java.util.Arrays;

public class MaximumGroups {

    public int maximumGroups(int[] grades) {

        Arrays.sort(grades);
        int groups = 0;
        int prevNum = 1;
        int prevGrades = grades[0];
        int i =1;
        while(i<grades.length - 1){
            int j = i;
            int currGrades = 0;
            while(j - i <= prevNum && currGrades <= prevGrades && j < grades.length - 1){
                j++;
                currGrades += grades[j];
            }
            //发现好像不太对……并不可以简单粗暴排序，从最小的开始排啊
        }
        return 0;
    }

}
