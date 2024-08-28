package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode199 {
    /**
     * 思路：先递归右子树，再递归左子树，
     * 当某个深度首次到达时，对应的节点就在右视图中。
     */
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode root, int depth, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (depth == ans.size()) { // 这个深度首次遇到
            ans.add(root.val);
        }
        dfs(root.right, depth + 1, ans); // 先递归右子树，保证首次遇到的一定是最右边的节点
        dfs(root.left, depth + 1, ans);
    }

    public List<Integer> resList = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        //层序遍历 每层最右边的节点
        if (root == null) return resList;
        bfs(root);
        return resList;
    }
    public void bfs(TreeNode node){
        if (node == null) return; // 如果根节点为空，则直接返回，不做任何操作
        Queue<TreeNode> que = new LinkedList<>(); // 使用队列存储待访问的节点
        que.offer(node); // 将根节点加入队列
        while (!que.isEmpty()){ // 当队列不为空时，表示还有节点未被访问
            int len = que.size(); // 记录当前层的节点数量
            ArrayList<Integer> funList = new ArrayList<>(); // 用于存储当前层节点的值
            while (len > 0){ // 遍历当前层的所有节点
                TreeNode tempNode = que.poll(); // 取出队列的节点
                funList.add(tempNode.val); // 将节点值加入到当前层的列表中
                len--; // 当前层节点数量减一
                if (tempNode.left != null) que.offer(tempNode.left); // 如果有左子节点，则将其加入队列
                if (tempNode.right != null) que.offer(tempNode.right); // 如果有右子节点，则将其加入队列
            }
            resList.add(funList.get(funList.size() - 1)); // 将当前层的最后一个节点值加入到resList中
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
