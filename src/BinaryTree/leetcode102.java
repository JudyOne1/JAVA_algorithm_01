package BinaryTree;

import java.util.*;

/**
 * 层序遍历二叉树
 */
public class leetcode102 {
/**
 * 以层级遍历的方式返回二叉树的节点值列表列表。
 * @param root 二叉树的根节点。如果根节点为null，则返回空列表。
 * @return 一个列表的列表，其中每个子列表表示二叉树的一层节点值。如果二叉树为空，则返回空列表。
 */
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


    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     if (root == null) {
    //         return null;
    //     }
    //     ArrayList<Integer> result = new ArrayList<>();
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.add(root);
    //     while (!queue.isEmpty()) {
    //         TreeNode cur = queue.poll();
    //         result.add(cur.val);
    //         if (cur.left != null)
    //             queue.add(cur.left);
    //         if (cur.right != null)
    //             queue.add(cur.right);
    //     }
    //     return Collections.singletonList(result);
    // }
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
