package Leetcode75;

public class SearchMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //二分法
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0 ;
        int end = m * n - 1;
        int mid = 0;
        while(start <= end){
            mid = start + (end - start )/ 2;
            int i = mid / n;
            int j = mid % n;
            if(matrix[i][j] == target){
                return true;
            }
            int startI = start / n;
            int startJ = start % n;
            int endI = end / n;
            int endJ = end % n;
            if(matrix[startI][startJ] <= target && target < matrix[i][j]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }


        }
        return false;
    }
}
