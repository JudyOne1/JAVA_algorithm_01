package Greedy;

public class leetcode45 {
    //https://leetcode.cn/problems/jump-game-ii/solutions/9347/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10
    public int jump2(int[] nums) {
        int curRange = 0;
        int maxRange = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            maxRange = Math.max(maxRange, nums[i] + i);
            if (i == curRange) { //遇到边界，就更新边界，并且步数加一
                curRange = maxRange;
                steps++;
            }
        }
        return steps;
    }

    public int jump1(int[] nums) {

        int count = 0;
        int curRange = 0, maxRange = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找到下一跳能跳最远的地方
            maxRange = Math.max(maxRange, i + nums[i]);

            if (maxRange >= nums.length - 1) {
                count++;
                break;
            }
            //跳到最远的地方
            if (i == curRange) {
                curRange = maxRange;
                count++;
            }
        }
        return count;
    }

    /**
     * 统计两个覆盖范围，当前这一步的最大覆盖和下一步最大覆盖。
     * 两个覆盖范围的意义在于，在内区域，最多两步一定可以到（不用管具体怎么跳，反正一定可以跳到）
     */
    public int jump(int[] nums) {

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        //记录跳跃的次数
        int count = 0;
        //当前的覆盖最大区域
        int curDistance = 0;
        //最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance, i + nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxDistance >= nums.length - 1) {
                count++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i == curDistance) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }
}
