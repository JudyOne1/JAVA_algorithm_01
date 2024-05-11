package Array;

import java.util.Scanner;

public class meituan02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int times = in.nextInt();
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int plus = in.nextInt();
            int maxNumber = in.nextInt();
            if (plus == 0){
                System.out.println(1);
                continue;
            }
            if (maxNumber == 1){
                System.out.println(1);
                continue;
            }
            System.out.println(dfs(maxNumber, 1, 1, plus));


        }
        int a = 2;
        int b = 3;
        int c = 1;
        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            a = in.nextInt();
//            b = in.nextInt();
//            c = in.nextInt();
//        }
        int an = a;
        int ac = a;
        while (an != 1){
            ac = ac * (a-1);
            a--;
            an--;
        }
        int bn = b;
        int bc = b;
        while (bn != 1){
            bc  =  bc * (b-1);
            b--;
            bn--;
        }
        //分别求a 和 b 的阶乘


        a = ac;
        b = bc;
        if (c == 1){
            c = a;
            int count = 0;
            for (int i = c; i > 0; i--) {
                //求 number 的因子
                if (c % i == 0){
                    count++;
                }
            }
            System.out.println(count);
        }
        if (c == 2){
            c = b;
            int count = 0;
            for (int i = c; i > 0; i--) {
                //求 number 的因子
                if (c % i == 0){
                    count++;
                }
            }
            System.out.println(count);
        }
        int[] arr = new int[c+1];
        arr[1] = a;
        arr[2] = b;
        for (int i = 3; i < c+1; i++) {
            arr[i] = arr[i-1] * arr[i-2];
        }
        c = arr[c];
        //求 number 的因子
        int count = 0;
        for (int i = c; i > 0; i--) {
            //求 number 的因子
            if (c % i == 0){
                count++;
            }
        }

        System.out.println(count);







    }

    public static int dfs(int maxNumber, int nowNumber, int number, int count) {

        if (count == 0) {
            if (qumo(number) == 1) {
                return 1;
            }
            return 0;
        }
        if (count < 0){
            return 0;
        }

        if (nowNumber > maxNumber) {
            return 0;
        }

        return dfs(maxNumber, nowNumber, number * nowNumber, count - 1)+
                dfs(maxNumber, nowNumber + 1, number * nowNumber, count - 1);

    }

    public static int qumo(int number) {
        while (number > 10) {
            number = number % 10;
        }
        return number;
    }

}
