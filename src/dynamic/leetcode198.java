package dynamic;

public class leetcode198 {
    public int rob(int[] nums) {
        return process(nums, 0);
    }

    public int process(int[] nums, int index) {
        if (index == nums.length - 1) {
            return nums[index];
        }
        if (index >= nums.length) {
            return 0;
        }
        int p1 = process(nums, index + 1);//不抢当前这家 1 3
        int p2 = process(nums, index + 2) + nums[index];//抢当前这家 0  2

        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        System.out.println(new leetcode198().rob(new int[]{1, 2, 3, 1}));
    }
}
