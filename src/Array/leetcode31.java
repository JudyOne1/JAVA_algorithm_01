package Array;

import java.util.Arrays;

public class leetcode31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length, k = n - 1;
        //从后往前找，找到第一个下降的位置【从后往前是升序,找到第一个转折点】
        while (k - 1 >= 0 && nums[k - 1] >= nums[k]) k--;
        if (k == 0) {
            reverse(nums, 0, n - 1);
        } else {
            //u 从 k 往后找，找到大于k的最小值
            int u = k;
            while (u + 1 < n && nums[u + 1] > nums[k - 1]) u++;
            //将两者交换。注意此时 k 以后的位置仍然是降序的
            swap(nums, k - 1, u);
            //直接将 k 以后的部分翻转（变为升序）
            reverse(nums, k, n - 1);
        }
    }

    void reverse(int[] nums, int a, int b) {
        int l = a, r = b;
        while (l < r) swap(nums, l++, r--);
    }

    void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
//    public void nextPermutation(int[] nums) {
//        //找到最末端的逆序点【2,4,5,1,3,6,5,1】【2,4,5,1,6,3,5,1】
//        //【1.3.2.4】【1.3.4.2】
//        //【1.3.2.1】【2.1.1.3】
//        //11332 12133
//        //11333 13133
//        //【11321】【12113】
//        //降序排序->直接sort排序
//        if (nums.length == 0 || nums.length == 1) {
//            return;
//        }
//        int last = -1;
//        for (int i = 1; i < nums.length - 1; i++) {
//
//            if (nums[i] >= nums[i + 1] && nums[i] >= nums[i - 1]) {
//                last = i;
//            }
//        }
//
//        if (nums[nums.length - 1] > nums[nums.length - 1 - 1]) {
//            last = nums.length - 1;
//        }
//        boolean flag = false;
//
//        if (last == -1) {
//            Arrays.sort(nums);
//        } else {
//            //如果last往后是降序
//            for (int i = last; i < nums.length-1; i++) {
//                if (nums[i] >= nums[i+1]){
//                    flag = false;
//                }
//            }
//            int temp = nums[last];
//            nums[last] = nums[last - 1];
//            nums[last - 1] = temp;
//        }
//    }
}
