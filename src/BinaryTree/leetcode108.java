package BinaryTree;

public class leetcode108 {
    /**
     * 将有序数组转换为二叉搜索树（BST）。
     *
     * @param nums 有序整数数组
     * @return 转换后的二叉搜索树的根节点
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = traversal(nums, 0, nums.length - 1);
        return root;
    }

    /**
     * 递归构造二叉搜索树。
     *
     * @param nums 有序整数数组
     * @param left 当前子数组的左边界
     * @param right 当前子数组的右边界
     * @return 当前子数组对应的二叉搜索树的根节点
     */
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
