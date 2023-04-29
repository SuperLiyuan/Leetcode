package weekly.contest.week300;

import model.ListNode;

public class SpiralMatrix {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        String[] dir = {"right", "down", "left", "up"};
        int[][] res = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[i][j] = -1;
            }
        }
        int currDir = 0;
        int cnt = 0;
        int size = m*n;
        int currI =0;
        int currJ =-1;
        while(head != null){
            currDir = currDir %4;
            if(dir[currDir] == "right"){
                int j = currJ+1;
                while(j<n&& head !=null){
                    if(res[currI][j] == -1){
                        res[currI][j] = head.val;
                        head = head.next;
                        j++;
                    }else{
                        break;
                    }
                }
                currJ = j-1;
            }else if(dir[currDir] == "down"){
                int i = currI+1;
                while(i<m&& head !=null){
                    if(res[i][currJ] == -1){
                        res[i][currJ] = head.val;
                        head = head.next;
                        i++;
                    }else{
                        break;
                    }
                }
                currI = i-1;
            }else if(dir[currDir] == "left"){
                int j = currJ-1;
                while(j>=0&& head !=null){
                    if(res[currI][j] == -1){
                        res[currI][j] = head.val;
                        head = head.next;
                        j--;
                    }else{
                        break;
                    }
                }
                currJ = j+1;
            }else if(dir[currDir] == "up"){
                int i = currI-1;
                while(i>=0&& head !=null){
                    if(res[i][currJ] == -1){
                        res[i][currJ] = head.val;
                        head = head.next;
                        i--;
                    }else{
                        break;
                    }
                }
                currI = i+1;
            }

            currDir ++;
        }
        return res;
    }
}
