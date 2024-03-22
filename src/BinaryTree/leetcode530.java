package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode530 {
    /**
     * 获取二叉搜索树中相邻节点值的最小差值。
     * @param root 二叉搜索树的根节点。
     * @return 最小差值。
     */
    public int getMinimumDifference(TreeNode root) {
        // 使用中序遍历将二叉搜索树的节点值存入列表中，由于二叉搜索树的特性，列表中的元素会按顺序排列
        List<Integer> result = new ArrayList<Integer>();
        if(root != null) {
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
        // 遍历数组，计算相邻元素的差值的绝对值，并找出最小值
        for (int i = 1; i < array.length; i++) {
            AbsMinNum = Math.min(AbsMinNum, Math.abs(array[i] - array[i - 1]));
        }
        return AbsMinNum;
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
