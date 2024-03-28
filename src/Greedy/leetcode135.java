package Greedy;

public class leetcode135 {
    public int candy(int[] ratings) {
        int sum = ratings.length;
        for (int i = 0; i < ratings.length; i++) {

            if (i==0){
                //第一
                if (ratings[i]>ratings[i+1]){
                    sum++;
                }
            } else if (i==ratings.length-1){
                //最后
                if (ratings[i]>ratings[i-1]){
                    sum++;
                }
            }
            else {
                if (ratings[i]>ratings[i-1]&&ratings[i]>ratings[i+1]){
                    sum++;
                }else if (ratings[i]>=ratings[i-1]&&ratings[i]>ratings[i+1]){
                    sum++;
                } else if (ratings[i]>ratings[i-1]&&ratings[i]>=ratings[i+1]) {
                    sum++;
                }
            }

        }
        return sum;
    }
}
