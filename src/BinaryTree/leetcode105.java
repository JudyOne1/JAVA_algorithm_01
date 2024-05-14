package BinaryTree;

import java.util.Arrays;

public class leetcode105 {
    /**
     * 前序遍历性质： 节点按照 [ 根节点 | 左子树 | 右子树 ] 排序。
     * 中序遍历性质： 节点按照 [ 左子树 | 根节点 | 右子树 ] 排序。
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) {
            return null;
        }
        int leftSize = indexOf(inorder, preorder[0]);
        int[] pre1 = Arrays.copyOfRange(preorder, 1, leftSize + 1);
        int[] pre2 = Arrays.copyOfRange(preorder, 1 + leftSize, n);
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(inorder, 1 + leftSize, n);
        TreeNode left = buildTree(pre1, in1);
        TreeNode right = buildTree(pre2, in2);
        return new TreeNode(preorder[0], left, right);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) { // 处理空节点情况
            return null;
        }
        // 【左子树的大小】找到根节点在中序序列中的位置，分割左右子树
        int leftSize = indexOf(inorder, preorder[0]);
        // 分割前序序列得到左子树和右子树的部分
        int[] pre1 = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] pre2 = Arrays.copyOfRange(preorder, 1 + leftSize, n);
        // 分割中序序列得到左子树和右子树的部分
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(inorder, 1 + leftSize, n);
        // 递归构造左子树和右子树
        TreeNode left = buildTree(pre1, in1);
        TreeNode right = buildTree(pre2, in2);
        // 构造当前根节点并返回
        return new TreeNode(preorder[0], left, right);
    }

    // 返回 x 在 a 中的下标，保证 x 一定在 a 中
    private int indexOf(int[] a, int x) {
        for (int i = 0; ; i++) {
            if (a[i] == x) {
                return i;
            }
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
