package BinaryTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * 二叉树的中序遍历
 */
public class leetcode94 {

    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    public TreeNode dfs(TreeNode root, List<Integer> res){
        if (root == null){
            return null;
        }
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
        return root;
    }
    /**
     * 中序遍历二叉树。
     *
     * @param root 二叉树的根节点
     * @return 中序遍历结果的列表
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root != null) {
            Stack<TreeNode> stack = new Stack<>();
            // 使用迭代方式实现中序遍历
            while (!stack.isEmpty() || root != null) {
                // 遍历左子树并将其节点入栈
                if (root != null) {
                    stack.push(root);
                    root = root.left;  // 继续往左子树深入
                } else {
                    // 当没有左子树可遍历时，弹出栈顶节点并处理
                    root = stack.pop();
                    result.add(root.val);  // 将节点值添加到结果列表
                    root = root.right;  // 转向右子树
                }
            }
        }
        return result;
    }
    public List<Integer> inorderTraversal1(TreeNode root) {
        //递归实现
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);             // 注意这一句
        inorder(root.right, list);
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
