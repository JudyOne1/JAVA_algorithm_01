package Greedy;

import BinaryTree.leetcode104;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode968 {
    int res = 0;

    public int minCameraCover(TreeNode root) {
        // 对根节点的状态做检验,防止根节点是无覆盖状态 .
        if (minCame(root) == 0) {
            res++;
        }
        return res;
    }

    /**
     * 节点的状态值：
     * 0 表示无覆盖
     * 1 表示 有摄像头
     * 2 表示有覆盖
     * 后序遍历，根据左右节点的情况,来判读 自己的状态
     */
    public int minCame(TreeNode root) {
        if (root == null) {
            // 空节点默认为 有覆盖状态，避免在叶子节点上放摄像头
            return 2;
        }
        int left = minCame(root.left);
        int right = minCame(root.right);

        // 如果左右节点都覆盖了的话, 那么本节点的状态就应该是无覆盖,没有摄像头
        if (left == 2 && right == 2) {
            //(2,2)
            return 0;
        } else if (left == 0 || right == 0) {
            // 左右节点都是无覆盖状态,那 根节点此时应该放一个摄像头
            // (0,0) (0,1) (0,2) (1,0) (2,0)
            // 状态值为 1 摄像头数 ++;
            res++;
            return 1;
        } else {
            // 左右节点的 状态为 (1,1) (1,2) (2,1) 也就是左右节点至少存在 1个摄像头，
            // 那么本节点就是处于被覆盖状态
            return 2;
        }
    }
    // 层序遍历，条件不充分，有些用例测试不通过
//    public int minCameraCover(TreeNode root) {
//        //只需要计算出有几层，然后找到对应的层数节点相加，就可以知道有几个摄像头
//        if (root == null) {
//            return 0;
//        } else if (root.left == null && root.right == null) {
//            return 1;
//        }
//        // 用于存储结果的列表
//        ArrayList<List<Integer>> resList = new ArrayList<List<Integer>>();
//        // 使用队列进行层级遍历
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(root); // 将根节点入队列
//
//        // 当队列不为空时，持续进行层级遍历
//        while (!queue.isEmpty()) {
//            // 当前层的节点列表
//            List<Integer> itemList = new ArrayList<Integer>();
//            int len = queue.size(); // 当前层的节点数量
//
//            // 遍历当前层的所有节点
//            while (len > 0) {
//                TreeNode tmpNode = queue.poll(); // 取出队列中的节点
//                itemList.add(tmpNode.val); // 将节点值添加到当前层的节点列表中
//
//                // 如果节点有左孩子，则将其入队列
//                if (tmpNode.left != null) queue.offer(tmpNode.left);
//                // 如果节点有右孩子，则将其入队列
//                if (tmpNode.right != null) queue.offer(tmpNode.right);
//                len--; // 当前层节点数量减一
//            }
//
//            // 将当前层的节点列表添加到结果列表中
//            resList.add(itemList);
//        }
//        int count1 = 0;
//        int count0 = 0;
//        if (resList.size() < 3) {
//            return 1;
//        }
//        for (int i = 0; i < resList.size(); i++) {
//            int index = 2 * i;
//
//            if (index < resList.size()) {
//                List<Integer> itemList = resList.get(index);
//                count0 += itemList.size();
//            }
//            if (++index < resList.size()) {
//                List<Integer> itemList = resList.get(index);
//                count1 += itemList.size();
//            } else {
//                break;
//            }
//        }
//        if (resList.size() % 3 == 0) {
//            int count2 = 0;
//            for (int i = 1; i < resList.size(); i += 3) {
//                List<Integer> itemList = resList.get(i);
//                count2 += itemList.size();
//            }
//            return Math.min(Math.min(count0, count1), count2);
//        }
//        if (resList.size() % 3 == 2) {
//            int count2 = 0;
//            for (int i = 0; i < resList.size(); i += 3) {
//                List<Integer> itemList = resList.get(i);
//                count2 += itemList.size();
//            }
//            return Math.min(Math.min(count0, count1), count2);
//        }
//
//        return Math.min(count0, count1);
//
//    }

    public static class TreeNode {
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

    public static void main(String[] args) {
        System.out.println(new leetcode968().minCameraCover(new TreeNode(0, new TreeNode(0), new TreeNode(0, null, new TreeNode(0)))));
    }
}
