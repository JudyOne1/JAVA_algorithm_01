package BinaryTree;

import java.util.*;

public class leetcode501 {
    public static int[] findMode(TreeNode root) {
        // 使用中序遍历将二叉搜索树的节点值存入列表中，由于二叉搜索树的特性，列表中的元素会按顺序排列，只需要找出最多的元素即可
        List<Integer> resultNODE = new ArrayList<Integer>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            // 迭代方式实现中序遍历
            while (!stack.isEmpty() || root != null) {
                // 遍历左子树并将其节点入栈
                if (root != null) {
                    stack.push(root);
                    root = root.left;  // 向左子树深入
                } else {
                    // 没有左子树可遍历时，处理栈顶节点
                    root = stack.pop();
                    resultNODE.add(root.val);  // 将节点值添加到结果列表
                    root = root.right;  // 转向右子树
                }
            }
        }
        Integer[] numbers = resultNODE.toArray(new Integer[resultNODE.size()]);
        // 使用HashMap统计每个数字的数量
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : numbers) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 找出数量最大的数字（可能有多个）
        int maxCount = 0;
        List<Integer> maxNumbers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxNumbers.clear();
                maxNumbers.add(entry.getKey());
            } else if (entry.getValue() == maxCount) {
                maxNumbers.add(entry.getKey());
            }
        }
        return maxNumbers.stream().mapToInt(Integer::intValue).toArray();
//        Integer[] array = resultNODE.toArray(new Integer[resultNODE.size()]);
//
//        int[] count = new int[array[array.length-1]];
//        // 遍历数组，整理元素
//        for (int i = 0; i < array.length; i++) {
//            count[array[i]]++;
//        }
//        int MaxCount = -1;
//        // 遍历数组，找出最大的数字
//        for (int i = 1; i < count.length; i++) {
//            if (count[i] > count[i - 1] && count[i] > MaxCount) {
//                MaxCount = count[i];
//            }
//        }
//        List<Integer> result = new ArrayList<Integer>();
//        // 遍历数组，选出众数
//        for (int i = 0; i < count.length; i++) {
//            if (count[i] == MaxCount) {
//                result.add(i);
//            }
//        }
//        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        findMode(new TreeNode(1,null,new TreeNode(2)));
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
