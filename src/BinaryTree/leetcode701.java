package BinaryTree;

public class leetcode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            //走到尽头，插入一个节点val
            return new TreeNode(val);
        }
        if (val < root.val){
            //往左走
            root.left = insertIntoBST(root.left, val);
        }else {
            //往右走
            root.right = insertIntoBST(root.right, val);
        }
        return root;
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
