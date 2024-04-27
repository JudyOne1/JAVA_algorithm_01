package search;

public class leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length - 1;
        int row = matrix.length - 1;
        //二维数组二分查找
        if (col == 0 && row == 0){
            return matrix[0][0] == target;
        }
        if (row == 0){
            row = 1;
        }
        if (col == 0){
            col = 1;
        }

        int plus = col*row;
        return dfs(matrix, target, 0, plus);
    }

    public boolean dfs(int[][] matrix, int target,int start,int end){
        if (start > end){
            return false;
        }
        int mid = (start + end) / 2;
        int length = matrix[0].length;
        if (matrix[mid/ length][mid% length] == target){
            return true;
        }else if (matrix[mid/ length][mid% length] > target){
            return dfs(matrix, target, start, mid - 1);
        }else {
            return dfs(matrix, target, mid + 1, end);
        }
    }

}
