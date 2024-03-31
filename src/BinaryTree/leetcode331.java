package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode331 {
    //https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/solutions/651132/pai-an-jiao-jue-de-liang-chong-jie-fa-zh-66nt
    public boolean isValidSerialization(String preorder) {
        Stack<String> stk = new Stack<>();
        String[] nodes = preorder.split(",");
        for (String tmp : nodes) {
            stk.push(tmp);
            int len = stk.size();
            // 用「#」替换 「数字##」
            while (len >= 3
                    && stk.peek().equals("#")
                    && stk.get(len - 2).equals("#")
                    && !stk.get(len - 3).equals("#")) {
                stk.pop();
                stk.pop();
                stk.pop();
                stk.push("#");
                len = stk.size();
            }
        }

        // 如果最后模拟栈中只剩一个#，说明是合法的序列
        return stk.size() == 1 && stk.peek().equals("#");
    }

}
