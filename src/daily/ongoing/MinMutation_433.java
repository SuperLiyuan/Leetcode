package daily.ongoing;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinMutation_433 {

    public static int run(String start, String end, String[] bank) {

        if(start.equals(end)){
            return 0;
        }

        //预处理：计算bank中的邻接表
        int bankLen = bank.length;
        int[][] adj = new int[bankLen][bankLen];
        boolean endIsInBank = false;

        for(int i=0;i<bankLen;i++){
            if(bank[i].equals(end)){
                endIsInBank = true;
            }
            for(int j=i+1;j<bankLen;j++){
                int differentChar = 0;
                for(int k = 0;k<8;k++){
                    if(bank[i].charAt(k) != bank[j].charAt(k)){
                        differentChar ++;
                    }
                    if(differentChar >1){
                        break;
                    }
                }
                //是邻接
                if(differentChar == 1){
                    adj[i][j] = 1;
                    adj[j][i] = 1;
                }
            }
        }
        if(!endIsInBank){
            return -1;
        }

        //还要计算一次start的邻接
        Queue<Integer> bfsQueue = new ArrayDeque<>();
        boolean[] visited = new boolean[bankLen];

        for(int i = 0;i < bankLen; i++) {
            int differentChar = 0;
            for (int k = 0; k < 8; k++) {
                if (start.charAt(k) != bank[i].charAt(k)) {
                    differentChar++;
                }
                if (differentChar > 1) {
                    break;
                }
            }
            //是邻接
            if (differentChar == 1) {
                bfsQueue.add(i);
                visited[i] = true;
            }
        }

        int step = 1;
        while(!bfsQueue.isEmpty()){
            int queueSize = bfsQueue.size();
            for(int i=0;i<queueSize;i++){
                int curr = bfsQueue.poll();
                if(end.equals(bank[curr])){
                    return step;
                }
                for(int j=0;j<bankLen;j++){
                    if(adj[curr][j] == 1 && !visited[j]){
                        bfsQueue.offer(j);
                        visited[j] = true;
                    }
                }

            }
            step++;
        }
        return -1;
    }
}
