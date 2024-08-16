package SORT;

import java.util.Arrays;

public class mergeSort {
    int[] sort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int mid = nums.length / 2;

        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);

        left = sort(left);
        right = sort(right);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int lLen = left.length;
        int rLen = right.length;
        int i = 0, j = 0, k = 0;
        int[] res = new int[lLen + rLen];
        while (i < lLen && j < rLen) {
            if (left[i] <= right[j]) {
                res[k++] = left[i++];
            } else {
                res[k++] = right[j++];
            }
        }
        while (i < lLen) {
            res[k++] = left[i++];
        }
        while (j < rLen) {
            res[k++] = right[j++];
        }
        return res;
    }


    public int[] mergeSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int mid = nums.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));
        return merge1(left, right);
    }

    private int[] merge1(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int lLen = left.length;
        int rLen = right.length;
        int i = 0, j = 0, k = 0;
        while (i < lLen && j < rLen) {
            if (left[i] >= right[j]) {
                res[k++] = right[j++];
            } else {
                res[k++] = left[i++];
            }
        }
        while (i < lLen){
            res[k++] = left[i++];
        }
        while (j < rLen){
            res[k++] = right[j++];
        }

        return res;
    }


}
