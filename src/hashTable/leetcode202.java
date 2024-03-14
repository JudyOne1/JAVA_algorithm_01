package hashTable;

import java.util.HashSet;

public class leetcode202 {
    public boolean isHappy(int n) {
        int num = n;
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;
            while (num != 0) {
                sum += (num % 10) * (num % 10);
                num /= 10;
            }
            if (sum == 1){
                return true;
            }
            if (set.contains(sum)){
                return false;
            }else {
                set.add(sum);
            }
            num = sum;
        }
    }
}
