package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode404 {
    public int sumOfLeftLeaves(TreeNode root) {
        //中序遍历，到叶子节点，加入 sum
        int count = 0;
        if(root != null) {
            Stack<TreeNode> stack = new Stack<>();
            // 使用迭代方式实现中序遍历
            while (!stack.isEmpty() || root != null) {
                // 遍历左子树并将其节点入栈
                if (root != null) {
                    stack.push(root);
                    if (root.left != null && root.left.right == null && root.left.left == null) {
                        //判断
                        count += root.left.val;
                    }
                    root = root.left;  // 继续往左子树深入

                } else {
                    // 当没有左子树可遍历时，弹出栈顶节点并处理
                    root = stack.pop();
                    root = root.right;  // 转向右子树
                }
            }
        }
        return count;
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
