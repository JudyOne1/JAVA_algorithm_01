package map;

import java.util.ArrayList;
import java.util.List;

public class leetcode797 {
    List<List<Integer>> ans;		// 用来存放满足条件的路径
    List<Integer> cnt;		// 用来保存 dfs 过程中的节点值

    public void dfs(int[][] graph, int node) {
        // 如果当前节点是目标节点，则保存这条路径
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(cnt));
            return;
        }
        // 遍历当前节点的所有邻居节点
        for (int index = 0; index < graph[node].length; index++) {
            int nextNode = graph[node][index];
            cnt.add(nextNode); // 将下一个节点加入当前路径
            dfs(graph, nextNode); // 递归访问下一个节点
            cnt.remove(cnt.size() - 1);// 回溯，移除最后一个节点
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        cnt = new ArrayList<>();
        cnt.add(0);			 // 将源节点加入初始路径
        dfs(graph, 0); // 从源节点开始深度优先搜索
        return ans;
    }
}
