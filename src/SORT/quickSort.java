package SORT;

import java.util.Random;

public class quickSort {
    int[] quicksort(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        process(nums, l, r);
        return nums;
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


    void quickSort1(int[] nums) {
        int l = 0, r = nums.length - 1;
        process1(nums, l, r);
    }

    private void process1(int[] nums, int l, int r) {
        if (l > r) {
            return;
        }
        int index = getIndex(nums, l, r);
        process1(nums, l, index - 1);
        process1(nums, index + 1, r);
    }

    Random random = new Random();

    private int getIndex(int[] nums, int l, int r) {
        int index = random.nextInt(r - l + 1) + l;
        int indexNumber = nums[index];
        swap(nums, index, r);
        int i = l;
        int j = r;
        while (i < j) {
            while (i < j && nums[i] < indexNumber) i++;
            while (i < j && nums[j] >= indexNumber) j--;
            swap(nums, i, j);
        }
        swap(nums, i, r);
        return i;
    }

    public void quickSort2(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int index = getIndex2(nums, left, right);
        quickSort2(nums, left, index - 1);
        quickSort2(nums, index + 1, right);

    }

    private int getIndex2(int[] nums, int left, int right) {
        int index = new Random().nextInt(right - left + 1) + left;
        int indexNum = nums[index];
        swap(nums, index, right);
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && indexNum > nums[i]) {
                i++;
            }
            while (i < j && indexNum <= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        swap(nums, i, right);

        return i;
    }


}
