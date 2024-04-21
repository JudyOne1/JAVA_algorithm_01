package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode101 {


    public boolean isSymmetric1(TreeNode root) {
        // 空树或只有一个节点的树是对称树
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        // 使用递归判断树的左右子树是否对称
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        // 两棵树都为空，视为对称
        if (left == null && right == null) {
            return true;
        }
        // 仅有一棵树为空，视为不对称
        if (left == null || right == null) {
            return false;
        }
        // 两棵树节点值不相等，视为不对称
        if (left.val != right.val) {
            return false;
        }

        // 递归判断左右子树的对称性
        return dfs(left.left, right.right) &&
                dfs(left.right, right.left);
    }

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
