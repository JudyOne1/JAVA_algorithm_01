package dynamic;

import java.util.Arrays;

public class leetcode122 {

    public int maxProfit(int[] prices) {
        int[] result = new int[prices.length-1];
        for (int i = 1; i < prices.length; i++) {
            result[i-1] = prices[i] - prices[i - 1];
        }
        Arrays.sort(result);
        return Math.max(result[result.length - 1], 0)+Math.max(result[result.length - 2], 0);
    }
}
