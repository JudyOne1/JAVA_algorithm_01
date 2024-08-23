package Array;

public class leetcode11 {
//    若向内 移动短板 ，水槽的短板 min(h[i],h[j]) 可能变大，因此下个水槽的面积 可能增大 。
//    若向内 移动长板 ，水槽的短板 min(h[i],h[j]) 不变或变小，因此下个水槽的面积 一定变小 。
//    因此，初始化双指针分列水槽左右两端，循环每轮将短板向内移动一格，并更新面积最大值，直到两指针相遇时跳出；即可获得最大面积。
    public int maxArea1(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) :
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;

    }


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
