package leetcode.finished;

public class CheckStraightLight_1232 {

    public static boolean run(int[][] coordinates){

        int len = coordinates.length;
        if(len<=2) return true;
        int x = coordinates[0][0]-coordinates[1][0];
        int y = coordinates[0][1]-coordinates[1][1];
        if(x==0){//竖线
            for(int i=0;i<len-1;i++){
                if(coordinates[i][0]!=coordinates[i+1][0])
                    return false;
            }
        }else if(y==0){//横线
            for(int i=0;i<len-1;i++){
                if(coordinates[i][1]!=coordinates[i+1][1])
                    return false;
            }
        }
        else {
            double d = y * 1.0000 / x;
            for (int i = 1; i < len; i++) {
                x = coordinates[i - 1][0] - coordinates[i][0];
                y = coordinates[i - 1][1] - coordinates[i][1];
                if (d != y * 1.0000 / x) {
                    return false;
                }
            }
        }

        return true;
    }

}
