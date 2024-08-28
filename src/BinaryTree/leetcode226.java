package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 翻转二叉树【镜像翻转】
 */
public class leetcode226 {

    public TreeNode invertTree2(TreeNode root) {
        //左右子树交换
        dfs2(root);
        return root;
    }
    public TreeNode dfs2(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dfs2(root.left);
        dfs2(root.right);
        return root;
    }










    //递归解法
    public TreeNode invertTree1(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root){
        // 如果当前节点为空，直接返回，结束递归
        if (root == null){
            return;
        }
        // 交换当前节点的左右子节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归遍历交换后的左子树
        dfs(root.left);
        // 递归遍历交换后的右子树
        dfs(root.right);

        return;
    }


    public TreeNode invertTree(TreeNode root) {
        // 如果根节点为空，直接返回，不做任何操作
        if (root == null){
            return root;
        }
        TreeNode helper = root;

        // 使用栈进行先序遍历，以便逐个节点进行翻转操作
        Stack<TreeNode> stack = new Stack<>();
        stack.add(helper);
        while (!stack.isEmpty()){
            helper = stack.pop();

            // 先将右子节点入栈，再将左子节点入栈，保证先处理左子树，后处理右子树
            if (helper.right != null) {
                stack.push(helper.right);
            }
            if (helper.left != null) {
                stack.push(helper.left);
            }

            // 交换左右子节点
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
