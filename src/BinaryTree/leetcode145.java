package BinaryTree;

import java.util.List;

/**
 * 二叉树的后序遍历
 */
public class leetcode145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        return null;
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
