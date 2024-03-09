package Array;

/**
 * @author Judy
 * @create 2024-03-09-16:02
 */
public class leetcode27 {
    public static int removeElement(int[] nums, int val) {
        int remove = 0;

        int count = nums.length;
        for (int i = 0; i < count; i++) {
            if (nums[i]==val) {
                //遇到了需要移除的数
                remove++;
                for (int j = i; j < nums.length-1; j++) {
                    nums[j]=nums[j+1];
                }
                count--;
                i--;

            }
        }

        return nums.length-remove;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        System.out.println(removeElement(nums, 3));
    }
}
