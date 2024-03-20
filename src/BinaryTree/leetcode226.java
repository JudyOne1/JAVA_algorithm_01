package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 翻转二叉树【镜像翻转】
 */
public class leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode helper = root;
        //先序遍历
        Stack<TreeNode> stack = new Stack<>();
        stack.add(helper);
        while (!stack.isEmpty()){
            helper = stack.pop();

            if (helper.right != null) {
                stack.push(helper.right);
            }
            if (helper.left != null) {
                stack.push(helper.left);
            }

            //交换左右子树
            TreeNode temp = helper.left;
            helper.left = helper.right;
            helper.right = temp;

        }
        return root;


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
