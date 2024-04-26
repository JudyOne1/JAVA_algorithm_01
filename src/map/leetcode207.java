package map;

import java.util.ArrayList;
import java.util.List;

public class leetcode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 初始化邻接表，记录课程之间的先决条件关系
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        int[] flags = new int[numCourses]; // 标记数组，用于DFS过程中标记课程状态
        // 填充邻接表，建立课程之间的先决条件关系
        for (int[] cp : prerequisites) {
            adjacency.get(cp[1]).add(cp[0]);
        }
        // 遍历所有课程，利用深度优先搜索判断是否可以完成所有课程的学习
        for (int i = 0; i < numCourses; i++) {
            //找是否存在环
            if (!dfs(adjacency, flags, i)) {
                return false;
            }
        }
        return true;
    }

    /*
    0：未搜过的节点，继续搜索；
1：回到了当前路径上正在搜索的节点，有环；
-1：已经处理过的节点，无需再搜索，无环；
     */
    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        // 如果当前课程已经被访问过，则直接返回false，避免环的出现
        if (flags[i] == 1) return false;
        // 如果当前课程已经访问完成，则返回true
        if (flags[i] == -1) return true;
        // 标记当前课程访问过
        flags[i] = 1;
        // 遍历当前课程的所有依赖课程，递归判断是否可以完成所有依赖课程的学习
        for (Integer j : adjacency.get(i)) {
            if (!dfs(adjacency, flags, j)) {
                return false;
            }
        }
        // 标记当前课程为已访问完成
        flags[i] = -1;
        return true;
    }
}
