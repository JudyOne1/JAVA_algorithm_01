package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode224 {
    public int widthOfBinaryTree(TreeNode root) {
        // 如果根节点为空，返回宽度为0
        if (root == null) return 0;

        // 使用队列来进行层次遍历
        Queue<TreeNode> q = new LinkedList<>();
        // 使用链表来存储节点对应的层次索引
        LinkedList<Integer> list = new LinkedList<>();

        // 初始化队列和层次索引链表
        q.offer(root);
        list.add(1);

        // 初始化结果为1，因为最开始只有一颗根节点
        int res = 1;

        // 层次遍历二叉树
        while (!q.isEmpty()) {
            // 当前层的节点数量
            int count = q.size();

            // 遍历当前层的所有节点
            for (int i = count; i > 0; i--) {
                TreeNode cur = q.poll();
                Integer curIndex = list.removeFirst();

                // 如果当前节点有左子节点，则将左子节点加入队列，并更新层次索引
                if (cur.left != null) {
                    q.offer(cur.left);
                    list.add(curIndex * 2);
                }

                // 如果当前节点有右子节点，则将右子节点加入队列，并更新层次索引
                if (cur.right != null) {
                    q.offer(cur.right);
                    list.add(curIndex * 2 + 1);
                }
            }

            // 计算当前层的宽度，并更新最大宽度
            if (list.size() >= 2) {
                res = Math.max(res, list.getLast() - list.getFirst() + 1);
            }
        }

        // 返回最大宽度
        return res;
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
