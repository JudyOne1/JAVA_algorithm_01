package dynamic;

import java.util.ArrayList;
import java.util.List;

public class leetcode118 {
    public List<List<Integer>> generate(int numRows) {
        int[][] map = new int[numRows + 1][numRows + 1];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = map[i - 1][j - 1] + map[i - 1][j];
                }
                list.add(map[i][j]);
            }
            result.add(list);
        }
        return result;
    }

}