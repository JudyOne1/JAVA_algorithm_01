package string;

public class leetcode8 {
    public int myAtoi1(String s) {
        //初始化
        char[] charArray = s.trim().toCharArray();
        if (charArray.length == 0) {
            return 0;
        }
        int index = 0;
        int res = 0;
        int bindry = Integer.MAX_VALUE / 10;
        int sign = 1;
        if (charArray[0] == '-'){
            sign = -1;
            index++;
        } else if (charArray[0] == '+') {
            index++;
        }

        for (int i = index; i < charArray.length; i++) {
            if (charArray[i] > '9' || charArray[i] < '0'){
                break;
            }
            if (res > bindry || res == bindry && charArray[i] - '0' > 7){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (charArray[i] - '0');
        }
        return res * sign;

    }
    public int myAtoi(String s) {
        // 去除字符串两端的空格，并转换为字符数组
        char[] c = s.trim().toCharArray();
        // 如果字符串为空，则直接返回0
        if (c.length == 0) {
            return 0;
        }
        // 初始化结果、边界和符号变量
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        // 处理正负号
        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] != '+') {
            i = 0; // 如果第一个字符不是'+'，则起始索引为0
        }
        // 遍历字符数组，转换数字
        for (int j = i; j < c.length; j++) {
            // 如果遇到非数字字符，则退出循环
            if (c[j] < '0' || c[j] > '9') {
                break;
            }
            // 检查结果是否超出整数范围
            if (res > bndry || res == bndry && c[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 更新结果
            res = res * 10 + (c[j] - '0');
        }
        // 返回结果乘以符号
        return sign * res;
    }


}
