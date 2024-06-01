package recursion;

import java.util.ArrayList;
import java.util.List;

public class leetcode22 {

    private int n;
    private char[] path;
    private final List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis1(int n) {
        this.n = n;
        path = new char[n * 2];
        dfs1(0, 0);
        return ans;
    }

    private void dfs1(int i, int open) {
        if (i == n * 2) {
            ans.add(new String(path));
            return;
        }
        if (open < n) { // 可以填左括号
            path[i] = '(';
            dfs1(i + 1, open + 1);
        }
        if (i - open < open) { // 可以填右括号
            path[i] = ')';
            dfs1(i + 1, open);
        }
    }


    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        String str = "";
        int leftParenthesesNums = 0;
        int index = 0;
        dfs(n, ans, str, leftParenthesesNums, index);
        return ans;
    }

    private void dfs(int n, ArrayList<String> ans, String str, int leftParenthesesNums, int index) {
        // 当处理到字符串的长度等于 n * 2 时，将其加入到结果列表中
        if (index == n * 2) {
            ans.add(str);
            return;
        }
        if (leftParenthesesNums < n) {
            //左括号数量小于n，放左括号
            str += "(";
            dfs(n, ans, str, leftParenthesesNums + 1, index + 1);
            //回溯，移除最后一个添加的左括号
            str = str.substring(0, str.length() - 1);
        }
        if (index - leftParenthesesNums < leftParenthesesNums) {
            //右括号数量小于左括号数量，放右括号
            str += ")";
            dfs(n, ans, str, leftParenthesesNums, index + 1);
        }
    }
}
