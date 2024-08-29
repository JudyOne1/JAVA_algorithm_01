package stackAndList;

import java.util.LinkedList;
import java.util.Stack;

public class leetcode394 {
    public String decodeString3(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int num = 0;
        String curString = "";
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)){
                num = num * 10 + cur - '0';
            } else if (cur == '[') {
                numStack.push(num);
                strStack.push(curString);
                num = 0;
                curString = "";
            } else if (cur == ']') {
                int times = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                for (int j = 0; j < times; j++) {
                    temp.append(curString);
                }
                curString = temp.toString();
            }else {
                curString+=cur;
            }
        }
        return curString;
    }
    public String decodeString2(String s) {
        //双栈，一个栈模拟数字，一个栈模拟字符串
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        int num = 0;
        String curString = "";

        for (int i = 0; i < s.length(); i++) {
            //当前字符
            char c = s.charAt(i);

            //如果是数字
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                //如果是左括号，就把当前数字和字符入栈,同时重置当前数字和当前字符串
                numStack.push(num);
                stringStack.push(curString);
                num = 0;
                curString = "";
            } else if (c == ']') {
                //如果是右括号，就进行解码
                //1、得到当前字符串要重复的次数，也就是[]前的数字
                int loopTimes = numStack.pop();
                //注意这里创建的是栈顶元素的string容器
                StringBuilder temp = new StringBuilder(stringStack.pop());
                for (int j = 0; j < loopTimes; j++) {
                    temp.append(curString);
                }
                curString = temp.toString();
            } else {
                //如果是字母就更新当前字母
                curString += c;
            }
        }
        return curString;
    }

    public String decodeString1(String s) {
        StringBuilder sb = new StringBuilder();
        while (s.contains("[")) {
            //第一对括号的起始位置和结束位置
            int startEqual = 0, endEqual = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '[') startEqual = i;
                if (s.charAt(i) == ']') {
                    endEqual = i;
                    break;
                }
            }

            //括号中的字符串sub
            String sub = s.substring(startEqual + 1, endEqual);

            //向后扫描，找到数字开始的位置;
            int numIndex = startEqual - 1;
            while (numIndex >= 0 && Character.isDigit(s.charAt(numIndex))) numIndex--;

            //需要重复的次数
            int times = Integer.parseInt(s.substring(numIndex + 1, startEqual));

            //将"["括号数字之前的字符添加到sb中
            sb.append(s, 0, numIndex + 1);
            while (times-- > 0)
                sb.append(sub);
            //将"]"右括号之后的字符添加到sb中
            sb.append(s, endEqual + 1, s.length());

            s = sb.toString();
            sb = new StringBuilder();
        }
        return s;
    }


    public String decodeString(String s) {
        StringBuilder res = new StringBuilder(); // 用于构建解码后的字符串
        int multi = 0; // 用于存储当前字符前的数字，代表重复次数
        LinkedList<Integer> stack_multi = new LinkedList<>(); // 用于存储遇到的重复次数
        LinkedList<String> stack_res = new LinkedList<>(); // 用于存储中间解码结果

        for (Character c : s.toCharArray()) { // 遍历字符串中的每个字符
            if (c == '[') {
                // 遇到左括号，将当前的重复次数和中间结果入栈
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                // 重置重复次数和中间结果
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                // 遇到右括号，根据栈中的重复次数，将当前中间结果重复多次，并与栈顶的中间结果合并
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                // 遇到数字，将其构成的数字串解析为整数，更新重复次数
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                // 遇到字母或其他非数字非括号字符，直接添加到中间结果
                res.append(c);
            }
        }
        return res.toString(); // 返回最终解码后的字符串
    }
}
