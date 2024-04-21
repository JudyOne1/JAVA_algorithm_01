package BinaryTree;

public class leetcode108 {
    public TreeNode sortedArrayToBST1(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }
    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]); // 以中间元素构建根节点
        root.left = dfs(nums, left, mid - 1); // 递归构建左子树
        root.right = dfs(nums, mid + 1, right); // 递归构建右子树
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = traversal(nums, 0, nums.length - 1);
        return root;
    }


    private TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) return null; // 当左边界大于右边界时，返回null，表示当前子数组为空

        int mid = left + ((right - left) >> 1); // 找到当前子数组的中间元素的索引
        TreeNode root = new TreeNode(nums[mid]); // 以中间元素构建根节点
        root.left = traversal(nums, left, mid - 1); // 递归构建左子树
        root.right = traversal(nums, mid + 1, right); // 递归构建右子树
        return root;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
