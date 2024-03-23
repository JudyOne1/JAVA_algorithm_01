package BinaryTree;

/**
 * 给定两个整数数组 inorder 和 postorder ，
 * 其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，
 * 请你构造并返回这颗 二叉树 。
 */
public class leetcode106 {

    /**
     * 根据二叉树的中序遍历和后序遍历结果重建二叉树。
     * 后序数组的最后一个元素为切割点，先切中序数组，根据中序数组，
     * 反过来再切后序数组。一层一层切下去，每次后序数组最后一个元素就是节点元素。
     *
     * @param inorder 二叉树的中序遍历结果。
     * @param postorder 二叉树的后序遍历结果。
     * @return 重建的二叉树的根节点。
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 如果中序或后序数组为空，则返回null
        if(postorder.length == 0 || inorder.length == 0)
            return null;
        // 调用辅助函数进行递归构建
        return buildHelper(inorder, 0, inorder.length, postorder, 0, postorder.length);

    }
    /**
     * 辅助函数：递归根据中序和后序数组构建二叉树。
     *
     * @param inorder 中序遍历数组。
     * @param inorderStart 中序开始索引。
     * @param inorderEnd 中序结束索引。
     * @param postorder 后序遍历数组。
     * @param postorderStart 后序开始索引。
     * @param postorderEnd 后序结束索引。
     * @return 构建的二叉树节点。
     */
    private TreeNode buildHelper(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd){
        // 如果后序数组为空，则返回null
        if(postorderStart == postorderEnd)
            return null;
        // 后序数组的最后一个元素为当前子树的根节点
        int rootVal = postorder[postorderEnd - 1];
        TreeNode root = new TreeNode(rootVal);
        int middleIndex;
        // 找到中序数组中根节点的索引
        for (middleIndex = inorderStart; middleIndex < inorderEnd; middleIndex++){
            if(inorder[middleIndex] == rootVal)
                break;
        }

        // 根据中序索引划分左右子树的范围
        int leftInorderStart = inorderStart;
        int leftInorderEnd = middleIndex;
        int rightInorderStart = middleIndex + 1;
        int rightInorderEnd = inorderEnd;

        // 根据左右子树在中序中的长度，划分后序数组的范围
        int leftPostorderStart = postorderStart;
        int leftPostorderEnd = postorderStart + (middleIndex - inorderStart);
        int rightPostorderStart = leftPostorderEnd;
        int rightPostorderEnd = postorderEnd - 1;

        // 递归构建左右子树
        root.left = buildHelper(inorder, leftInorderStart, leftInorderEnd,  postorder, leftPostorderStart, leftPostorderEnd);
        root.right = buildHelper(inorder, rightInorderStart, rightInorderEnd, postorder, rightPostorderStart, rightPostorderEnd);

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
