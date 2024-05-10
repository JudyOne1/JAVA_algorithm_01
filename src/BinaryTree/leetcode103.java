package BinaryTree;

import java.util.*;

public class leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            if (ans.size() % 2 > 0) Collections.reverse(list);
            ans.add(list);
        }
        return ans;
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
