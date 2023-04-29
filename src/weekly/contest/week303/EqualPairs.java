package weekly.contest.week303;

public class EqualPairs {
    public int equalPairs(int[][] grid) {
        int res = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                boolean equal = true;
                for(int k = 0;k<grid[0].length;k++){
                    System.out.println(i +"," + (k) + "vs" + k + "," + j + ":" + grid[i][k]
                    + "vs" + grid[k][j]);
                    if(grid[i][k] != grid[k][j]){
                        equal = false;
                        break;
                    }
                }
                if(equal){
                    res ++;
                }
            }
        }
        return res;
    }
}
