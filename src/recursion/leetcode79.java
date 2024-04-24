package recursion;

public class leetcode79 {
    public boolean exist(char[][] board, String word) {
        //先遍历整个二维数组，找到word的第一个字母，然后从该位置开始，进行深度优先遍历
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // 如果当前索引超出单词长度，或当前位置超出网格范围，或当前位置的字符与当前搜索字母不匹配，则返回false
        if (index > word.length()
                || i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(index)) {
            return false;
        }
        // 如果当前搜索的是单词的最后一个字母，则匹配成功
        if (index == word.length()-1) {
            return true;
        }

        // 将当前位置的字符标记为已访问
        board[i][j] = ' ';

        // 递归搜索上下左右四个方向
        boolean res = dfs(board, word, i + 1, j, index + 1) ||
                dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) ||
                dfs(board, word, i, j - 1, index + 1);

        // 搜索完成后，恢复当前位置的字符
        board[i][j] = word.charAt(index);

        return res;
    }

}

