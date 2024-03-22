package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode530 {
    public int getMinimumDifference(TreeNode root) {
        //二叉搜索树采用中序遍历，其实就是一个有序数组。在一个有序数组上求两个数最小差值
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
        Integer[] array = (Integer[]) result.toArray();
        return array[0];
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
