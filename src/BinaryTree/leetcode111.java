package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode111 {
    public int minDepth(TreeNode root) {
        //同样使用层序遍历，内部加一个条件判断
        // 用于存储结果的列表

        // 如果根节点为空，直接返回空结果列表
        if (root == null) return 0;

        // 使用队列进行层级遍历
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root); // 将根节点入队列
        int depth = 0;
        // 当队列不为空时，持续进行层级遍历
        while (!queue.isEmpty()) {
            // 当前层的节点列表
            List<Integer> itemList = new ArrayList<Integer>();
            depth++;//加一层
            int len = queue.size(); // 当前层的节点数量

            // 遍历当前层的所有节点
            while (len > 0) {
                TreeNode tmpNode = queue.poll(); // 取出队列中的节点

                if (tmpNode.left == null && tmpNode.right == null) {
                    // 是叶子结点，直接返回depth，因为从上往下遍历，所以该值就是最小值
                    return depth;
                }
                // 如果节点有左孩子，则将其入队列
                if (tmpNode.left != null) queue.offer(tmpNode.left);
                // 如果节点有右孩子，则将其入队列
                if (tmpNode.right != null) queue.offer(tmpNode.right);
                len--; // 当前层节点数量减一
            }

        }

        return depth;









//        if (root == null) {
//            return 0;
//        }
//        if (root.left == null && root.right == null) {
//            return 1;
//        }
//        if (root.left == null) {
//            return minDepth(root.right) + 1;
//        }
//        if (root.right == null) {
//            return minDepth(root.left) + 1;
//        }
//        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
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
