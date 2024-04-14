package Array;

public class leetcode11 {
    public int maxArea(int[] height) {
        // 初始化最大面积、左指针和右指针
        int ans = 0, left = 0, right = height.length - 1;
        // 当左指针小于右指针时循环，遍历整个数组
        while (left < right) {
            // 计算当前左右指针形成的容器的面积
            int area = (right - left) * Math.min(height[left], height[right]);
            // 更新最大面积
            ans = Math.max(ans, area);
            if (height[left] < height[right]) {
                // 如果左指针指向的高度小于右指针指向的高度，则左指针右移
                ++left;
            } else {
                // 如果左指针指向的高度大于等于右指针指向的高度，则右指针左移
                --right;
            }
        }
        // 返回最大面积
        return ans;
    }
}
