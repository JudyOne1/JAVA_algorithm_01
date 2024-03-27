package Greedy;


public class leetcode376 {

    public int wiggleMaxLength(int[] nums) {
        // 如果数组为空，则直接返回0
        if (nums.length == 0) return 0;
        int max = 1; // 记录最大波动序列长度
        int count = 1; // 记录当前波动序列的长度
        boolean flag = true; // 标志位，用于区分下一个递增还是递减序列，不断交替

        // 遍历数组，从第二个元素开始
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] == nums[index - 1]){
                continue;
            }
            // 如果当前元素小于前一个元素，则标志位设为false，表示接下来应递减
            if (nums[index] < nums[index - 1]){
                flag = false;
            }
            // 在当前元素之后的所有元素中，根据标志位判断递增还是递减，计算波动序列长度
            for (int i = index; i < nums.length; i++) {
                if (flag) {
                    // 如果是递增序列，且当前元素大于前一个元素，则波动序列长度加一，并将标志位设为false
                    if (nums[i] > nums[i - 1]) {
                        count++;
                        flag = false;
                    }
                } else {
                    // 如果是递减序列，且当前元素小于前一个元素，则波动序列长度加一，并将标志位设为true
                    if (nums[i] < nums[i - 1]) {
                        count++;
                        flag = true;
                    }
                }
            }
            // 更新最大波动序列长度，并重置当前波动序列长度
            max = Math.max(max, count);
            count = 1;
        }

        return max;
    }
}
