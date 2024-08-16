package SORT;

public class heapSort {

//    int[] heapsort(int[] nums) {
//        int len = nums.length;
//        //构建大顶堆
//        for (int i = len / 2 - 1; i >= 0; i--) {
//            heapify(nums, len, i);
//        }
//        //堆排序
//        for (int i = len - 1; i >= 0; i--) {
//            swap(nums, i, 0);
//            heapify(nums, i, 0);
//        }
//        return nums;
//    }
//
//    private void heapify(int[] nums, int len, int i) {
//        int largest = i;
//        int left = 2 * i + 1;
//        int right = 2 * i + 2;
//        if (left < len && nums[left] > nums[largest]) {
//            largest = left;
//        }
//        if (right < len && nums[right] > nums[largest]) {
//            largest = right;
//        }
//        if (largest != i){
//            swap(nums,largest,i);
//            heapify(nums,len,largest);
//        }
//    }

    void swap(int[] nums, int l, int r) {
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }

    void sort(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(nums, len, i);
        }
        for (int i = len - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
    }

    private void heapify(int[] nums, int len, int i) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < len && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < len && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, len, largest);
        }
    }



    public void heapSort(int[] nums) {
        //建堆
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify2(nums, len, i);
        }
        //排序
        for (int i = len - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapify2(nums, i, 0);

        }


    }

    private void heapify2(int[] nums, int len, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;

        if (left < len && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < len && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, largest, i);
            heapify2(nums, len, largest);
        }
    }


}
