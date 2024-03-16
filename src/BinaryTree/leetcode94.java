package BinaryTree;

import javax.swing.tree.TreeNode;
import java.util.List;



/**
 * 二叉树的中序遍历
 */
public class leetcode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
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
