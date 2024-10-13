package code;

public class bambooTest {
    class TrafficLight {
        private String color;//信号灯颜色

        public TrafficLight(String color) {
            this.color = color;
        }

        /**
         * 判断信号灯是否可以通行
         * @param inStopLine 是否越过停车线
         * @return 是否可以通行
         */
        public boolean canPass(boolean inStopLine) {
            if ("green".equals(color)) {
                return true;
            } else if ("red".equals(color)) {
                return false;
            } else if ("yellow".equals(color)) {
                return inStopLine;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        bambooTest bbt = new bambooTest();
        TrafficLight green = bbt.new TrafficLight("green");//绿灯
        System.out.println(green.canPass(true));

        TrafficLight red = bbt.new TrafficLight("red");//红灯
        System.out.println(red.canPass(true));

        TrafficLight yellowAndInStopLine = bbt.new TrafficLight("yellow");//黄灯+越过停车线
        System.out.println(yellowAndInStopLine.canPass(true));

        TrafficLight yellowAndNotInStopLine = bbt.new TrafficLight("yellow");//黄灯+未越过停车线
        System.out.println(yellowAndNotInStopLine.canPass(false));
        /*
         * 输出结果：
         * true
         * false
         * true
         * false
         */
    }

    class TrafficLightWithDirection {
        private String color;//信号灯颜色
        private String direction;//信号灯方向

        public TrafficLightWithDirection(String color, String direction) {
            this.color = color;
            this.direction = direction;
        }

        /**
         * 判断信号灯是否可以通行
         * @param inStopLine 是否在停车线
         * @param carDirection 汽车想要行驶的方向
         * @return 是否可以通行
         */
        public boolean canPass(boolean inStopLine, String carDirection) {
            if ("green".equals(color) && direction.equals(carDirection)) {
                //颜色为绿色且方向正确就可以通行
                return true;
            } else if ("red".equals(color)) {
                return false;
            } else if ("yellow".equals(color)) {
                //颜色为黄色并且越过停车线——绿灯时可以通行且方向正确，通行过程中变成黄灯了
                return inStopLine;
            }
            return false;
        }
    }
}
