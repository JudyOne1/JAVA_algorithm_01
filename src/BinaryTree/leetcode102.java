package BinaryTree;

import java.util.*;

/**
 * 层序遍历二叉树
 */
public class leetcode102 {
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) return ans;
        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            int len = queue.size();

            while (len > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                len--;
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);

            }
            ans.add(list);
        }
        return ans;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 用于存储结果的列表
        ArrayList<List<Integer>> resList = new ArrayList<List<Integer>>();

        // 如果根节点为空，直接返回空结果列表
        if (root == null) return resList;

        // 使用队列进行层级遍历
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root); // 将根节点入队列

        // 当队列不为空时，持续进行层级遍历
        while (!queue.isEmpty()) {
            // 当前层的节点列表
            List<Integer> itemList = new ArrayList<Integer>();
            int len = queue.size(); // 当前层的节点数量

            // 遍历当前层的所有节点
            while (len > 0) {
                TreeNode tmpNode = queue.poll(); // 取出队列中的节点
                itemList.add(tmpNode.val); // 将节点值添加到当前层的节点列表中

                // 如果节点有左孩子，则将其入队列
                if (tmpNode.left != null) queue.offer(tmpNode.left);
                // 如果节点有右孩子，则将其入队列
                if (tmpNode.right != null) queue.offer(tmpNode.right);
                len--; // 当前层节点数量减一
            }

            // 将当前层的节点列表添加到结果列表中
            resList.add(itemList);
        }
        return resList;

    }

    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    //DFS--递归方式
    public void checkFun01(TreeNode node, Integer deep) {
        if (node == null) return; // 如果当前节点为空，则返回
        deep++; // 增加当前深度

        if (resList.size() < deep) {
            // 如果resList的大小小于当前深度，说明需要创建新的层级列表
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        // 将当前节点的值添加到对应层级的列表中
        resList.get(deep - 1).add(node.val);

        // 递归遍历左子树和右子树
        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }

    //BFS--迭代方式--借助队列
    public void checkFun02(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();

            while (len > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                len--;
            }

            resList.add(itemList);
        }

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
