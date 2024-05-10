package Array;

public class leetcode42 {
    //利用单调栈 | 前后缀分解 | 双指针
    public int trap(int[] height) {
        // 初始化和计算从左到右的最大高度数组preMax
        int n = height.length;
        int[] preMax = new int[n]; // preMax[i] 表示从 height[0] 到 height[i] 的最大值
        preMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], height[i]);
        }
        // 初始化和计算从右到左的最大高度数组sufMax
        int[] sufMax = new int[n]; // sufMax[i] 表示从 height[i] 到 height[n-1] 的最大值
        sufMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufMax[i] = Math.max(sufMax[i + 1], height[i]);
        }
        // 计算每个位置可以容纳的水量，并累加
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(preMax[i], sufMax[i]) - height[i]; // 累加每个水桶能接多少水
        }
        return ans;

    }

    public int trap2(int[] height) {
        // 初始化答案、左右指针、前缀最大值和后缀最大值
        int ans = 0, left = 0, right = height.length - 1, preMax = 0, sufMax = 0;
        // 当左右指针未交叉时继续循环
        while (left < right) {
            // 更新前缀最大值和后缀最大值
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            // 根据前缀最大值和后缀最大值的大小决定移动哪个指针，并累加答案
            if (preMax < sufMax) {
                ans += preMax - height[left];
                left++;
            } else {
                ans += sufMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
