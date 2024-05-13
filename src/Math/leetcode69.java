package Math;

public class leetcode69 {
    public int mySqrt(int x) {
        // 将x的初始猜测值设为x本身
        long y = x;
        // 通过牛顿迭代法找到x的平方根
        while (y * y > x) {
            y = (y + x / y) / 2; // 更新y的值，逐渐接近真实的平方根
        }
        return (int)y; // 将找到的平方根转换为整数并返回
    }
}
