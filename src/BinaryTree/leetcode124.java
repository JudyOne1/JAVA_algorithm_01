package BinaryTree;

public class leetcode124 {
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int ans = Integer.MIN_VALUE;

    private int dfs(TreeNode node) {
        if (node == null)
            return 0; // 没有节点，和为 0
        int lVal = dfs(node.left); // 左子树最大链和
        int rVal = dfs(node.right); // 右子树最大链和
        ans = Math.max(ans, lVal + rVal + node.val); // 两条链拼成路径
        return Math.max(Math.max(lVal, rVal) + node.val, 0); // 当前子树最大链和
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
