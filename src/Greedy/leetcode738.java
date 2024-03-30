package Greedy;

public class leetcode738 {
    /**
     * 该方法用于找到比给定整数n小的最大整数，满足其各个位上的数字递增。
     * 例如，如果n为1234，返回值为1239；如果n为1345，返回值为1299。
     *
     * @param n 给定的整数
     * @return 比n小且各位数字递增的最大整数
     */
    public int monotoneIncreasingDigits(int n) {
        // 将整数n转换为字符串
        String s = String.valueOf(n);
        char[] chars = s.toCharArray(); // 将字符串转换为字符数组

        int start = s.length(); // 初始化start为字符串s的长度，用于记录需要变为9的数字的起始位置
        // 从倒数第二个字符开始向前遍历，寻找第一个左边位数字大于右边位数字的位置
        for (int i = s.length() - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--; // 将该位置的数字减一
                start = i+1; // 更新起始位置
            }
        }
        // 将起始位置之后的所有数字置为9
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        // 将字符数组转换回整数并返回
        return Integer.parseInt(String.valueOf(chars));
    }
}
