package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 */
public class leetcode77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        process(n, k, 1,result,path);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public void backtracking(int n, int k, int startIndex) {
        // 当路径长度达到k时，将路径加入结果列表
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 从当前起始索引开始，尝试所有可能的元素
        for (int i = startIndex; i <= n; i++) {
            path.add(i); // 将当前元素加入路径
            backtracking(n, k, i + 1); // 递归尝试下一个元素
            path.removeLast(); // 回溯，移除最后一个加入的元素
        }
    }

    public void process(int n, int k, int startIndex, List<List<Integer>> result, LinkedList<Integer> path) {
        // 当路径长度达到k时，将路径加入结果列表
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 从当前起始索引开始，尝试所有可能的元素
        for (int i = startIndex; i <= n; i++) {
            path.add(i); // 将当前元素加入路径
            process(n, k, i + 1,result,path); // 递归尝试下一个元素
        }
    }

}
