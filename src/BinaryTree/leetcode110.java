package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode110 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    /**
     * 计算二叉树的高度，并检查是否为平衡二叉树。
     * 平衡二叉树的定义是：任意节点的左右子树的高度差不超过1。
     *
     * @param root 二叉树的根节点
     * @return 若二叉树是平衡的，则返回其高度；若不是平衡的，则返回-1
     */
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0; // 空节点的高度定义为0
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1; // 左子树不平衡，整体也不平衡
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1; // 右子树不平衡，整体也不平衡
        }
        // 检查左右子树高度差是否大于1，若是则表示树不平衡
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        // 返回左右子树中较大的高度加1，即为整棵树的高度
        return Math.max(leftHeight, rightHeight) + 1;
    }



    static class TreeNode {
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
