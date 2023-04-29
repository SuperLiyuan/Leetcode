package daily.ongoing.finished;


import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge_934 {
    public int shortestBridge(int[][] grid) {
        //看了题解写的，先找到1个岛屿标记为1，然后找另外一个岛屿标记为2，然后层层向外扩展2直到2的边界触及1
        //左下右上
        int[][] dirs = {{-1,0}, {0,-1},{1,0},{0,1}};
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        boolean findIsland = false;
        // 找到一个1
        for(int i = 0;i < n;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1){
                    q.offer(new int[]{i,j});
                    grid[i][j] = 2;
                    findIsland = true;
                    break;
                }
            }
            if(findIsland){
                break;
            }
        }

        Queue<int[]> edgeQ = new LinkedList<>();

        //与1连在一起的全都入栈，顺便保存边缘格子
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int i = pos[0];
            int j = pos[1];
            for(int k = 0;k < 4;k++){
                if(0 <= i+dirs[k][0] &&i+dirs[k][0] < n
                        && 0<=j + dirs[k][1] && j + dirs[k][1]<n) {
                    int newI = i + dirs[k][0];
                    int newJ = j + dirs[k][1];
                    if(grid[newI][newJ] == 1){
                        grid[newI][newJ] = 2;
                        q.offer(new int[]{newI, newJ});
                    }else if(grid[newI][newJ] == 0){
                        edgeQ.offer(new int[]{newI, newJ});
                    }
                }

            }
        }
        int cnt = 0;
        //题目已经给定了数组恰有两个岛，所以不用再检查是否已经连通


        while(!edgeQ.isEmpty()){
            cnt ++;
            int num = edgeQ.size();
            for(int m = 0;m<num;m++){
                int[] pos = edgeQ.poll();
                int i = pos[0];
                int j = pos[1];
                for(int k = 0;k < 4;k++){
                    if(i+dirs[k][0] < n && j + dirs[k][1]<n) {
                        int newI = i + dirs[k][0];
                        int newJ = j + dirs[k][1];
                        if(grid[newI][newJ] == 1){
                            return cnt;
                        }else if(grid[newI][newJ] == 0){
                            grid[newI][newJ] = 2;
                            edgeQ.offer(new int[]{newI, newJ});
                        }
                    }

                }
            }

        }
    return cnt;

    }
}