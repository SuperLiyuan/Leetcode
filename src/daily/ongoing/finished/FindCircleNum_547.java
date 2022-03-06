package daily.ongoing.finished;

public class FindCircleNum_547 {
    public static int run(int[][] isConnected) {
        int len = isConnected[0].length;
        boolean[] isVisited = new boolean[len];
        if (len == 0) return 0;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if(!isVisited[i]) {
                visit(i, isConnected, isVisited, cnt);
                cnt++;
            }

        }

        return cnt;
    }

    public static void visit(int i, int[][] isConnected, boolean[] isVisited,int cnt) {
        int len = isConnected[0].length;
        for (int j = i; j < len; j++) {
            if (isConnected[i][j] == 1 && !isVisited[j]) {
                isVisited[j] = true;
                visit(j, isConnected, isVisited,cnt);
            }


        }
    }
}