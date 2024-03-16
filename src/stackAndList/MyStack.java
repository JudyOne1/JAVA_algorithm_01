package stackAndList;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    public Queue queue;
    public Queue help;

    public MyStack() {
        this.queue = new LinkedList<Integer>();
        this.help = new LinkedList<Integer>();
    }

    public void push(int x) {
        this.queue.offer(x);
    }

    public int pop() {
        if (queue.size()>1){
            while (queue.size()>1){
                help.offer(queue.poll());
            }
            int res = (int) queue.poll();
            Queue temp = help;
            help = queue;
            queue = temp;
            return res;
        }else {
            return (int) queue.poll();
        }
    }

    public int top() {
        if (queue.size()>1){
            while (queue.size()>1){
                help.offer(queue.poll());
            }
            int res = (int) queue.peek();
            help.offer(queue.poll());
            Queue temp = help;
            help = queue;
            queue = temp;
            return res;
        }else {
            return (int) queue.peek();
        }
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}