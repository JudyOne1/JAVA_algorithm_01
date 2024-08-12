import java.util.Arrays;
import java.util.Random;

public class sortArray {
    //方法一、随机化快排
    // 创建一个Random对象，用于随机选择基准元素
    private final Random random = new Random();

    public int[] sortArray_1_quickSort(int[] nums) {
        //快排
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    // 快速排序函数
    void quickSort(int[] nums, int l, int r) {
        // 如果左边界小于右边界，说明数组中至少有两个元素，可以进行排序
        if (l < r) {
            // 调用partition函数，对数组进行分区，并获取基准元素的最终位置
            int pivot = partition(nums, l, r);
            // 对基准元素左边的子数组进行快速排序
            quickSort(nums, l, pivot - 1);
            // 对基准元素右边的子数组进行快速排序
            quickSort(nums, pivot + 1, r);
        }
    }

    // 分区函数
    int partition(int[] nums, int l, int r) {
        // 选择最右边的元素作为基准元素
        //int pivot = nums[r];//超时

        // **随机选择基准元素的下标
        int pivotIndex = random.nextInt(r - l + 1) + l;
        // 获取基准元素的值
        int pivot = nums[pivotIndex];
        //把基准元素换到最右边
        swap(nums, pivotIndex, r);

        // 初始化两个指针i和j
        int i = l, j = r;
        // 当i小于j时，进行循环
        while (i < j) {
            // 从左到右找到第一个大于等于pivot的元素
            while (i < j && nums[i] < pivot) i++;
            // 从右到左找到第一个小于等于pivot的元素
            while (i < j && nums[j] >= pivot) j--;
            // *调用是在while (i < j)的循环内部，所以当swap(nums, i, j)被执行时，i一定是小于j的。因此，这里不需要再额外判断i是否大于j。
            swap(nums, i, j);
        }
        // 当i等于j时，交换nums[i]和基准元素  把基准元素换回来
        swap(nums, i, r);
        // 返回基准元素的最终位置
        return i;
    }

    void swap(int[] nums, int l, int r) {
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }




    //方法二、堆排序
    /*
     排序其实主要有两个步骤
        1.建堆，通过下沉操作建堆效率更高，具体过程是，找到最后一个非叶子节点，然后从后往前遍历执行下沉操作。
        2.排序，将堆顶元素（代表最大元素）与最后一个元素交换，然后新的堆顶元素进行下沉操作，递归执行上诉操作，则可以完成排序。
     */
    public int[] sortArray_2_heapSort(int[] nums) {
        int len = nums.length;
        // 构建大顶堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(nums, len, i);
        }
        // 堆排序
        for (int i = len - 1; i >= 0; i--) {
            // 将当前最大的元素nums[0]交换到数组末尾
            swap(nums, 0, i);
            // 将剩余元素重新调整为大顶堆
            heapify(nums, i, 0);
        }
        return nums;
    }

    // 堆化函数，将以i为根的子树调整为大顶堆，下沉
    void heapify(int[] nums, int len, int i) {
        int largest = i;
        int left = 2 * i + 1;//左儿子
        int right = 2 * i + 2;//右儿子
        if (left < len && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < len && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {//需要交换，继续往下
            swap(nums, i, largest);
            // 递归调整被交换元素的子树
            heapify(nums, len, largest);
        }
        //没交换
    }




    //方法三、归并排序
//将数组分成两半，分别对它们进行排序，然后将结果合并。这个过程可以递归地进行，直到数组的长度为1（此时数组已经是有序的）
    public int[] sortArray_3_mergeSort(int[] nums) {
        // 如果数组的长度小于2，直接返回
        if (nums.length < 2) {
            return nums;
        }
        int mid = nums.length / 2;
        //对两部分分别进行排序，然后合并
        int[] l = Arrays.copyOfRange(nums, 0, mid);
        int[] r = Arrays.copyOfRange(nums, mid, nums.length);

        //**先分别对l和r递归排序，在合并
        l = sortArray_3_mergeSort(l);
        r = sortArray_3_mergeSort(r);
        //合并
        return merge(l, r);

    }

    //合并两个有序数组
    int[] merge(int[] l, int[] r) {
        int len1 = l.length, len2 = r.length;
        //工作索引
        int i = 0, j = 0, k = 0;
        int[] res = new int[len1 + len2];
        while (i < len1 && j < len2) {
            if (l[i] <= r[j]) res[k++] = l[i++];
            else res[k++] = r[j++];
        }

        //有个数组有剩余
        while (i < len1) {
            res[k++] = l[i++];
        }
        while (j < len2) {
            res[k++] = r[j++];
        }
        return res;
    }
}
