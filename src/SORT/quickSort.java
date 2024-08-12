package SORT;

import java.util.Random;

public class quickSort {
    int[] quicksort(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        process(nums, l, r);
    }

    private void process(int[] nums, int l, int r) {
        if (l > r) {
            return;
        }
        int index = partition(nums, l, r);
        process(nums, l, index - 1);
        process(nums, index + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        Random random = new Random();
        int index = random.nextInt(r - l + 1) + l;
        int indexNumber = nums[index];
        swap(nums, index, r);
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[i] < indexNumber) i++;
            while (i < j && nums[j] >= indexNumber) j--;
            swap(nums, i, j);
        }
        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int index, int r) {
        int temp = nums[index];
        nums[index] = nums[r];
        nums[r] = temp;
    }
}
