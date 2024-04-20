package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 */
public class leetcode144 {

    /**
     * 前序遍历二叉树。
     *
     * @param root 二叉树的根节点。
     * @return 预序遍历结果的列表，其中包含二叉树中所有节点的值。
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>(); // 用于存储遍历结果的列表
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>(); // 使用栈来辅助进行预序遍历
            stack.add(root); // 将根节点压入栈
            while (!stack.isEmpty()) {
                root = stack.pop(); // 从栈中弹出一个节点，处理该节点
                result.add(root.val); // 将节点的值添加到结果列表中
                // 先将右子节点压入栈，再将左子节点压入栈，保证先访问右子树，再访问左子树
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
        return result; // 返回预序遍历的结果列表
    }
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorder(root, result);
        return result;
    }

    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
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
