package search;

public class leetcode74 {
    public boolean searchMatrix1(int[][] matrix, int target) {
        int col = matrix[0].length;
        int row = matrix.length;
        int plus = col * row;
        return dfs1(matrix, target, 0, plus - 1);
    }

    private boolean dfs1(int[][] matrix, int target, int left, int right) {
        if (left > right) {
            return false;
        }
        int mid = (right + left) / 2;
        int length = matrix[0].length;
        int value = matrix[mid / length][mid % length];
        if (value == target) {
            return true;
        } else if (value < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
        return dfs1(matrix, target, left, right);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // 计算矩阵的列数和行数
        int col = matrix[0].length;
        int row = matrix.length;
        // 计算矩阵元素总个数，用于dfs方法的索引范围
        int plus = col * row;
        // 使用深度优先搜索方法查找目标值
        return dfs(matrix, target, 0, plus - 1);
    }

    public boolean dfs(int[][] matrix, int target, int start, int end) {
        // 当起始索引大于结束索引时，搜索范围为空，返回false
        if (start > end) {
            return false;
        }
        // 计算当前搜索范围的中间位置
        int mid = (start + end) / 2;
        // 计算当前行和列
        int length = matrix[0].length;
        // 检查中间位置的值是否等于目标值
        if (matrix[mid / length][mid % length] == target) {
            return true;
            // 如果中间位置的值大于目标值，则在左半部分继续搜索
        } else if (matrix[mid / length][mid % length] > target) {
            return dfs(matrix, target, start, mid - 1);
            // 如果中间位置的值小于目标值，则在右半部分继续搜索
        } else {
            return dfs(matrix, target, mid + 1, end);
        }
    }


}
