package daily.ongoing.finished;

public class Construct2DArray_2022 {

    public static int[][] run(int[] original, int m, int n) {

        int[][] res = new int[m][n];
        int[][] emptyRes = new int[][]{};
        int len = original.length;
        if(len > m*n ) return emptyRes;

        int left = len;
        int row = 0;
        int currPos = 0;
        while(left>n){
            for(int i=0;i<n;i++){
                res[row][i] = original[currPos];
                currPos ++;

            }
            row++;
            left = left - n;
        }

        int i=0;
        while(left>0){
                res[row][i] = original[currPos];
                currPos++;
                left--;
                i++;
        }

        return res;



    }

}
