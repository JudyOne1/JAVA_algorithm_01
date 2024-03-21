package BinaryTree;

import java.util.Stack;

public class leetcode112 {
    /**
     * 检查二叉树中是否存在一条从根节点到叶子节点的路径，使得路径上所有节点值的和等于给定的目标和。
     * 使用栈模拟的前序遍历
     * @param root 二叉树的根节点
     * @param targetSum 目标和
     * @return 如果存在满足条件的路径则返回true，否则返回false
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        // 使用两个栈，一个存储节点，一个存储节点值的和
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(root.val);
        while(!stack1.isEmpty()) {
            int size = stack1.size();

            for(int i = 0; i < size; i++) {
                TreeNode node = stack1.pop();
                int sum = stack2.pop();

                // 遇到叶子节点时判断当前路径的和是否等于目标和
                if(node.left == null && node.right == null && sum == targetSum) {
                    return true;
                }
                // 遍历右子树
                if(node.right != null){
                    stack1.push(node.right);
                    stack2.push(sum + node.right.val);
                }
                // 遍历左子树
                if(node.left != null) {
                    stack1.push(node.left);
                    stack2.push(sum + node.left.val);
                }
            }
        }
        return false;
    //    return process(root, targetSum);
    }


//    public boolean process(TreeNode root, int targetSum) {
//        //base case
//        targetSum -= root.val;
//        // 叶子结点
//        if (root.left == null && root.right == null) {
//            return targetSum == 0;
//        }
//        if (root.left != null) {
//            boolean left = process(root.left, targetSum);
//            if (left) {      // 已经找到
//                return true;
//            }
//        }
//        if (root.right != null) {
//            boolean right = process(root.right, targetSum);
//            if (right) {     // 已经找到
//                return true;
//            }
//        }
//        return false;
//
//    }

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
