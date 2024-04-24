package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class leetcode216 {

    public List<List<Integer>> combinationSum31(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        int index = 1;//1~9选与不选
        dfs(result, path, index, k, n);
        return result;
    }

    private void dfs(List<List<Integer>> result, LinkedList<Integer> path, int index, int k, int n) {


        // 如果已经使用了k个数字且和为n，则找到一个满足条件的组合
        if (k == 0 && n == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        // 如果考虑的数字索引超过9（即超过了0-9这10个数字），则结束递归
        if (index > 9){
            return;
        }
        // 如果剩余可选数字数量小于0或目标和小于0，说明当前路径无法得到满足条件的组合，结束递归
        if (k < 0 || n < 0) {
            return;
        }

        // 不选择当前数字，继续递归探索下一个数字
        dfs(result, path, index + 1, k, n);

        // 选择当前数字，继续递归探索下一个数字，同时考虑k和n的减少
        path.add(index);
        dfs(result, path, index + 1, k - 1, n - index);
        path.removeLast(); // 回溯，移除刚刚添加的数字

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        process(n, k, 1, result, path);
        return result;
    }

    public void process(int n, int k, int startIndex, List<List<Integer>> result, LinkedList<Integer> path) {
        // 当路径长度达到k时
        if (path.size() == k) {
            int sum = 0;
            for (Integer i : path) {
                sum += i;
            }
            // 当结果等于n时，将路径加入结果列表
            if (sum == n) {
                result.add(new ArrayList<>(path));
                return;
            }
            return;
        } else if (path.size() > k) {
            return;
        }
        // 从startIndex开始一直到9，尝试所有可能的元素
        for (int i = startIndex; i <= 9; i++) {
            path.add(i); // 将当前元素加入路径
            process(n, k, i + 1, result, path); // 递归尝试下一个元素
            path.removeLast();//回溯
        }
    }

    public static void main(String[] args) {
        leetcode216 l = new leetcode216();
        System.out.println(l.combinationSum3(3, 7));
    }

}
