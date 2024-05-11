package Array;

import java.util.Scanner;

public class meituan01 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        int n = in.nextInt();
        int[] array = new int[]{1,2,3,4,3,7,9,1,2};
        int n = 9;
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int a = in.nextInt();
//            array[count] = a;
//            count++;
//        }

        //清除三个连续的数组元素
        //helper 用来 保存 每个索引+左右两边的值
        int sum = 0;
        int[] helper = new int[n];
        for (int i = 1; i < n-1; i++) {
            helper[i] += array[i - 1] + array[i] + array[i + 1];
            sum+=array[i];
        }
        sum+=array[0];
        sum+=array[n-1];
        helper[0] = array[0] + array[1];
        helper[n-1] = array[n-1] + array[n-2];
        int max = 0;
        int maxInt = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, helper[i]);
            if (max == helper[i]){
                maxInt = i;
            }
        }
        sum-=max;
        int max2 = 0;
        int jian = 0;
        if (maxInt != 0||maxInt != n-1){
            jian = 3;
        }else {
            jian = 2;
        }
        int[] newArray = new int[n-jian];
        for (int i = 0; i < newArray.length; i++) {
            //新建一个数组来保存剩余元素
            if (maxInt == 0){
                newArray[i] = array[i+2];
            }else if (maxInt == n-1){
                newArray[i] = array[i];
            }else{
                if (i == maxInt - 1){
                    newArray[i] = array[i+3];
                    if (i + 4 < n) {
                        newArray[i + 1] = array[i + 4];
                        i += 1;
                    }
                    if (i + 5 < n) {
                        newArray[i + 2] = array[i + 5];
                        i += 2;
                    }
                    if (i >= newArray.length-1){
                        break;
                    }
                }else {
                    newArray[i] = array[i];
                }
            }

        }
        n = newArray.length;;
        helper = new int[n];
        for (int i = 1; i < n-1; i++) {
            helper[i] += newArray[i - 1] + newArray[i] + newArray[i + 1];
        }
        helper[0] = newArray[0] + newArray[1];
        helper[n-1] = newArray[n-1] + newArray[n-2];
        max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, helper[i]);
        }
        sum-=max;

        System.out.println(sum);








//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        int n = 0, a = 0, b = 0;
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            n = in.nextInt();
//            a = in.nextInt();
//            b = in.nextInt();
//
//        }
//        String MEI = "mei";
//        int MEI_LENGTH = 3;
//        String TUAN = "tuan";
//        int TUAN_LENGTH = 4;
//        if (MEI_LENGTH * a + TUAN_LENGTH * b >= n){
//            System.out.println(-1);
//            return;
//        }else{
//            StringBuilder stringBuilder = new StringBuilder();
//            for (int i = 0; i < a; i++) {
//                stringBuilder.append(MEI);
//            }
//            for (int i = 0; i < b; i++) {
//                stringBuilder.append(TUAN);
//            }
//            n = n-MEI_LENGTH*a-TUAN_LENGTH*b;
//            while (n>0){
//                stringBuilder.append("a");
//                n--;
//            }
//            System.out.println(stringBuilder.toString());
//        }
    }
}
