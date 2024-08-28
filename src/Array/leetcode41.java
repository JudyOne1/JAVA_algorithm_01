package Array;

public class leetcode41 {
    /**
     * 我们将数组中所有小于等于 0 的数修改为 N+1
     * <p>
     * 我们遍历数组中的每一个数 x，它可能已经被打了标记，因此原本对应的数为 ∣x∣。如果 ∣x∣∈[1,N]，
     * 那么我们给数组中的第 ∣x∣−1 个位置的数添加一个负号。注意如果它已经有负号，不需要重复添加；
     * <p>
     * 在遍历完成之后，如果数组中的每一个数都是负数，那么答案是 N+1，否则答案是第一个正数的位置加 1。
     */
    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 将所有小于等于0的数替换为N+1
        //[3,4,-1,1] -> [3,4,5,1]
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        //[3,4,5,1]
        //[-3,4,-5,-1]
        // 标记出现的正整数（1到N），将其对应索引位置的数变为负数
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        //1+1 = 2
        // 找到第一个未被标记的位置，即缺失的正整数的位置
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        // 如果数组中所有位置都被标记，则返回N+1
        return n + 1;
    }

    public static void main(String[] args) {
        leetcode41 leetcode41 = new leetcode41();
        int[] nums = {3, 4, -1, 1};
        System.out.println(leetcode41.firstMissingPositive(nums));
    }
}
