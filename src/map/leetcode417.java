package map;

import java.util.ArrayList;
import java.util.List;

public class leetcode417 {

    List<List<Integer>> ans;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ans = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                dfs(heights, i, j, 0);
            }
        }
        return ans;
    }

    public boolean dfs(int[][] heights, int i, int j, int pre) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || heights[i][j] < pre)
            return false;
        if (i == 0 || j == 0 || i == heights.length - 1 || j == heights[0].length - 1)
            return true;
        boolean flag = dfs(heights, i + 1, j, heights[i][j]) || dfs(heights, i - 1, j, heights[i][j]) || dfs(heights, i, j + 1, heights[i][j]) || dfs(heights, i, j - 1, heights[i][j]);
        if (flag) {
            ans.add(new ArrayList<>());
            ans.get(ans.size() - 1).add(i);
            ans.get(ans.size() - 1).add(j);
        }
        return flag;
    }
}
