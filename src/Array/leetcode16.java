package Array;

import java.util.Arrays;
import java.util.Scanner;

public class leetcode16 {
    public int threeSumClosest(int[] nums, int target) {
return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int ans = 1;
            System.out.println(ans);
        }

    }

    public static int XiaoMinMostApple(int m, int n, int k) {
        int left = k - 1;
        int right = n - k;
        int used = n;
        int ans = 1;
        int left_num = 0;
        int right_num = 0;
        int index = 1;
        while (index <= n && used <= m) {
            ans++;
            used+=index;
            if (used>=m) {
                return used >m?ans-1:ans;
            }
            index += left_num >= left ? 0:1;
            index += right_num >= right ? 0:1;
            left_num++;
            right_num++;
        }
        return -1;
    }
}
