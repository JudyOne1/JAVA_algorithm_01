package SORT;

public class heapSort {
    int[] sort4(int[] nums) {
        //建堆
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify4(nums, len, i);
        }

        //堆排序
        for (int i = len - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapify4(nums, i, 0);
        }
        return nums;

    }

    private void heapify4(int[] nums, int len, int i) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < len && nums[left] > nums[largest]){
            largest = left;
        }
        if (right < len && nums[right] > nums[largest]){
            largest = right;
        }
        if (largest != i){
            swap(nums,len,largest);
            heapify(nums,len,largest);
        }
    }

    int[] heapsort(int[] nums) {
        int len = nums.length;
        //构建大顶堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(nums, len, i);
        }
        //堆排序
        for (int i = len - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
        return nums;
    }

    private void heapify3(int[] nums, int len, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
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

    void swap(int[] nums, int l, int r) {
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }

    void sort(int[] nums) {
        int len = nums.length;
        // 从数组的一半位置开始，逐个调整节点，使其满足最大堆的性质
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(nums, len, i);
        }
        // 每次将最大元素（位于堆的根节点）与堆的最后一个元素交换，然后重新调整堆
        for (int i = len - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
    }

    private void heapify(int[] nums, int len, int i) {
        int largest = i; // 默认当前节点为最大
        int left = i * 2 + 1; // 左子节点索引
        int right = i * 2 + 2; // 右子节点索引
        // 如果左子节点存在且大于当前最大节点，则更新最大节点
        if (left < len && nums[left] > nums[largest]) {
            largest = left;
        }
        // 如果右子节点存在且大于当前最大节点，则更新最大节点
        if (right < len && nums[right] > nums[largest]) {
            largest = right;
        }
        // 如果最大节点不是当前节点，则交换它们，并递归调整受影响的子树
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
