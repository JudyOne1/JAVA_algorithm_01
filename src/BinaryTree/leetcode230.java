package BinaryTree;

public class leetcode230 {
    int res;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        //中序遍历二叉搜索树，找到第k个节点
        dfs(root, k);
        return res;
    }

    public void dfs(TreeNode root, int k) {

        if (root == null) return;  // 如果当前节点为空，则返回

        // 先访问左子树
        dfs(root.left, k);

        count++;  // 统计已访问的节点数
        // 如果已访问的节点数等于要查找的节点顺序k，则找到目标节点
        if (count == k) {
            res = root.val;  // 将目标节点的值赋给res
            return;
        }

        // 最后访问右子树
        dfs(root.right, k);
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
