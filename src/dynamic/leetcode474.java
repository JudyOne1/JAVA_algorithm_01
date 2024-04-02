package dynamic;

import java.util.LinkedList;

public class leetcode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        return process(strs,m,n,0,0);
    }


    public int dp(String[] strs, int m, int n){
        int[][] dp = new int[m+1][n+1]; // 初始化动态规划数组 dp，dp[i][j] 表示使用前 i 个字符串和前 j 个字符串能组成的最长公共子序列的长度。
        int oneNum, zeroNum;
        for (String str : strs) { // 遍历每个字符串
            oneNum = countONE(str); // 统计当前字符串中字符 '1' 的个数
            zeroNum = countZERO(str); // 统计当前字符串中字符 '0' 的个数
            for (int i = m; i >= zeroNum; i--) { // 从最大长度开始，递减遍历
                for (int j = n; j >= oneNum; j--) { // 同样从最大长度开始，递减遍历
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1); // 更新 dp[i][j] 的值
                }
            }
        }
        return dp[m][n]; // 返回最长公共子序列的长度
    }



    //超出时间限制
    public int process(String[] strs, int m, int n, int index,int size){
        if (m<0||n<0){
            return -1;
        }
        if (size == strs.length){
            return size;
        }
        if (index == strs.length){
            return size;
        }
        int p1 = 0;
        int p2 = process(strs,m,n,index+1,size);
        int next = process(strs,m-countZERO(strs[index]),n-countONE(strs[index]),index+1,++size);
        if (next!=-1){
            p1 = next;
        }
        return Math.max(p1,p2);
    }
    public int countONE(String str){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }
    public int countZERO(String str){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='0'){
                count++;
            }
        }
        return count;
    }
}
