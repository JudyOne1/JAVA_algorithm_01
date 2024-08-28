package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode98 {

    public boolean isValidBST2(TreeNode root) {
        return dfs2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs2(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        return root.val > left && root.val < right
                && dfs2(root.left, left, root.val)
                && dfs2(root.right, root.val, right);
    }


    public boolean isValidBST1(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long left, long right) {
        // 当前节点为空，可视为满足条件
        if (node == null)
            return true;
        long x = node.val; // 当前节点的值

        // 判断当前节点是否位于区间内，并递归判断左右子树
        return left < x && x < right &&
                dfs(node.left, left, x) && // 遍历左子树，左子树节点的值必须大于left且小于x
                dfs(node.right, x, right); // 遍历右子树，右子树节点的值必须大于x且小于right
    }

    public boolean isValidBST(TreeNode root) {
        // 使用中序遍历将二叉搜索树的节点值存入列表中，由于二叉搜索树的特性，列表中的元素会按顺序排列，只需要判断是否符合升序即可
        List<Integer> result = new ArrayList<Integer>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            // 迭代方式实现中序遍历
            while (!stack.isEmpty() || root != null) {
                // 遍历左子树并将其节点入栈
                if (root != null) {
                    stack.push(root);
                    root = root.left;  // 向左子树深入
                } else {
                    // 没有左子树可遍历时，处理栈顶节点
                    root = stack.pop();
                    result.add(root.val);  // 将节点值添加到结果列表
                    root = root.right;  // 转向右子树
                }
            }
        }
        // 将列表转换为数组，方便后续处理，因为是二叉搜索树，所以默认已经排好序了
        Integer[] array = result.toArray(new Integer[result.size()]);
        int AbsMinNum = Integer.MAX_VALUE;
        // 遍历数组，判断是否符合升序
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] >= array[i]) {
                return false;
            }
        }
        return true;
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
