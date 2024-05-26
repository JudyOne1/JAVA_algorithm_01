package ListNode;

import java.util.HashMap;

public class leetcode167 {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int cur = numbers[i];
            if (map.containsKey(target - cur) && map.get(target - cur).intValue() < i) {
                return new int[] { map.get(target - cur) + 1, i + 1 };
            }
            map.put(cur, i);
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] nums = {0,2, 7, 11, 15};
        int target = 9;
        leetcode167 leetcode167 = new leetcode167();
        int[] res = leetcode167.twoSum(nums, target);
    }
}
