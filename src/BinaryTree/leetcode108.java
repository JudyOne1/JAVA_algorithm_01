package BinaryTree;

public class leetcode108 {
    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵
     * 平衡 二叉搜索树。
     * 平衡二叉树 是指该树所有节点的左右子树的深度相差不超过 1。
     */
    public TreeNode sortedArrayToBST2(int[] nums) {

        return dfs2(nums, 0, nums.length - 1);

    }

    private TreeNode dfs2(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (end - start) / 2 + start;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs2(nums, start, mid - 1);
        root.right = dfs2(nums, mid, end);
        return root;
    }

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

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
