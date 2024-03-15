package stackAndList;

import java.util.LinkedList;
import java.util.Queue;


public class TwoQueueStack<T> {
    public Queue<T> queue;
    public Queue<T> help;

    public TwoQueueStack() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(T value) {//正常加
        queue.offer(value);//相当于add()，只不过有问题会报错
    }

    public T poll() {
        while (queue.size() > 1) {//留下最后一个
            help.offer(queue.poll());//除最后一个外，将其他数据放到另一个队列中
        }
        T ans = queue.poll();//取出最后一个
        //交换队列
        Queue<T> tmp = queue;
        queue = help;
        help = tmp;
        //返回值
        return ans;
    }

    public T peek() {
        while (queue.size() > 1) {
            help.offer(queue.poll());
        }
        T ans = queue.poll();
        help.offer(ans);
        Queue<T> tmp = queue;
        queue = help;
        help = tmp;
        return ans;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

}
