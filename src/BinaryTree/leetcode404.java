package BinaryTree;

public class leetcode404 {
    public int sumOfLeftLeaves(TreeNode root) {
        //左叶子节点的和
        //中序遍历，或后序遍历，到叶子节点，加入 sum
        return 0;
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
