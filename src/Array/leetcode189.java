package Array;

public class leetcode189 {
    public void rotate(int[] nums, int k) {    int n = nums.length;
        // 对k取模，确保k不超过数组长度，避免不必要的旋转
        k=k%(n);
        // 创建一个新数组，长度为原数组的两倍，用于辅助旋转
        int[] nums2 = new int[nums.length * 2];
        // 将原数组元素复制到新数组中，实现元素的“复制和粘贴”
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
            nums2[i + nums.length] = nums[i];
        }
        // 根据旋转的步数k，将新数组中的元素复制回原数组，完成旋转
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums2[i + n - k];
        }
    }
}
