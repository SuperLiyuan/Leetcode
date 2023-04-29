package Leetcode75;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder_54 {
    //TODO
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length; //row
        int n = matrix[0].length; //column
        int leftBoundary = 0;
        int rightBoundary = n - 1;
        int topBoundary = 0;
        int bottomBoundary = m-1;
        List<Integer> res = new ArrayList<>();
        while(true){
            for(int i = leftBoundary;i<=rightBoundary;i++){
                res.add(matrix[topBoundary][i]);
            }
            if(++topBoundary > bottomBoundary) break;
            for(int i = topBoundary;i<=bottomBoundary;i++){
                res.add(matrix[i][rightBoundary]);
            }
            if(--rightBoundary<leftBoundary) break;
            for(int i =rightBoundary;i>=leftBoundary;i--){
                res.add(matrix[bottomBoundary][i]);
            }
            if(--bottomBoundary < topBoundary) break;
            for(int i = bottomBoundary;i>=topBoundary;i--){
                res.add(matrix[i][leftBoundary]);
            }
            if(++leftBoundary > rightBoundary) break;
        }
        return res;
    }
}
