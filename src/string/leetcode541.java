package string;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
public class leetcode541 {
    /**
     * 将字符串中每个长度为 k 的子串倒序排列。
     *
     * @param s 输入的字符串
     * @param k 子串的长度
     * @return 倒序排列后的新字符串
     */
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray(); // 将字符串转换为字符数组
        for(int i = 0;i < ch.length;i += 2 * k){
            int start = i;
            // 判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1,start + k - 1);
            while(start < end){
                // 交换start和end指向的字符
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;

                start++;
                end--;
            }
        }
        return new String(ch); // 将字符数组转换回字符串
    }

}
