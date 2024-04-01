package string;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode2810 {
    public String finalString(String s) {
        Deque<Character> q = new ArrayDeque<>();
        boolean tail = true; // 初始添加方向为尾部

        // 遍历字符串，根据规则添加字符
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                tail = !tail; // 遇到'i'时，修改添加方向
            } else if (tail) {
                q.addLast(c); // 向尾部添加字符
            } else {
                q.addFirst(c); // 向头部添加字符
            }
        }

        StringBuilder ans = new StringBuilder();
        // 将队列中的字符构建为字符串
        for (char c : q) {
            ans.append(c);
        }

        // 如果最后的方向是头部，则反转字符串
        if (!tail) {
            ans.reverse();
        }
        return ans.toString();

//        String res = "";
//        String[] split = s.split("i");
//        boolean flag = false;
//        if (s.lastIndexOf("i") == s.length() - 1) {
//            flag = true;
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < split.length; i++) {
//            if (i == split.length - 1) {
//                res += split[i];
//            } else {
//                sb.append(split[i]);
//                res = sb.reverse().toString();
//            }
//        }
//        if (flag) {
//            res = new StringBuilder(res).reverse().toString();
//        }
//        return res;
    }

    public static void main(String[] args) {
        new leetcode2810().finalString("siiuii");
    }
}
