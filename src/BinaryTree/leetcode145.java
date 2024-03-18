package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 */
public class leetcode145 {

    /**
     * 实现二叉树的后序遍历（左子树、右子树、根节点）。
     * @param root 二叉树的根节点
     * @return 返回后序遍历结果的列表
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // 后序 【先序（头 右 左）的弹出放入栈中，最后再输出，得到后序（左 右 头）】
        // 使用两个栈来实现后序遍历，stack1用于存储待处理的节点，stack2用于存储遍历顺序
        List<Integer> result = new ArrayList<Integer>();
        if (root != null) {
            Stack<TreeNode> stack1 = new Stack<>(); // stack1 主栈，用来压入节点
            Stack<TreeNode> stack2 = new Stack<>(); // stack2 辅栈，用来存储遍历顺序
            stack1.push(root); // 先将根节点入主栈
            // 主栈不空，就持续弹出节点，并将其压入辅栈
            while (!stack1.isEmpty()) {
                root = stack1.pop(); // 弹出一个节点
                stack2.push(root); // 将该节点压入辅栈
                // 如果有左子树，则左子树入主栈
                if (root.left != null) {
                    stack1.push(root.left);
                }
                // 如果有右子树，则右子树入主栈
                if (root.right != null) {
                    stack1.push(root.right);
                }
            }

            // 遍历辅栈，将节点值按后序顺序加入结果列表
            while (!stack2.isEmpty()) {
                result.add(stack2.pop().val); // 弹出节点并加入结果列表
            }
        }

        return result;
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
