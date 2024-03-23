package BinaryTree;

public class leetcode450 {

    public static TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return root;
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }
        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);
        return root;

        //叶子节点删除简单，非叶子节点删除要分情况讨论
        //1.如果要删除的节点是叶子节点，直接删除即可
        //2.如果删除的是根结点，给左右的某个孩子即可
        //3.有左也有右

//        if (root == null) {
//            return null;
//        }
//        if (root.val == key && root.left == null && root.right == null) {
//            return null;
//        }
//        if (root.val == key && root.left != null && root.right != null) {
//            TreeNode temp = root;
//            if (temp.right.left != null) {
//                temp = temp.right;
//                while (temp.left.left != null) {
//                    temp = temp.left;
//                }
//                root.val = temp.left.val;
//                temp.left = null;
//                return root;
//            } else {
//                root = temp.right;
//                root.left = temp.left;
//                return root;
//            }
//
//        }
//
//        //左or右
//        boolean isLeft = false;
//        if (root.val > key) {
//            isLeft = true;
//        }
//
//        TreeNode head = root;
//        while (true) {
//            if (root.val == key) {
//                TreeNode temp = root;
//                if (root.left == null) {
//                    root = root.right;
//                    return head;
//                } else if (root.right == null) {
//                    root = root.left;
//                    return head;
//                } else {
//                    //有左也有右
//                    if (isLeft) {
//                        //是左子树，拿右子树的最小值，往左
//                        if (root.right.left == null && root.right.right == null) {
//                            //右节点没有孩子
//                            temp.val = temp.right.val;
//                            root.right = null;
//                            return head;
//                        }
//                        root = root.right;
//                        while (root.left != null) {
//                            //右节点有孩子，找最左孩子
//                            if (root.left.left == null) {
//                                temp.val = temp.left.val;
//                                root.left = null;
//                                return head;
//                            }
//                            root = root.right;
//                        }
//                    } else {
//                        //是右子树，拿左子树的最大值，往右
//                        if (root.left.left == null && root.left.right == null) {
//                            temp.val = temp.left.val;
//                            root.left = null;
//                            return head;
//                        }
//                        root = root.left;
//                        while (root.right != null) {
//                            if (root.right.right == null) {
//                                temp.val = temp.right.val;
//                                root.right = null;
//                                return head;
//                            }
//                            root = root.right;
//                        }
//                    }
//                }
//            } else if (root.val > key && root.left != null) {
//                if (root.left.left == null && root.left.right == null && root.left.val == key) {
//                    root.left = null;
//                    return head;
//                }
//                root = root.left;
//            } else if (root.val < key && root.right != null) {
//                if (root.right.left == null && root.right.right == null && root.right.val == key) {
//                    root.right = null;
//                    return head;
//                }
//                root = root.right;
//            } else {
//                return head;
//            }
//        }

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(0), new TreeNode(2));
        deleteNode(treeNode, 0);
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
