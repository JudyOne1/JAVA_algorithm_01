package BinaryTree;

public class leetcode236 {

    public TreeNode lowestCommonAncestor4(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor4(root.left, p, q);
        TreeNode right = lowestCommonAncestor4(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;

    }


    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor3(root.left, p, q);
        TreeNode right = lowestCommonAncestor3(root.left, p, q);

        if (left == null && right == null) {
            return null;
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }

    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        /**
         * 如果 left 和 right 都不为空，说明 p 和 q 被分隔在当前根节点的两侧（一个在左子树，一个在右子树），
         * 因此当前根节点就是它们的最低公共祖先。
         *
         * 如果 left 为空但 right 不为空，或者 right 为空但 left 不为空，
         * 说明 p 和 q 都位于当前根节点的同一侧（全部在左子树或全部在右子树），
         * 则返回非空的那一侧的结果。
         */
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) { // 递归结束条件，找到了 p 或 q 或者遍历到空节点
            return root;
        }

        // 后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) { // 若未找到节点 p 或 q
            return null;
        } else if (left == null && right != null) { // 若找到一个节点
            return right;
        } else if (left != null && right == null) { // 若找到一个节点
            return left;
        } else { // 若找到两个节点
            return root;
        }
    }

    static class TreeNode {
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
