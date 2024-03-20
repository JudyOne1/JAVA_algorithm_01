package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode101 {
    /**
     * 判断给定的二叉树是否是对称的。
     *
     * @param root 二叉树的根节点
     * @return 如果二叉树是对称的，则返回true；否则返回false。
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; // 空树是对称树
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root.left); // 左子树的根节点
        queue.offer(root.right); // 右子树的根节点
        while (queue.size() > 0) {
            //左右两个节点的值是否相等
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode == null && rightNode == null) {
                continue; // 如果左右节点都为空，则跳过
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false; // 如果左右节点不匹配，则不是对称树
            }

            // 分别将左右子树的左节点、右节点入队，以进行下一层的判断
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true; // 遍历完成后，说明树是对称的
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
