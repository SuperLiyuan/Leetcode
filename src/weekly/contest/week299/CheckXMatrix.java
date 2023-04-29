package weekly.contest.week299;

public class CheckXMatrix {
    public boolean run(int[][] grid) {
        int n = grid.length;
        boolean isXMatrix = true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //是对角线
                if(i == j || i+j == n-1){
                    if(grid[i][j] == 0){
                        isXMatrix = false;
                        return isXMatrix;
                    }
                }else{
                    if(grid[i][j] != 0){
                        isXMatrix = false;
                        return isXMatrix;
                    }
                }
            }
        }
        return isXMatrix;
    }
}
