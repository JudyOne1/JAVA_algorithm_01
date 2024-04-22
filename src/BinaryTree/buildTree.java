package BinaryTree;

import java.util.Arrays;

public class buildTree {
    public TreeNode buildTreeByInAndPost(int[] inorder, int[] postorder) {
        //从中序与后序遍历序列构造二叉树
        //https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solutions/2647794/tu-jie-cong-on2-dao-onpythonjavacgojsrus-w8ny/
        int n = postorder.length;
        if (n == 0) { // 处理空树情况
            return null;
        }
        // 找到后序遍历最后一个元素在中序遍历中的位置，以分割左右子树
        int leftSize = indexOf(inorder, postorder[n - 1]);
        // 划分中序遍历数组为左子树和右子树部分
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(inorder, leftSize + 1, n);
        // 划分后序遍历数组为左子树和右子树部分
        int[] post1 = Arrays.copyOfRange(postorder, 0, leftSize);
        int[] post2 = Arrays.copyOfRange(postorder, leftSize, n - 1);
        // 递归构建左子树和右子树
        TreeNode left = buildTreeByInAndPost(in1, post1);
        TreeNode right = buildTreeByInAndPost(in2, post2);
        // 返回根节点
        return new TreeNode(postorder[n - 1], left, right);
    }
    public TreeNode buildTreeByPreAndIn(int[] preorder, int[] inorder) {
        //从前序与中序遍历序列构造二叉树
        //https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/2646359/tu-jie-cong-on2-dao-onpythonjavacgojsrus-aob8
        int n = preorder.length;
        if (n == 0) { // 处理空节点情况
            return null;
        }
        // 【左子树的大小】找到根节点在中序序列中的位置，分割左右子树
        int leftSize = indexOf(inorder, preorder[0]);
        // 分割前序序列得到左子树和右子树的部分
        int[] preLeft = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] preRight = Arrays.copyOfRange(preorder, 1 + leftSize, n);
        // 分割中序序列得到左子树和右子树的部分
        int[] innerLeft = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] innerRight = Arrays.copyOfRange(inorder, 1 + leftSize, n);
        // 递归构造左子树和右子树
        TreeNode left = buildTreeByPreAndIn(preLeft, innerLeft);
        TreeNode right = buildTreeByPreAndIn(preRight, innerRight);
        // 构造当前根节点并返回
        return new TreeNode(preorder[0], left, right);
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        //根据前序和后序遍历构造二叉树
        //https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/solutions/2649218/tu-jie-cong-on2-dao-onpythonjavacgojsrus-h0o5
        int n = preorder.length;
        if (n == 0) { // 处理空节点情况
            return null;
        }
        if (n == 1) { // 处理只有一个元素的叶子节点情况
            return new TreeNode(preorder[0]);
        }
        // 计算左子树的大小
        int leftSize = indexOf(postorder, preorder[1]) + 1;
        // 根据左子树大小划分前序序列
        int[] pre1 = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] pre2 = Arrays.copyOfRange(preorder, 1 + leftSize, n);
        // 根据左子树大小划分后序序列
        int[] post1 = Arrays.copyOfRange(postorder, 0, leftSize);
        int[] post2 = Arrays.copyOfRange(postorder, leftSize, n - 1);
        // 递归构造左子树和右子树
        TreeNode left = constructFromPrePost(pre1, post1);
        TreeNode right = constructFromPrePost(pre2, post2);
        // 构造当前节点并返回
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
